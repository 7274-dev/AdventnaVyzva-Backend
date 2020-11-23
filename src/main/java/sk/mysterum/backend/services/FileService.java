package sk.mysterum.backend.services;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sk.mysterum.backend.exception.FileAlreadyExistsException;

import javax.mail.Multipart;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
public class FileService {

    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

    public Boolean uploadFile(MultipartFile file) throws FileAlreadyExistsException {
        try{

            Path copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            return true;
            
        }catch (Exception e){ throw new FileAlreadyExistsException();}



    }

}
