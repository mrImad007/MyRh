package com.project.MyRh.Configuration.Cloudinary;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
public class FileUploadImpl implements FileUpload {
    private final Cloudinary cloudinary;
    @Autowired
    public FileUploadImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }
    @Override
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        return cloudinary.uploader()
                .upload(multipartFile.getBytes(),
                        Map.of("public_id", UUID.randomUUID().toString()))
                .get("url")
                .toString();
    }
}
