package com.test.task.entity;

import com.test.task.enums.Departments;
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
@EqualsAndHashCode(exclude = "lectors")
@Table(name = "DEPARTMENT_ENTITY_T01")
public class DepartmentEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UUID")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany
    @JoinTable(name = "LECTOR_DEPARTMENT_T01",
            joinColumns = @JoinColumn(name = "DEPARTMENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "LECTOR_ID"))
    private Set<LectorEntity> lectors = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "HEAD_ID")
    private LectorEntity head;

    public DepartmentEntity(String name, Set<LectorEntity> lectors, LectorEntity head) {
        this.name = name;
        this.lectors = lectors;
        this.head = head;
    }
}
