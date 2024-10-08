package com.Stream_API_20.Stream_API_20;

import java.util.Set;

public interface EmploeeService {
    Employee maxSalary(Integer salary);

    Employee minSalary(Integer salary);

    Set findEmploees(Integer depId);

    Set eploeesInDepartment(Integer departament);

    Set allEmploees();

    String addEmploee(String firstName, String lastName);

    String findEmploee(String firstName, String lastName);

    String delEmploee(String firstName, String lastName);

    void emploeesAbOvo();
}
