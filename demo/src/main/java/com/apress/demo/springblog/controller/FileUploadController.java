package com.apress.demo.springblog.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;

public class FileUploadController {

    @PostMapping("/uploadMyFile")
    public String handleFileUpload(@RequestParam("myFile")MultipartFile file) {
        if (!file.isEmpty()) {
            String name = file.getOriginalFilename();
            try {
                byte[] bytes = file.getBytes();
                Files.write(new File(name).toPath(), bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/fileUpload";
    }
}
