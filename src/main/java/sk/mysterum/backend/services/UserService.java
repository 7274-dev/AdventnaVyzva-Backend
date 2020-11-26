package sk.mysterum.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
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
            return new ArrayList<>();
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

    public String getNameOfCountryByInt(int dayNumber){

        switch (dayNumber){
            case 1:
                return "Norway";
            case 2:
                return "Norway";
            case 3:
                return "Sweden";
            case 4:
                return "Sweden";
            case 5:
                return "Denmark";
            case 6:
                return "Denmark";
            case 7:
                return "Denmark";
            case 8:
                return "Denmark";
            case 9:
                return "Germany";
            case 10:
                return "Czechia";
            case 11:
                return "Slovakia";
            case 12:
                return "Slovakia";
            case 13:
                return "Hungary";
            case 14:
                return "Austria";
            case 15:
                return "Italy";
            case 16:
                return "Croatia";
            case 17:
                return "Greece";
            case 18:
                return "Turkey";
            case 19:
                return "Turkey";
            case 20:
                return "Turkey";
            case 21:
                return "Israel";
            case 22:
                return "Israel";
            case 23:
                return "Bethlehem";
            case 24:
                return "JESUSSSS";
        }


        return "Invalid day";
    }
}
