package com.test.task.entity;

import com.test.task.enums.Degree;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "departments")
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
    private Degree academicDegree;

    @ManyToMany(mappedBy = "lectors")
    private Set<DepartmentEntity> departments = new HashSet<>();

    public LectorEntity(String firstName, String lastName, int salary, Degree academicDegree) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.academicDegree = academicDegree;
    }
}
