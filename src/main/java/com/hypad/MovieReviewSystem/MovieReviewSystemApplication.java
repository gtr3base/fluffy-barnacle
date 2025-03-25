package com.hypad.MovieReviewSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MovieReviewSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieReviewSystemApplication.class, args);
	}

}
