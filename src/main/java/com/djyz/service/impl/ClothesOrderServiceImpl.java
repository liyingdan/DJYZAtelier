package com.djyz.service.impl;

import com.djyz.domain.ClothesOrder;
import com.djyz.domain.ClothesOrderState;
import com.djyz.domain.Customer;
import com.djyz.domain.RentClothes;
import com.djyz.mapper.ClothesOrderMapper;
import com.djyz.mapper.RentClothesMapper;
import com.djyz.service.ClothesOrderService;
import com.djyz.service.RedisService;
import com.djyz.util.AjaxRes;
import com.djyz.util.PageList;
import com.djyz.util.QueryVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    @Autowired
    private RedisService redisService;

    /*获取全部订单*/
    @Override
    public List<ClothesOrder> getAllClothesOrders() {
        return clothesOrderMapper.selectAll();
    }

    /*添加订单*/
    @Override
    public AjaxRes addClothesOrders(Long cloId, Long custId, String token) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            // 先验证是否已经登录
            if(custId == null || token == null){
                ajaxRes.setSuccess(false);
                ajaxRes.setMsg("您未登录，请先登录!");
                return ajaxRes;
            }
            String normalKey = "cust_" + custId;
            String s = redisService.retrieveStringValueByStringKey(normalKey);
            if(!s.equals(token)){
                ajaxRes.setSuccess(false);
                ajaxRes.setMsg("登录过期，请先登录!");
                return ajaxRes;
            }
            //如果已经登录，添加订单
            ClothesOrder clothesOrder = new ClothesOrder();
            //添加衣服id
            RentClothes rentClothes1 = new RentClothes();
            rentClothes1.setCloId(cloId);
            clothesOrder.setRentClothes(rentClothes1);
            //添加客户id
            Customer customer = new Customer();
            customer.setCustId(custId);
            clothesOrder.setCustomer(customer);

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
            ajaxRes.setMsg(e.getMessage());
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

    /*取消订单--修改状态为已取消*/
    @Override
    public AjaxRes cancelOrder(Long cloOrderId) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            //把状态改为5
            clothesOrderMapper.cancelOrder(cloOrderId);

            ajaxRes.setSuccess(true);
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /*获取全部订单--分页*/
    @Override
    public PageList getAllClothesOrdersWithPage(QueryVo vo) {
        Page<Object> page = PageHelper.startPage(vo.getPageNum(), vo.getRows());

//        List<RentClothes> rentClothes = rentClothesMapper.selectAll(vo);
        List<ClothesOrder> clothesOrders = clothesOrderMapper.selectAll();

        //封装pageList
        PageList pageList = new PageList();
        pageList.setTotal(page.getTotal());
        pageList.setRows(clothesOrders);

        return pageList;
    }
}
