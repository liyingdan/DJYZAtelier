package com.djyz.web;

import com.djyz.domain.ComboOrder;
import com.djyz.service.ComboOrderService;
import com.djyz.util.AjaxRes;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(value = "/ComboOrder", tags = "ComboOrder接口")
public class ComboOrderController {
    @Autowired
    private ComboOrderService comboOrderService;

    /*获取全部订单*/
    @GetMapping("/getAllComboOrders")
    @ResponseBody
    public List<ComboOrder> getAllComboOrders(){
        return comboOrderService.getAllComboOrders();

    }


    /*添加订单-*/
    /**
     *参数：comOrderId（自动生成），price,
     * comOderDate(自动生成今天日期)，startDate（拍摄日期，点击拍摄地点进行选择（几号）），
     * combo.id,  customer.id,  shootingLocation.id, shootingState（默认为1）
     * */
    @PostMapping("/addComboOrders")
    @ResponseBody
    public AjaxRes addComboOrders(ComboOrder comboOrder){
        return comboOrderService.addComboOrders(comboOrder);
    }






}
