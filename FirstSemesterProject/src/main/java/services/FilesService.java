package services;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesService {

    private final String path = "C:\\Users\\anpud\\IdeaProjects\\semester_1\\FirstSemesterProject\\src\\main\\webapp\\images\\users\\";

    public void upload(String fileName, InputStream fileInputStream) {
        try {
            Files.copy(fileInputStream, Paths.get(path + fileName));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public boolean validFile(String realFileName) {
        int index = realFileName.lastIndexOf(".") + 1;
        String permission = realFileName.substring(index).toLowerCase();
        return permission.equals("jpg") || permission.equals("jpeg") || permission.equals("png");
    }
}
