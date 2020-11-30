package sk.mysterum.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.mysterum.backend.requestmodel.ExerciseFile;
import sk.mysterum.backend.requestmodel.GenericResponse;

import sk.mysterum.backend.services.FileService;

import sk.mysterum.backend.exception.FileAlreadyExistsException;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@CrossOrigin
public class FileController {

    @Autowired
    private FileService fileService;


    @PostMapping("/upload")
    public GenericResponse<String> uploadFile(@RequestBody ExerciseFile exerciseFile) throws FileAlreadyExistsException, MessagingException {
        try {
            fileService.uploadFile(fileService.dataToFile(exerciseFile.getData(), exerciseFile.getFilename()), exerciseFile.getUserName(), exerciseFile.getDay());
        } catch (IOException e) {
            e.printStackTrace();
            return new GenericResponse<>("There was an error while uploading your file: " + e.getMessage());
        }
        return new GenericResponse<>("File Uploaded");

    }
}
