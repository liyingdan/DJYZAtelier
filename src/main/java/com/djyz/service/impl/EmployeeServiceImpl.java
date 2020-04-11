package com.djyz.service.impl;

import com.djyz.domain.Customer;
import com.djyz.domain.Employee;
import com.djyz.mapper.EmployeeMapper;
import com.djyz.service.EmployeeService;
import com.djyz.util.AjaxRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /*查询全部员工*/
    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.selectAll();
    }

    /*根据username查询员工*/
    @Override
    public Employee getEmployeeWithUsername(String username) {
        return employeeMapper.getEmployeeWithUsername(username);
    }

    /*增加员工*/
    @Override
    public AjaxRes addEmployee(Employee employee) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            employeeMapper.insert(employee);
            ajaxRes.setSuccess(true);
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /*删除员工*/
    @Override
    public AjaxRes deleteEmployee(Long eid) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            employeeMapper.deleteByPrimaryKey(eid);
            ajaxRes.setSuccess(true);
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /*修改员工信息*/
    @Override
    public AjaxRes editEmployee(Employee employee) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            Employee employee1 = employeeMapper.selectByPrimaryKey(employee.getEid());
            String password = employee.getPassword();
            String username = employee.getUsername();
            if(password != null && !"".equals(password))
                employee1.setPassword(password);
            if (username != null && !"".equals(username))
                employee1.setUsername(username);
            //更新
            employeeMapper.updateByPrimaryKey(employee1);
            ajaxRes.setSuccess(true);
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    @Override
    public ArrayList<String> getRolesByEid(Long eid) {
        return employeeMapper.getRolesByEid(eid);
    }

    /*根据员工id查询权限*/
    @Override
    public ArrayList<String> getPermissionsByEid(Long eid) {
        return employeeMapper.getPermissionsByEid(eid);
    }


}
