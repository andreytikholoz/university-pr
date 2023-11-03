package com.test.task.service;

import com.test.task.entity.DepartmentEntity;
import com.test.task.entity.LectorEntity;
import com.test.task.enums.AcademicDegree;
import com.test.task.repository.DepartmentRepository;
import com.test.task.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UniversityService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private LectorRepository lectorRepository;

    public void findHeadOfDepartment(String departmentName) {
        DepartmentEntity department = departmentRepository.findByName(departmentName);
        LectorEntity lectorEntity = department.getHead();
        System.out.println("Head of " + departmentName + " department is " + lectorEntity.getFirstName() + " "
                + lectorEntity.getLastName());
    }

    public void departmentStatistics(String departmentName) {
        DepartmentEntity department = departmentRepository.findByName(departmentName);
        Set<LectorEntity> lectors = department.getLectors();
        int countOfAssistants = 0;
        int countOfAssociateProfessors = 0;
        int countOfProfessors = 0;

        for (LectorEntity lectorEntity : lectors) {
            if (lectorEntity.getAcademicDegree() == AcademicDegree.ASSISTANT) {
                countOfAssistants++;
            } else if (lectorEntity.getAcademicDegree() == AcademicDegree.ASSOCIATE_PROFESSOR) {
                countOfAssociateProfessors++;
            } else if (lectorEntity.getAcademicDegree() == AcademicDegree.PROFESSOR) {
                countOfProfessors++;
            }
        }
        System.out.println("assistans - " + countOfAssistants + "\nassociate professors - " + countOfAssociateProfessors
                + "\nprofessors - " + countOfProfessors);
    }

    public void averageSalary(String departmentName) {
        DepartmentEntity department = departmentRepository.findByName(departmentName);
        Set<LectorEntity> lectors = department.getLectors();

        double averageSalary = lectors.stream()
                .mapToDouble(LectorEntity::getSalary)
                .average()
                .orElse(0);

        System.out.println("The average salary of " + departmentName + " is " + averageSalary);
    }


    public void countEmployee(String departmentName) {
        DepartmentEntity department = departmentRepository.findByName(departmentName);
        Set<LectorEntity> lectors = department.getLectors();
        System.out.println(lectors.size());
    }

    public void globalSearch(String template) {
        lectorRepository.findAll().stream()
                .filter(lector ->
                        lector.getFirstName().toLowerCase().contains(template.toLowerCase()) &&
                                lector.getLastName().toLowerCase().contains(template.toLowerCase())
                )
                .forEach(lector -> System.out.println(lector.getFirstName() + " " + lector.getLastName()));
    }
}
