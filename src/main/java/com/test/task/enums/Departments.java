package com.test.task.enums;

public enum Departments {
    IT("IT"),
    MATH("Math"),
    PHYSICS("Physics");

    private final String departmentName;

    Departments(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDegreeName() {
        return this.departmentName;
    }

}
