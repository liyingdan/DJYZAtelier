package com.djyz.web;

import com.djyz.util.AjaxRes;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(value = "/Employee", tags = "Employee接口")
public class EmployeeController {
    @GetMapping("/employeeLogin")
    @ResponseBody
    public AjaxRes EmployeeLogin(){

        return null;
    }
}
