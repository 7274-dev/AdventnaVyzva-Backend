package sk.mysterum.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sk.mysterum.backend.model.Response;
import sk.mysterum.backend.services.TextService;



@RestController
public class TextController {

    @Autowired
    private TextService srvc;

    @GetMapping("/text")
    public Response getTextForDay(@RequestParam int day){

        return new Response(srvc.getTextForDay(day));

    }
}
