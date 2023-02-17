package com.ImageGallery.Gallery.controller;


import java.io.*;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ImageGallery.Gallery.model.image;
import com.ImageGallery.Gallery.repository.ImageRepository;

import jakarta.validation.Valid;


@RestController
@CrossOrigin("http://localhost:3000")
public class ImageController {
	
	@Autowired
	private ImageRepository repo;

  @PostMapping(value={"/image"}, consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
  String saveImage( @RequestPart (value="caption") @Valid String caption,
		  @RequestPart(value= "Image")MultipartFile File) {  
      System.out.println("cap"+caption);
      
      try {
    	  image newpic=uploadImage(caption, File);
          repo.save(newpic);
          return "image saved"; 
      }
      catch(Exception e) {
          System.out.println(e.getMessage());
          return null;
      }      
  }
  
  
  public image uploadImage(String caption,MultipartFile pic) throws IOException {
      try {
    	  image newpic =new image( caption,
    			  pic.getOriginalFilename(),
    			  pic.getContentType(),
    			  pic.getBytes()
    			  );
      return newpic;
     }
      catch(Exception e){
          System.out.println(e.getMessage());
          return null;
          
      }
      
  }
	
	@GetMapping("/images")
	List<image> getAllimages(){
		return repo.findAll();
	}
	
	
	@DeleteMapping("image/{id}")
	String deleteUser(@PathVariable Long id) {
		if(!repo.existsById(id)) {
			return "Not found";
		}
		repo.deleteById(id);
		return "User with id "+id+" has been deleted successfully";
	}
	

}
