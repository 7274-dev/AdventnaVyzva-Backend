package sk.mysterum.backend.services;

import org.springframework.stereotype.Service;
import sk.mysterum.backend.exception.UserAlreadyExistsException;
import sk.mysterum.backend.exception.UserDoesNotExistException;
import sk.mysterum.backend.model.OpenedDayWindowModel;
import sk.mysterum.backend.model.UserModel;
import sk.mysterum.backend.repositories.OpenedDayWindowRepository;
import sk.mysterum.backend.repositories.UserRepository;

import javax.naming.directory.InvalidAttributeIdentifierException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private OpenedDayWindowRepository windowRepository;

    private List<Integer> windowToInteger(List<OpenedDayWindowModel> windows) {
        List<Integer> windowIntegerList = new ArrayList<>();
        for (OpenedDayWindowModel windowModel : windows) {
            windowIntegerList.add(windowModel.getDayNumber());
        }
        return windowIntegerList;
    }

    public List<Integer> getOpenedWindows(String name) {
        List<UserModel> users = userRepository.findByNameEquals(name);
        if (users.isEmpty()) {
            return null;
        }

        UserModel targetUser = users.get(0);

        return windowToInteger(windowRepository.findByUserId(targetUser.getId()));
    }

    public void addUser(String name) throws UserAlreadyExistsException {
        if (userExists(name)) {
            throw new UserAlreadyExistsException();
        }
        UserModel model = new UserModel();
        model.setName(name);

        userRepository.save(model);
    }

    public boolean userExists(String name) {
        return !userRepository.findByNameEquals(name).isEmpty();
    }

    public void openWindow(Long userId, Integer day) throws InvalidAttributeIdentifierException {
        Optional<UserModel> optionalUserModel = userRepository.findById(userId);
        if (optionalUserModel.isEmpty()) {
            throw new InvalidAttributeIdentifierException();
        }
        UserModel model = optionalUserModel.get();
        OpenedDayWindowModel windowModel = new OpenedDayWindowModel();

        windowModel.setDayNumber(day);
        windowModel.setUserId(model.getId());

        windowRepository.save(windowModel);
    }

    public void openWindow(String username, Integer day) throws UserDoesNotExistException, InvalidAttributeIdentifierException {
        if (!userExists(username)) {
            throw new UserDoesNotExistException();
        }
        UserModel model = userRepository.findByNameEquals(username).get(0);
        openWindow(model.getId(), day);
    }
}
