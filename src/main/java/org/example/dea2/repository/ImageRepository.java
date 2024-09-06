package org.example.dea2.repository;

import org.example.dea2.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> { // extending the JpaRepositary
    Optional<Image> findByName(String imageName);

    void deleteByName(String imageName);
}
