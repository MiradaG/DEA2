package org.example.dea2.service.serviceImpl;


import jakarta.transaction.Transactional;
import org.example.dea2.entity.Image;
import org.example.dea2.service.ImageService;
import org.example.dea2.dto.response.ApiResponse;
import org.example.dea2.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;


    @Override
    public ApiResponse upload(MultipartFile file) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            Image image = new Image();
            image.setName(UUID.randomUUID().toString());
            image.setData(file.getBytes());
            imageRepository.save(image);
            apiResponse.setMessage("successfully uploaded");
            apiResponse.setStatus(200);
            apiResponse.setImageName(image.getName());
            return apiResponse;
        } catch (IOException e) {

            apiResponse.setMessage("Image upload failed");
            apiResponse.setStatus(400);
            return apiResponse;
        }
    }

    @Override
    public ResponseEntity<byte[]> getImage(String imageName) {
        Optional<Image> byName = imageRepository.findByName(imageName);
        if (!byName.isPresent()) {
            return null;
        }

        Image image = byName.get();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getName() + "\"");

        return ResponseEntity.ok()
                .headers(headers)
                .body(image.getData());
    }

    @Override
    @Transactional
    public void deleteImage(String imageName) {
        imageRepository.deleteByName(imageName);
    }

}
