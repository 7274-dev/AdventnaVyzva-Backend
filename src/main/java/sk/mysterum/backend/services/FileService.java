package sk.mysterum.backend.services;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sk.mysterum.backend.exception.FileAlreadyExistsException;

import javax.mail.MessagingException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;


@Service
public class FileService {

    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;
    private MailService mail = new MailService();

    public void uploadFile(File file, String personName, int day) throws FileAlreadyExistsException {
        String filePath = file.getPath();
        Path copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(filePath));
        try {
            Files.copy(new FileInputStream(file), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            sendMail(copyLocation.toString(), personName, day);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    private void sendMail(String copyLocation, String personName, int day) throws MessagingException {
        mail.sendMessage("jtulek@at-rt.com", copyLocation, personName, day);

    }

    public File dataToFile(Byte[] data, String fileName) throws IOException {
        System.out.println(Arrays.toString(data));
        if (data == null) {
            return null;
        }
        File file = new File(fileName);

        // make sure it exists
        file.createNewFile();

        byte[] arr = new byte[data.length];
        // fuck
        for (int i = 0; i < data.length; i++) {
            arr[i] = data[i];
        }

        FileOutputStream stream = new FileOutputStream(file);
        stream.write(arr);
        stream.flush();
        stream.close();

        return file;
    }
}
