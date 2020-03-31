package com.djyz.web;

import com.alibaba.fastjson.JSONObject;
import com.djyz.util.CommonUtil;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liyingdan
 * @date 2020/3/31
 */
@Api(value = "/Permission", tags = "Permission接口")
public class PermissionController {
    /*服装订单主页*/
    @GetMapping("/clothesOrderIndex")
    @RequiresPermissions("clothesorder:index")
    @ResponseBody
    public JSONObject clothesOrderIndex(){
        return CommonUtil.successJson();
    }

    /*摄影套餐主页*/
    @GetMapping("/comoIndex")
    @RequiresPermissions("como:index")
    @ResponseBody
    public JSONObject comoIndex(){
        return CommonUtil.successJson();
    }

    /*摄影订单主页*/
    @GetMapping("/comboOrderIndex")
    @RequiresPermissions("comboorder:index")
    @ResponseBody
    public JSONObject comboOrderIndex(){
        return CommonUtil.successJson();
    }

    /*进入客户主页*/
    @GetMapping("/customerIndex")
    @RequiresPermissions("customer:index")
    @ResponseBody
    public JSONObject customerIndex(){
        return CommonUtil.successJson();
    }

    /*进入后台员工页面*/
    @GetMapping("/employeeIndex")
    @RequiresPermissions("employee:index")
    @ResponseBody
    public JSONObject employeeIndex(){
        return CommonUtil.successJson();
    }

    /*进入租赁服装主页*/
    @GetMapping("/rentClothesIndex")
    @RequiresPermissions("rentClothes:index")
    @ResponseBody
    public JSONObject rentClothesIndex(){
        return CommonUtil.successJson();
    }
}
