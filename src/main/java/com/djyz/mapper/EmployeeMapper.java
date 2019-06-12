package com.djyz.mapper;

import com.djyz.domain.Employee;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long eid);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long eid);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);
}