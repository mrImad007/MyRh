package com.project.MyRh.Configuration.Cloudinary;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
public interface FileUpload {
    String uploadFile(MultipartFile multipartFile) throws IOException;
}
