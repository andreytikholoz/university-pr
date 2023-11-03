package com.test.task.test;

import com.test.task.entity.DepartmentEntity;
import com.test.task.entity.LectorEntity;
import com.test.task.enums.Degree;
import com.test.task.enums.Departments;
import com.test.task.repository.DepartmentRepository;
import com.test.task.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class TestDataGenerator {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private LectorRepository lectorRepository;

    public void generateTestData() {
        LectorEntity lectorEntity1 = new LectorEntity("John", "Smith", 1000,
                Degree.ASSISTANT);
        LectorEntity lectorEntity2 = new LectorEntity("Jane", "Johnson", 2000,
                Degree.ASSOCIATE_PROFESSOR);
        LectorEntity lectorEntity3 = new LectorEntity("Michael", "Brown", 3000,
                Degree.PROFESSOR);
        LectorEntity lectorEntity4 = new LectorEntity("Emily", "Taylor", 1200,
                Degree.ASSISTANT);
        LectorEntity lectorEntity5 = new LectorEntity("David", "Miller", 2300,
                Degree.ASSOCIATE_PROFESSOR);
        LectorEntity lectorEntity6 = new LectorEntity("Sarah", "Anderson", 3500,
                Degree.PROFESSOR);
        LectorEntity lectorEntity7 = new LectorEntity("James", "Wilson", 2200,
                Degree.ASSOCIATE_PROFESSOR);
        LectorEntity lectorEntity8 = new LectorEntity("Jennifer", "Davis", 3400,
                Degree.PROFESSOR);
        LectorEntity lectorEntity9 = new LectorEntity("Robert", "Martinez", 2000,
                Degree.ASSOCIATE_PROFESSOR);
        LectorEntity lectorEntity10 = new LectorEntity("Mary", "Jackson", 3500,
                Degree.PROFESSOR);

        lectorRepository.save(lectorEntity1);
        lectorRepository.save(lectorEntity2);
        lectorRepository.save(lectorEntity3);
        lectorRepository.save(lectorEntity4);
        lectorRepository.save(lectorEntity5);
        lectorRepository.save(lectorEntity6);
        lectorRepository.save(lectorEntity7);
        lectorRepository.save(lectorEntity8);
        lectorRepository.save(lectorEntity9);
        lectorRepository.save(lectorEntity10);

        DepartmentEntity departmentEntity1 = new DepartmentEntity(Departments.IT.getDegreeName(), Set.of(lectorEntity1,
                lectorEntity2, lectorEntity3), lectorEntity3);
        DepartmentEntity departmentEntity2 = new DepartmentEntity(Departments.MATH.getDegreeName(), Set.of(lectorEntity4,
                lectorEntity5, lectorEntity6, lectorEntity7), lectorEntity6);
        DepartmentEntity departmentEntity3 = new DepartmentEntity(Departments.PHYSICS.getDegreeName(), Set.of(lectorEntity8,
                lectorEntity9, lectorEntity10), lectorEntity10);

        departmentRepository.save(departmentEntity1);
        departmentRepository.save(departmentEntity2);
        departmentRepository.save(departmentEntity3);
    }
}
