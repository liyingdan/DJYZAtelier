package com.djyz.service;

import com.djyz.domain.Employee;
import com.djyz.util.AjaxRes;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee getEmployeeWithUsername(String username);

    AjaxRes addEmployee(Employee employee);

    AjaxRes deleteEmployee(Long eid);

    AjaxRes editEmployee(Employee employee);

    ArrayList<String> getRolesByEid(Long eid);

    ArrayList<String> getPermissionsByEid(Long eid);

    AjaxRes employeeLogin(Employee employee);
}
