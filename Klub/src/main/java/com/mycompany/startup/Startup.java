package com.mycompany.startup;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mycompany.controllers", "com.mycompany.startup"})
public class Startup {

    static final Logger logger = Logger.getLogger(Startup.class);

    public static void main(String[] args) throws FileNotFoundException, SQLException, IOException, ParseException {
        SpringApplication.run(Startup.class, args);
        logger.info("Application started");
    }

}
