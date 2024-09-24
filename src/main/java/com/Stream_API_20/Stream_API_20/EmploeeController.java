package com.Stream_API_20.Stream_API_20;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "/departments")
public class EmploeeController {
    EmploeeService serv = new EmploeeServiceImpl();

    @GetMapping(path = "/departments/max-salary")
    public Emploee maxSalary(@RequestParam("departmentId") Integer depId) {
        return serv.maxSalary(depId);
    }

    @GetMapping(path = "/departments/min-salary")
    public Emploee minSalary(@RequestParam("departmentId") Integer depId) {
        return serv.minSalary(depId);
    }

    @GetMapping(path = "/departments/all")
    public Set findEmploees(@RequestParam(value = "departmentId", required = false) Integer depId) {
        return serv.findEmploees(depId);
    }
}
