package com.test.task.entity;

import com.test.task.enums.AcademicDegree;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "LECTOR_ENTITY_T01")
public class LectorEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UUID")
    private UUID id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "SALARY")
    private int salary;

    @Column(name = "ACADEMIC_DEGREE")
    @Enumerated(EnumType.STRING)
    private AcademicDegree academicDegree;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "LECTOR_DEPARTMENT_T01",
            joinColumns = {@JoinColumn(name = "DEPARTMENT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "LECTOR_ID")}
    )
    private Set<DepartmentEntity> departments;

    public LectorEntity(String firstName, String lastName, int salary, AcademicDegree academicDegree) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.academicDegree = academicDegree;
    }
}
