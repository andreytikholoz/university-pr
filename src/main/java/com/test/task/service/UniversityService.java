package com.test.task.service;

import com.test.task.entity.DepartmentEntity;
import com.test.task.entity.LectorEntity;
import com.test.task.repository.DepartmentRepository;
import com.test.task.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UniversityService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private LectorRepository lectorRepository;

    public LectorEntity findHeadOfDepartment(String departmentName) {
        DepartmentEntity department = departmentRepository.findByName(departmentName)
                .orElseThrow(() -> new NoSuchElementException("Department with id = [" + departmentName + "] not exist"));
        return department.getHead();
    }

    public Map<String, Integer> departmentStatistics(String departmentName) {
        DepartmentEntity department = departmentRepository.findByName(departmentName)
                .orElseThrow(() -> new NoSuchElementException("Department with id = [" + departmentName + "] not exist"));
        Set<LectorEntity> lectors = department.getLectors();
        int countOfAssistants = 0;
        int countOfAssociateProfessors = 0;
        int countOfProfessors = 0;

        for (LectorEntity lectorEntity : lectors) {
            switch (lectorEntity.getAcademicDegree()) {
                case ASSISTANT:
                    countOfAssistants++;
                    break;
                case ASSOCIATE_PROFESSOR:
                    countOfAssociateProfessors++;
                    break;
                case PROFESSOR:
                    countOfProfessors++;
                    break;
            }
        }
        Map<String, Integer> statistics = new HashMap<>();
        statistics.put("assistants", countOfAssistants);
        statistics.put("associate professors", countOfAssociateProfessors);
        statistics.put("professors", countOfProfessors);
        return statistics;
    }

    public double averageSalary(String departmentName) {
        DepartmentEntity department = departmentRepository.findByName(departmentName)
                .orElseThrow(() -> new NoSuchElementException("Department with id = [" + departmentName + "] not exist"));
        Set<LectorEntity> lectors = department.getLectors();

        double averageSalary = lectors.stream()
                .mapToDouble(LectorEntity::getSalary)
                .average()
                .orElse(0);
        return Math.round(averageSalary);
    }

    public int countEmployee(String departmentName) {
        DepartmentEntity department = departmentRepository.findByName(departmentName)
                .orElseThrow(() -> new NoSuchElementException("Department with id = [" + departmentName + "] not exist"));
        Set<LectorEntity> lectors = department.getLectors();
        return lectors.size();
    }

    public Set<LectorEntity> globalSearch(String template) {
        return lectorRepository.findAll().stream()
                .filter(lector ->
                        lector.getFirstName().toLowerCase().contains(template.toLowerCase()) ||
                                lector.getLastName().toLowerCase().contains(template.toLowerCase())
                )
                .collect(Collectors.toSet());
    }
}
