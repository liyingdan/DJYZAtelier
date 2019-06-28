package com.djyz.service;

import com.djyz.domain.ClothesOrder;
import com.djyz.util.AjaxRes;

import java.util.List;

public interface ClothesOrderService {
    List<ClothesOrder> getAllClothesOrders();

    AjaxRes addClothesOrders(ClothesOrder clothesOrder);

    List<ClothesOrder> getClothesOrdersWithCustId(Long custId);

    ClothesOrder getClothesOrdersWithId(Long cloOrderId);

    AjaxRes editClothesOrder(ClothesOrder clothesOrder);
}
