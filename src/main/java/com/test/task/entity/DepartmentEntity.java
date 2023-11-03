package com.test.task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "DEPARTMENT_ENTITY_T01")
public class DepartmentEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UUID")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "departments")
    private Set<LectorEntity> lectors;

    @OneToOne
    @JoinColumn(name = "HEAD_ID")
    private LectorEntity head;

    public DepartmentEntity(String name, Set<LectorEntity> lectors, LectorEntity head) {
        this.name = name;
        this.lectors = lectors;
        this.head = head;
    }
}
