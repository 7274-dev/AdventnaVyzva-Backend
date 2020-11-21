package sk.mysterum.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.mysterum.backend.exception.WrongPasswordException;
import sk.mysterum.backend.model.Response;
import sk.mysterum.backend.model.TextModel;
import sk.mysterum.backend.services.TextService;



@RestController
public class TextController {

    public static final String PASSWORD = "KUBOJESUPER";

    @Autowired
    private TextService srvc;

    @GetMapping("/text")
    public Response getTextForDay(@RequestParam int day){

        return new Response(srvc.getTextByDay(day).get(0).getText());

    }

    @PostMapping("/db")
    public TextModel putTextToDatabase(@RequestBody String text, @RequestBody String password, @RequestBody Integer day) throws WrongPasswordException {

        if (!PASSWORD.equals(password)){
            throw new WrongPasswordException();
        }


        return srvc.addDay(day, text);
    }
}
