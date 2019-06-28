package com.djyz.web;

import com.djyz.domain.Employee;
import com.djyz.service.EmployeeService;
import com.djyz.util.AjaxRes;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(value = "/Employee", tags = "Employee接口")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /*进入后台首页*/
    @GetMapping("/employeeIndex")
    @RequiresPermissions("employee:index")
    @ResponseBody
    public String employee(){
        return "employeeIndex";
    }

    /*获取全部员工*/
    @GetMapping("/getAllEmployee")
    @ResponseBody
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    /*根据username查询员工*/
    @GetMapping("/getEmployeeWithUsername/{username}")
    @ResponseBody
    public Employee getEmployeeWithUsername(@PathVariable String username){
        return employeeService.getEmployeeWithUsername(username);
    }

    /*根据username登录*/
    @GetMapping("/employeeLogin")
    @ResponseBody
    public AjaxRes employeeLogin(Employee employee){
        return employeeService.employeeLogin(employee);
    }

    /*添加员工*/
    @GetMapping("/addEmployee")
    @ResponseBody
    public AjaxRes addEmployee(Employee employee){
        return employeeService.addEmployee(employee);
    }

    /*删除员工*/
    @DeleteMapping("/deleteEmployee/{eid}")
    @ResponseBody
    public AjaxRes deleteEmployee(@PathVariable Long eid){
        return employeeService.deleteEmployee(eid);
    }

    /*修改员工信息（除了用户名）*/
    @GetMapping("/editEmployee")
    @ResponseBody
    public AjaxRes editEmployee(Employee employee){
        return employeeService.editEmployee(employee);
    }

    //根据员工id查询权限
    @GetMapping("/getPermissionsByEid/{eid}")
    @ResponseBody
    public List<String> getPermissionsByEid(@PathVariable Long eid){
        return employeeService.getPermissionsByEid(eid);
    }






}
