package com.test.task.controller;

import com.test.task.entity.LectorEntity;
import com.test.task.enums.Departments;
import com.test.task.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;
import java.util.stream.Collectors;

import static com.test.task.Constant.*;

@Controller
public class ConsoleController {

    @Autowired
    private UniversityService universityService;

    public void startConsole() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(CHOOSE_COMMAND);
            String input = scanner.nextLine();
            List<String> departmentsList = Arrays
                    .stream(Departments.values())
                    .map(Departments::getDegreeName)
                    .collect(Collectors.toList());

            switch (input) {
                case ONE:
                    System.out.println(ENTER_DEPARTMENT_NAME);
                    input = scanner.nextLine();
                    if (departmentsList.contains(input)) {
                        LectorEntity lectorEntity = universityService.findHeadOfDepartment(input);
                        System.out.println("Head of " + input + " department is " + lectorEntity.getFirstName() + " "
                                + lectorEntity.getLastName());
                    } else System.out.println(WRONG_DATA);
                    break;
                case TWO:
                    System.out.println(ENTER_DEPARTMENT_NAME);
                    input = scanner.nextLine();
                    if (departmentsList.contains(input)) {
                        Map<String, Integer> statistics = universityService.departmentStatistics(input);
                        System.out.println("assistants - " + statistics.get("assistants") +
                                "\nassociate professors - " + statistics.get("associate professors") +
                                "\nprofessors - " + statistics.get("professors"));
                    } else System.out.println(WRONG_DATA);
                    break;
                case THREE:
                    System.out.println(ENTER_DEPARTMENT_NAME);
                    input = scanner.nextLine();
                    if (departmentsList.contains(input)) {
                        double averageSalary = universityService.averageSalary(input);
                        System.out.println("The average salary of " + input + " is " + averageSalary);
                    } else System.out.println(WRONG_DATA);
                    break;
                case FOUR:
                    System.out.println(ENTER_DEPARTMENT_NAME);
                    input = scanner.nextLine();
                    if (departmentsList.contains(input)) {
                        int countEmployee = universityService.countEmployee(input);
                        System.out.println(countEmployee);
                    } else System.out.println(WRONG_DATA);
                    break;
                case FIVE:
                    System.out.println(ENTER_TEMPLATE);
                    input = scanner.nextLine();
                    Set<LectorEntity> lectors = universityService.globalSearch(input);
                    if (lectors.isEmpty()) {
                        System.out.println(NO_MATCHES);
                    } else
                        lectors.forEach(lector -> System.out.println(lector.getFirstName() + " " + lector.getLastName()));
                    break;
                case SIX:
                    Arrays.stream(Departments.values())
                            .map(Departments::getDegreeName)
                            .forEach(System.out::println);
                    break;
                default:
                    System.out.println(WRONG_DATA);
                    break;
            }
        }
    }
}

