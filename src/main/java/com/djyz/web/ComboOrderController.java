package com.djyz.web;

import com.alibaba.fastjson.JSONObject;
import com.djyz.domain.ComboOrder;
import com.djyz.domain.ComboOrderState;
import com.djyz.service.ComboOrderService;
import com.djyz.util.*;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(value = "/ComboOrder", tags = "ComboOrder接口")
public class ComboOrderController {
    @Autowired
    private ComboOrderService comboOrderService;

    /*获取全部订单-分页*/
    @GetMapping("/getAllComboOrders")
    @ResponseBody
    public PageList getAllComboOrders(QueryVo vo){
        PageList allComboOrders = comboOrderService.getAllComboOrders(vo);
        System.out.println(allComboOrders);
        return allComboOrders;
    }

    /*添加订单-*/
    /**
     *参数：comOrderId（自动生成），price,
     * comOderDate(自动生成今天日期)，startDate（拍摄日期，点击拍摄地点进行选择（几号）），
     * 需要传的参数： combo.id,  customer.id,  shootingLocation.id, shootingState（默认为1）
     * */
    @PostMapping("/addComboOrders/{coId}/{custId}/{lid}/{price}/{startDate}")
    @ResponseBody
    public AjaxRes addComboOrders(@PathVariable Long coId,@PathVariable Long custId,@PathVariable Long lid,@PathVariable Double price,@PathVariable String startDate){
        return comboOrderService.addComboOrders(coId,custId,lid,price,startDate);
    }

    /*根据id查询订单*/
    @GetMapping("/getComboOrdersWithId/{comOrderId}")
    @ResponseBody
    public ComboOrder  getComboOrdersWithId(@PathVariable Long comOrderId){
        return comboOrderService.getComboOrdersWithId(comOrderId);
    }


    //获取全部订单状态
    @GetMapping("/getAllOrderStates")
    @ResponseBody
    public List<ComboOrderState> getAllOrderStates(){
        return comboOrderService.getAllOrderStates();
    }

    /*修改订单状态  combo_order_state中的osId*/
    @GetMapping("/editOrderStateWithId/{comOrderId}/{osId}")
    @ResponseBody
    public AjaxRes editOrderStateWithId(@PathVariable Long comOrderId,@PathVariable Long osId){
        return comboOrderService.editOrderStateWithId(comOrderId,osId);
    }



    /*根据客户id查询订单*/
    @GetMapping("/getComboOrderWithCustId/{custId}")
    @ResponseBody
    public List<ComboOrder> getComboOrderWithCustId(@PathVariable Long custId){
        return comboOrderService.getComboOrderWithCustId(custId);
    }

    /*拍摄完成后上传图片-字符串*/
    @PostMapping("/addPic/{pic}")
    @ResponseBody
    public AjaxRes addPic(@PathVariable String pic){
        return comboOrderService.addPic(pic);
    }




}
