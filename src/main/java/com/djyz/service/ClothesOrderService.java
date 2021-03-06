package com.djyz.service;

import com.djyz.domain.ClothesOrder;
import com.djyz.util.AjaxRes;
import com.djyz.util.PageList;
import com.djyz.util.QueryVo;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ClothesOrderService {
    List<ClothesOrder> getAllClothesOrders();

    AjaxRes addClothesOrders( Long cloId,  Long custId,  String token);

    List<ClothesOrder> getClothesOrdersWithCustId(Long custId);

    ClothesOrder getClothesOrdersWithId(Long cloOrderId);

    AjaxRes editClothesOrder(ClothesOrder clothesOrder);

    AjaxRes cancelOrder(Long cloOrderId);

    PageList getAllClothesOrdersWithPage(QueryVo vo);
}
