package com.test.task;

import com.test.task.controller.ConsoleController;
import com.test.task.test.TestDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Autowired
    private ConsoleController consoleController;
    @Autowired
    private TestDataGenerator testDataGenerator;

    @Override
    public void run(String... args) throws Exception {
        testDataGenerator.generateTestData();
        consoleController.startConsole();
    }
}
