package com.djyz.service;

import com.djyz.domain.ComboOrder;
import com.djyz.util.AjaxRes;

import java.util.List;

public interface ComboOrderService {
    List<ComboOrder> getAllComboOrders();

    AjaxRes addComboOrders(ComboOrder comboOrder);



}
