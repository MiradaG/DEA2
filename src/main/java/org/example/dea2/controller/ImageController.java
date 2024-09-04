package org.example.dea2.controller;


import org.example.dea2.service.ImageService;
import org.example.dea2.dto.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("api/v1/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping("/upload")
    public ApiResponse uploadFile(@RequestParam("file") MultipartFile file) {
        return imageService.upload(file);
    }

    @GetMapping("/view/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        return imageService.getImage(imageName);
    }

    @PostMapping("/delete/{imageName}")
    public void deleteImage(@PathVariable String imageName) {
         imageService.deleteImage(imageName);
    }
}
