package com.djyz.web;

import com.djyz.domain.ClothesOrder;
import com.djyz.service.ClothesOrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(value = "/ClothesOrder", tags = "ClothesOrder接口")
public class ClothesOrderController {
    @Autowired
    private ClothesOrderService clothesOrderService;

    /*获取全部订单*/
    @GetMapping("/getAllClothesOrders")
    @ResponseBody
    public List<ClothesOrder> getAllClothesOrders(){
        return clothesOrderService.getAllClothesOrders();
    }


}
