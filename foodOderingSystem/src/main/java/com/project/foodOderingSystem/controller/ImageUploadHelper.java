package com.project.foodOderingSystem.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageUploadHelper {
	public ImageUploadHelper() throws IOException {
		
	}
	    public String getUPLOAD_DIR() {
		return UPLOAD_DIR;
     	}
		public final String UPLOAD_DIR ="C:\\Users\\negia\\git\\foodOderingSystem\\foodOderingSystem\\src\\main\\resources\\static\\images";
	
	//making it dyamic 
//   	public final String UPLOAD_DIR = new ClassPathResource("src/main/resources/static/images/").getFile().getAbsolutePath();
    public boolean uploadFile(MultipartFile multipartFile) {
    	boolean f = false;
    	try {
    		
         Files.copy(multipartFile.getInputStream(),Paths.get( UPLOAD_DIR+File.separator + multipartFile.getOriginalFilename() ), StandardCopyOption.REPLACE_EXISTING);
    	 f=true;
    	}catch(Exception e) {
    		e.printStackTrace();
    	} 
		return f;  	
    }
}
