package com.djyz.service.impl;

import com.djyz.domain.ClothesOrder;
import com.djyz.mapper.ClothesOrderMapper;
import com.djyz.service.ClothesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClothesOrderServiceImpl implements ClothesOrderService {
    @Autowired
    private ClothesOrderMapper clothesOrderMapper;

    /*获取全部订单*/
    @Override
    public List<ClothesOrder> getAllClothesOrders() {
        return clothesOrderMapper.selectAll();
    }
}
