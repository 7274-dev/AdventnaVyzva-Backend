package sk.mysterum.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.mysterum.backend.requestmodel.ExerciseFile;
import sk.mysterum.backend.requestmodel.GenericResponse;

import sk.mysterum.backend.services.FileService;

import sk.mysterum.backend.exception.FileAlreadyExistsException;

@RestController
@CrossOrigin
public class FileController {

    @Autowired
    private FileService fileService;


    @PostMapping("/upload")
    public GenericResponse<String> uploadFile(@RequestParam("name") String personName, @RequestParam("day") int personDay, @RequestPart ("File") MultipartFile file, @RequestBody ExerciseFile exerciseFile) throws FileAlreadyExistsException {

        fileService.uploadFile(file, personName, personDay);
        return new GenericResponse<>("File Uploaded");

    }
}
