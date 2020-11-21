package sk.mysterum.backend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.mysterum.backend.model.TextModel;
import sk.mysterum.backend.repositories.TextRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class TextService {
    @Autowired
    private TextRepository repository;
    public List<TextModel> getTextByDay(Integer day){
        return repository.findByDay(day);
    }
    public TextModel addDay(Integer day, String content){

        TextModel model = new TextModel();
        model.setDay(day);
        model.setText(content);

        return repository.save(model);
    }

    public void deleteDay(Integer day){
        repository.deleteByDay(day);
    }
}
