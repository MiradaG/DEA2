package org.example.dea2.controller;

// Importing necessary packages and classes
import org.example.dea2.service.ImageService;
import org.example.dea2.dto.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

// Marking this class as a REST controller for handling HTTP requests
@RestController
// Allowing cross-origin requests to this controller
@CrossOrigin
// Defining the base URL path for this controller
@RequestMapping("api/v1/image")
public class ImageController {


    @Autowired
    private ImageService imageService;


    @PostMapping("/upload")
    public ApiResponse uploadFile(@RequestParam("file") MultipartFile file) {

        return imageService.upload(file);
    }

    /**
     * Endpoint to retrieve an image.

     */
    @GetMapping("/view/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {

        return imageService.getImage(imageName);
    }

    /**
     * Endpoint to delete an image.

     */
    @PostMapping("/delete/{imageName}")
    public void deleteImage(@PathVariable String imageName) {

        imageService.deleteImage(imageName);
    }
}
