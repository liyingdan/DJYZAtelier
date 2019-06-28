package com.djyz.service.impl;

import com.djyz.domain.ClothesOrder;
import com.djyz.domain.ClothesOrderState;
import com.djyz.domain.RentClothes;
import com.djyz.mapper.ClothesOrderMapper;
import com.djyz.mapper.RentClothesMapper;
import com.djyz.service.ClothesOrderService;
import com.djyz.util.AjaxRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ClothesOrderServiceImpl implements ClothesOrderService {
    @Autowired
    private ClothesOrderMapper clothesOrderMapper;
    @Autowired
    private RentClothesMapper rentClothesMapper;

    /*获取全部订单*/
    @Override
    public List<ClothesOrder> getAllClothesOrders() {
        return clothesOrderMapper.selectAll();
    }

    /*添加订单*/
    @Override
    public AjaxRes addClothesOrders(ClothesOrder clothesOrder) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            //设置订单日期
            clothesOrder.setClothesOrderDate(new Date());
            //设置默认状态为1
            ClothesOrderState clothesOrderState = new ClothesOrderState();
            clothesOrderState.setCosId((long) 1);
            clothesOrder.setClothesOrderState(clothesOrderState);
            //添加
            clothesOrderMapper.insert(clothesOrder);
            //在租赁服装中减少数量-根据服装id
            //查询
            RentClothes rentClothes = rentClothesMapper.selectByPrimaryKey(clothesOrder.getRentClothes().getCloId());
            Long cloAmount = rentClothes.getCloAmount();
            cloAmount -= 1;
            rentClothes.setCloAmount(cloAmount);
            //更新
            rentClothesMapper.updateByPrimaryKey(rentClothes);

            ajaxRes.setSuccess(true);
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /*根据用户id查询订单*/
    @Override
    public List<ClothesOrder> getClothesOrdersWithCustId(Long custId) {
        return clothesOrderMapper.getClothesOrdersWithCustId(custId);
    }

    /*根据订单id查询订单*/
    @Override
    public ClothesOrder getClothesOrdersWithId(Long cloOrderId) {
        return clothesOrderMapper.selectByPrimaryKey(cloOrderId);
    }

    /*修改订单状态*/
    @Override
    public AjaxRes editClothesOrder(ClothesOrder clothesOrder) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            clothesOrderMapper.editClothesOrder(clothesOrder);
            ajaxRes.setSuccess(true);
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }
}
