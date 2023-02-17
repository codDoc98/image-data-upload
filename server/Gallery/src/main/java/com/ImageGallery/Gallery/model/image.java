package com.ImageGallery.Gallery.model;




import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@EntityScan
@NoArgsConstructor
@Data
@AllArgsConstructor
public class image {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank(message="Enter your caption")
	private String caption;
	
    private String name;
    
    private String type;    
    
    @Lob
    @Column(name="Pic", length=Integer.MAX_VALUE)
    private byte[] picByte;
    
    public image() {
    	
    }

	public image( String caption, String name, String type, byte[] picByte) {
		super();
		this.caption = caption;
		this.name = name;
		this.type = type;
		this.picByte = picByte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
    
	
	
	
	
	

}
