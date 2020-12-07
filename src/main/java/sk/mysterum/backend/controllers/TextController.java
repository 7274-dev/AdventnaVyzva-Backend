package sk.mysterum.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.mysterum.backend.exception.WrongPasswordException;
import sk.mysterum.backend.requestmodel.Day;
import sk.mysterum.backend.requestmodel.GenericResponse;
import sk.mysterum.backend.model.TextModel;
import sk.mysterum.backend.services.TextService;



@RestController
@CrossOrigin
public class TextController {
    @Autowired
    private TextService srvc;

    private Integer latestVersion = 12;

    public static final String PASSWORD = "KUBOJESUPER";

    @GetMapping("/text")
    public GenericResponse<String> getTextForDay(@RequestParam int day) {
            return new GenericResponse<>(srvc.getTextByDay(day).get(0).getText());
    }

    @GetMapping("/ver")
    public GenericResponse<Integer> getLatestVersion(){
        return new GenericResponse<Integer>(latestVersion);
    }

    @PostMapping("/db")
    public TextModel putTextToDatabase(@RequestBody Day day) throws WrongPasswordException {

        if (!PASSWORD.equals(day.getPassword())){
            throw new WrongPasswordException();
        }

        srvc.deleteDay(day.getDay());
        return srvc.addDay(day.getDay(), day.getBody());
    }
}
