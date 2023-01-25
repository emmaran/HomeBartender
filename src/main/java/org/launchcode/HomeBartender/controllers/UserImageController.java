package org.launchcode.HomeBartender.controllers;

import org.apache.coyote.Response;
import org.launchcode.HomeBartender.Service.UserImageStorageService;
import org.launchcode.HomeBartender.models.UserImageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

@Controller
//@RestController
@RequestMapping("/recipe/image")
public class UserImageController {

    @Autowired
    private UserImageStorageService service;

    public ResponseEntity<?> uploadImage(@RequestParam("image") UserImageData file) throws IOException {
        String uploadImage = service.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
        byte[] imageData = service.downloadImage(fileName);

//        System.out.println(Arrays.toString(imageData));

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/jpg"))
                .body(imageData);

    }
}
