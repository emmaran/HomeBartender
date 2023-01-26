package org.launchcode.HomeBartender;

import org.launchcode.HomeBartender.controllers.RecipeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
public class HomeBartenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeBartenderApplication.class, args);
	}

}
//model is where I will create the objects
