package com.djyz.service;

import com.djyz.domain.ComboOrder;
import com.djyz.domain.ComboOrderState;
import com.djyz.util.AjaxRes;
import com.djyz.util.PageList;
import com.djyz.util.QueryVo;

import java.util.List;

public interface ComboOrderService {

//    AjaxRes addComboOrders(ComboOrder comboOrder);
AjaxRes addComboOrders(Long coId, Long custId, Long lid, Double price, String startDate);


    ComboOrder getComboOrdersWithId(Long comOrderId);

    List<ComboOrderState> getAllOrderStates();

    AjaxRes editOrderStateWithId(Long comOrderId, Long osId);

    List<ComboOrder> getComboOrderWithCustId(Long custId);

    PageList getAllComboOrders(QueryVo vo);
}
