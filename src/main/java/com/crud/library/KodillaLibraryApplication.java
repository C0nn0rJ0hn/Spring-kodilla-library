package com.crud.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class KodillaLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodillaLibraryApplication.class, args);
		System.out.println(org.hibernate.Version.getVersionString());
	}
}
