package sk.mysterum.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.mysterum.backend.exception.WrongPasswordException;
import sk.mysterum.backend.requestmodel.Day;
import sk.mysterum.backend.requestmodel.Response;
import sk.mysterum.backend.model.TextModel;
import sk.mysterum.backend.services.TextService;



@RestController
@CrossOrigin
public class TextController {
    @Autowired
    private TextService srvc;

    public static final String PASSWORD = "KUBOJESUPER";

    @GetMapping("/text")
    public Response getTextForDay(@RequestParam int day) {
            return new Response(srvc.getTextByDay(day).get(0).getText());
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
