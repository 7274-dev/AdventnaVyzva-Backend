package sk.mysterum.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.mysterum.backend.exception.UserAlreadyExistsException;
import sk.mysterum.backend.exception.UserDoesNotExistException;
import sk.mysterum.backend.exception.WindowAlreadyOpenedException;
import sk.mysterum.backend.requestmodel.GenericResponse;
import sk.mysterum.backend.requestmodel.Window;
import sk.mysterum.backend.services.UserService;

import javax.naming.directory.InvalidAttributeIdentifierException;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/exists")
    public GenericResponse<Boolean> getUserExists(@RequestParam String userName) {
        return new GenericResponse<>(service.userExists(userName));
    }

    @GetMapping("/windows")
    public GenericResponse<List<Integer>> getWindowsOpened(@RequestParam String userName) throws UserDoesNotExistException {
        List<Integer> openedWindows = service.getOpenedWindows(userName);

        if (openedWindows == null) {
            throw new UserDoesNotExistException();
        }
        return new GenericResponse<>(openedWindows);
    }

    @GetMapping("/getcountries")
    public GenericResponse<String> getOpenedCountriesByDay(@RequestParam String userName){
        int highestDay = 0;
        List<Integer> openedWindows =  service.getOpenedWindows(userName);

        for (int window : openedWindows){
            if (window > highestDay){
                highestDay = window;
            }
        }

        return new GenericResponse<String>(service.getNameOfCountryByInt(highestDay));
    }

    @PostMapping("/openwindow")
    public GenericResponse<String> openWindow(@RequestBody Window window) throws WindowAlreadyOpenedException, UserDoesNotExistException, InvalidAttributeIdentifierException {
        if (service.getOpenedWindows(window.getUserName()).contains(window.getDay())) {
            throw new WindowAlreadyOpenedException();
        }

        service.openWindow(window.getUserName(), window.getDay());
        return new GenericResponse<>("Window opened");
    }

    @PostMapping("/add")
    public GenericResponse<String> addUser(@RequestBody String userName) throws UserAlreadyExistsException {
        if (service.userExists(userName)) {
            throw new UserAlreadyExistsException();
        }
        service.addUser(userName);
        return new GenericResponse<>("User created");
    }

}
