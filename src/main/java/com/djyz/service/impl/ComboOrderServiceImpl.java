package com.djyz.service.impl;

import com.djyz.domain.ComboOrder;
import com.djyz.mapper.ComboOrderMapper;
import com.djyz.service.ComboOrderService;
import com.djyz.util.AjaxRes;
import com.djyz.util.OrderCoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ComboOrderServiceImpl implements ComboOrderService {
    @Autowired
    private ComboOrderMapper comboOrderMapper;

    @Override
    public List<ComboOrder> getAllComboOrders() {
        return comboOrderMapper.selectAll();
    }

    @Override
    public AjaxRes addComboOrders(ComboOrder comboOrder) {
        System.out.println("service-----------------"+comboOrder);
        AjaxRes ajaxRes = new AjaxRes();
        String comboOrderCode = OrderCoderUtil.getComboOrderCode(comboOrder.getCombo().getCoId());
        System.out.println("comboOrderCode---------------------"+comboOrderCode);
        comboOrder.setComOrderId(comboOrderCode);
        try{
            comboOrderMapper.insert(comboOrder);
            ajaxRes.setMsg("预约成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("预约失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }
}
