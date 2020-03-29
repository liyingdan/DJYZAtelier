package com.djyz.web;

import com.alibaba.fastjson.JSONObject;
import com.djyz.domain.ClothesOrder;
import com.djyz.service.ClothesOrderService;
import com.djyz.util.AjaxRes;
import com.djyz.util.CommonUtil;
import com.djyz.util.StatusEnum;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(value = "/ClothesOrder", tags = "ClothesOrder接口")
public class ClothesOrderController {
    @Autowired
    private ClothesOrderService clothesOrderService;

    /*服装订单主页*/
    @GetMapping("/clothesOrderIndex")
    @RequiresPermissions("clothesorder:index")
    @ResponseBody
    public JSONObject clothesOrderIndex(){
        return CommonUtil.successJson();
    }

    /*获取全部订单*/
    @GetMapping("/getAllClothesOrders")
    @ResponseBody
    public List<ClothesOrder> getAllClothesOrders(){
        return clothesOrderService.getAllClothesOrders();
    }

    /*增加订单--完成后服装数量减1*/
    @GetMapping("/addClothesOrders")
    @ResponseBody
    public AjaxRes addClothesOrders(ClothesOrder clothesOrder){
        return clothesOrderService.addClothesOrders(clothesOrder);
    }

    /*根据用户id查询订单*/
    @GetMapping("/getClothesOrdersWithCustId/{custId}")
    @ResponseBody
    public List<ClothesOrder> getClothesOrdersWithCustId(@PathVariable Long custId){
        return clothesOrderService.getClothesOrdersWithCustId(custId);
    }

    /*根据订单id查询订单*/
    @GetMapping("/getClothesOrdersWithId/{cloOrderId}")
    @ResponseBody
    public ClothesOrder getClothesOrdersWithId(@PathVariable Long cloOrderId){
        return clothesOrderService.getClothesOrdersWithId(cloOrderId);
    }


    /*修改订单状态*/
    @GetMapping("/editClothesOrder")
    @ResponseBody
    public AjaxRes editClothesOrder(ClothesOrder clothesOrder){
        return clothesOrderService.editClothesOrder(clothesOrder);
    }



}
