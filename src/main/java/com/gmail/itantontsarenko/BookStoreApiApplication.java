package com.gmail.itantontsarenko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootApplication
public class BookStoreApiApplication {
    private final static Logger LOGGER = LoggerFactory.getLogger(BookStoreApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApiApplication.class, args);
        ApplicationModules.of(BookStoreApiApplication.class)
                .forEach(module -> LOGGER.info("Detected module: {}", module.getDisplayName()));
	}

}
