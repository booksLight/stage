package org.nurture.estore.util;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.nurture.estore.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

	private static final Logger logger = LoggerFactory.getLogger(FileUpload.class);
	
	
    public String process(MultipartFile file, String prodFileName) {
        if (!file.isEmpty()) {
            String contentType = file.getContentType().toString().toLowerCase();
            if (isValidContentType(contentType)) {
                if (belowMaxFileSize(file.getSize())) {
                  	 String newFile = Constants.UPLOAD_FILE_PATH + prodFileName;
                    try {
                        file.transferTo(new File(newFile));
                        logger.debug(" \nYou have successfully uploaded " + file.getOriginalFilename() + "into the Path "+Constants.UPLOAD_FILE_PATH+"!");
                    } catch (IllegalStateException e) {
                    	 logger.debug(" \nThere was an error uploading " + file.getOriginalFilename() + " => " + e.getMessage());
                    } catch (IOException e) {
                       logger.debug(" \n There was an error uploading " + file.getOriginalFilename() + " => " + e.getMessage());
                    }
                } else {
                	 logger.debug(" \nError. " + file.getOriginalFilename() + " file size (" + file.getSize() + ") exceeds " +Constants.MAX_FILE_SIZE + " limit.");
                }
            } else {
            	 logger.debug(" \nError. " + contentType + " is not a valid content type.");
            }
        } else {
        	 logger.debug(" \nError. No file choosen.");
        }
        return null;
    }
    
    
    // Validations
    private Boolean isValidContentType(String contentType) {
        if (!Arrays.asList(Constants.ALLOWED_FILE_TYPES).contains(contentType)) {
            return false;
        }
        
        return true;
    }
       
  //Validation image Size
    private Boolean belowMaxFileSize(Long fileSize) {
        if (fileSize > Constants.MAX_FILE_SIZE) {
            return false;
        }
        
        return true;
    }
  
}
