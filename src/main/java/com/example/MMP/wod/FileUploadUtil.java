package com.example.MMP.wod;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class FileUploadUtil {
    @Value("${upload.directory}")
    private String uploadDirPath;

    public void saveFile(String directoryPath, String fileName, MultipartFile file) throws IOException {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = directoryPath + File.separator + fileName;
        File dest = new File(filePath);
        file.transferTo(dest);
    }

    public String getUploadDirPath() {
        return uploadDirPath;
    }
}
