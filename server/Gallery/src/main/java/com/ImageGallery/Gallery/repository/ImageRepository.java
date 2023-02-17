package com.ImageGallery.Gallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ImageGallery.Gallery.model.image;

public interface ImageRepository extends JpaRepository<image, Long>{

}
