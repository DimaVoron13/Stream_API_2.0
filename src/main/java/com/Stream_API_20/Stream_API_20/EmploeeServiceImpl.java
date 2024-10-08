package com.Stream_API_20.Stream_API_20;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class EmploeeServiceImpl implements EmploeeService{
    int maxEmploee = 15;
    Map<Employee, Integer> emploees = new HashMap<>();

    @Override
    public Employee maxSalary(Integer salary) {
        return null;
    }

    @Override
    public Employee minSalary(Integer salary) {
        return null;
    }

    @Override
    public Set findEmploees(Integer depId) {
        return Set.of();
    }

    @Override
    public Set eploeesInDepartment(Integer departament) {
        return Set.of();
    }

    @Override
    public Set allEmploees() {
        return Set.of();
    }

    @Override
    public String addEmploee(String firstName, String lastName) {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new FirstNameOrLastNameIsEmptyException();
        }
        if (!(StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName))) {
            throw new BadRequestException();
        }
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);
        if (emploees.size() >= maxEmploee) {
            throw new EmployeeStorageIsFullException();
        }
        Employee temp = new Employee(firstName, lastName);
        String word = "";
        if (emploees.containsKey(temp)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            emploees.put(temp, temp.getId());
            word = "Success, сотрудник " + temp.toString() + ", id = " + temp.getId() + " добавлен.";
        }
        return word;
    }

    @Override
    public String findEmploee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (!emploees.containsKey(temp)) {
            throw new EmployeeNotExistException();
        } else { return "Сотрудник " + temp.toString() + ", id = " + emploees.get(temp) + " находится в штате."; }
    }

    @Override
    public String delEmploee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (!emploees.containsKey(temp)) {
            throw new EmployeeNotExistException();
        } else {
            emploees.remove(temp);
            return "Сотрудник " + temp.toString() + " удален из списка.";
        }
    }

    public Map listOfEmploee() { return emploees; }

    @Override
    public void emploeesAbOvo() {
        Employee temp = new Employee("Андрицкая", "Светлана");
        buildEmploee(temp);
        temp = new Employee("Соболева", "Елена");
        buildEmploee(temp);
        temp = new Employee("Некрасова", "Олеся");
        buildEmploee(temp);
        temp = new Employee("Стяжкина", "Надежда");
        buildEmploee(temp);
        temp = new Employee("Лампель", "Екатерина");
        buildEmploee(temp);
        temp = new Employee("Смирнов", "Евгений");
        buildEmploee(temp);
        temp = new Employee("Леуский", "Владислав");
        buildEmploee(temp);
    }

    public void buildEmploee(Employee temp) { emploees.put(temp, temp.getId()); }
}
