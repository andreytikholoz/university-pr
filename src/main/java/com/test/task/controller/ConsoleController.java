package com.test.task.controller;

import com.test.task.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ConsoleController {

    @Autowired
    private UniversityService universityService;

    public void startConsole() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the command:");
            String input = scanner.nextLine();
            String[] splitInput = input.split(" ");

            if (input.startsWith("Who is head of department") && splitInput.length == 6) {
                universityService.findHeadOfDepartment(splitInput[5]);
            } else if (input.startsWith("Show") && input.endsWith("statistics.") && splitInput.length == 3) {
                universityService.departmentStatistics(splitInput[1]);
            } else if (input.startsWith("Show the average salary for the department") && splitInput.length == 8) {
                universityService.averageSalary(splitInput[7]);
            } else if (input.startsWith("Show count of employee for") && splitInput.length == 6) {
                universityService.countEmployee(splitInput[5]);
            } else if (input.startsWith("Global search by") && splitInput.length == 4) {
                universityService.globalSearch(splitInput[3]);
            } else {
                System.out.println("Wrong data");
            }
        }
    }
}
