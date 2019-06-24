package com.djyz.mapper;

import com.djyz.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long eid);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long eid);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    Employee getEmployeeWithUsername(String username);


    ArrayList<String> getRolesByEid(Long eid);

    ArrayList<String> getPermissionsByEid(Long eid);
}