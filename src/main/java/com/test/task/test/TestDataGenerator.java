package com.test.task.test;

import com.test.task.entity.DepartmentEntity;
import com.test.task.entity.LectorEntity;
import com.test.task.enums.AcademicDegree;
import com.test.task.repository.DepartmentRepository;
import com.test.task.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class TestDataGenerator {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private LectorRepository lectorRepository;

    public void generateTestData() {
        LectorEntity lectorEntity1 = new LectorEntity("John", "Smith", 1000,
                AcademicDegree.ASSISTANT);
        LectorEntity lectorEntity2 = new LectorEntity("Jane", "Johnson", 2000,
                AcademicDegree.ASSOCIATE_PROFESSOR);
        LectorEntity lectorEntity3 = new LectorEntity("Michael", "Brown", 3000,
                AcademicDegree.PROFESSOR);
        LectorEntity lectorEntity4 = new LectorEntity("Emily", "Taylor", 1200,
                AcademicDegree.ASSISTANT);
        LectorEntity lectorEntity5 = new LectorEntity("David", "Miller", 2300,
                AcademicDegree.ASSOCIATE_PROFESSOR);
        LectorEntity lectorEntity6 = new LectorEntity("Sarah", "Anderson", 3500,
                AcademicDegree.PROFESSOR);
        LectorEntity lectorEntity7 = new LectorEntity("James", "Wilson", 2200,
                AcademicDegree.ASSOCIATE_PROFESSOR);
        LectorEntity lectorEntity8 = new LectorEntity("Jennifer", "Davis", 3400,
                AcademicDegree.PROFESSOR);
        LectorEntity lectorEntity9 = new LectorEntity("Robert", "Martinez", 2000,
                AcademicDegree.ASSOCIATE_PROFESSOR);
        LectorEntity lectorEntity10 = new LectorEntity("Mary", "Jackson", 3500,
                AcademicDegree.PROFESSOR);

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

        Set<LectorEntity> lectorSetOfDepartmentEntity1 = new HashSet<>();
        lectorSetOfDepartmentEntity1.add(lectorEntity1);
        lectorSetOfDepartmentEntity1.add(lectorEntity2);
        lectorSetOfDepartmentEntity1.add(lectorEntity3);
        Set<LectorEntity> lectorSetOfDepartmentEntity2 = new HashSet<>();
        lectorSetOfDepartmentEntity2.add(lectorEntity4);
        lectorSetOfDepartmentEntity2.add(lectorEntity5);
        lectorSetOfDepartmentEntity2.add(lectorEntity6);
        lectorSetOfDepartmentEntity2.add(lectorEntity7);
        Set<LectorEntity> lectorSetOfDepartmentEntity3 = new HashSet<>();
        lectorSetOfDepartmentEntity3.add(lectorEntity8);
        lectorSetOfDepartmentEntity3.add(lectorEntity9);
        lectorSetOfDepartmentEntity3.add(lectorEntity10);


        DepartmentEntity departmentEntity1 = new DepartmentEntity("First", lectorSetOfDepartmentEntity1, lectorEntity3);
        DepartmentEntity departmentEntity2 = new DepartmentEntity("Second", lectorSetOfDepartmentEntity2, lectorEntity6);
        DepartmentEntity departmentEntity3 = new DepartmentEntity("Third", lectorSetOfDepartmentEntity3, lectorEntity10);

        departmentRepository.save(departmentEntity1);
        departmentRepository.save(departmentEntity2);
        departmentRepository.save(departmentEntity3);
    }
}
