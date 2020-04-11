package com.djyz.web;

import com.alibaba.fastjson.JSONObject;
import com.djyz.domain.ClothesOrder;
import com.djyz.service.ClothesOrderService;
import com.djyz.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import javafx.scene.shape.VLineTo;
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

    /*获取全部订单--分页*/
    @GetMapping("/getAllClothesOrdersWithPage")
    @ResponseBody
    public PageList getAllClothesOrdersWithPage(QueryVo vo){
        return clothesOrderService.getAllClothesOrdersWithPage(vo);
    }

    /*获取全部订单*/
    @GetMapping("/getAllClothesOrders")
    @ResponseBody
    public List<ClothesOrder> getAllClothesOrders(){
        return clothesOrderService.getAllClothesOrders();
    }

    /*增加订单--完成后服装数量减1
    * 参数：cloId（租赁服装id），custId 用户id
    * */

    @GetMapping("/addClothesOrders")
    @ResponseBody
    public AjaxRes addClothesOrders(Long cloId, Long custId, String token){
        if(custId == null || token == null || "".equals(token)){
            AjaxRes ajaxRes = new AjaxRes();
            ajaxRes.setMsg("请先登录");
            ajaxRes.setSuccess(false);
            return ajaxRes;
        }
        return clothesOrderService.addClothesOrders(cloId,custId,token);
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

    /*根据id 取消订单*/
    @GetMapping("/cancelOrder/{cloOrderId}")
    @ResponseBody
    public AjaxRes cancelOrder(@PathVariable Long cloOrderId){
        return clothesOrderService.cancelOrder(cloOrderId);
    }




}
