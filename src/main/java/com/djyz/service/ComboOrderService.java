package com.djyz.service;

import com.djyz.domain.ComboOrder;
import com.djyz.util.AjaxRes;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ComboOrderService {
    List<ComboOrder> getAllComboOrders();

//    AjaxRes addComboOrders(ComboOrder comboOrder);
AjaxRes addComboOrders(Long coId, Long custId, Long lid, Double price, String startDate);



}
