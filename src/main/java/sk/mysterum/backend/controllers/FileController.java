package sk.mysterum.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sk.mysterum.backend.services.FileService;

import sk.mysterum.backend.exception.FileAlreadyExistsException;

@RestController
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/")
    public String index(){return "upload";}

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("File") MultipartFile file, RedirectAttributes redirectAttributes) throws FileAlreadyExistsException {

        fileService.uploadFile(file);
        return "File uploaded";

    }
}
