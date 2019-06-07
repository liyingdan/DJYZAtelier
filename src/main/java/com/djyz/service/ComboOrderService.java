package com.djyz.service;

import com.djyz.domain.ComboOrder;
import com.djyz.domain.ComboOrderState;
import com.djyz.util.AjaxRes;

import java.util.List;

public interface ComboOrderService {
    List<ComboOrder> getAllComboOrders();

//    AjaxRes addComboOrders(ComboOrder comboOrder);
AjaxRes addComboOrders(Long coId, Long custId, Long lid, Double price, String startDate);


    ComboOrder getComboOrdersWithId(Long comOrderId);

    List<ComboOrderState> getAllOrderStates();

    AjaxRes editOrderStateWithId(Long comOrderId, Long osId);
}
