package com.djyz.service.impl;

import com.djyz.domain.*;
import com.djyz.mapper.ComboOrderMapper;
import com.djyz.mapper.ComboOrderStateMapper;
import com.djyz.mapper.ShootingLocationMapper;
import com.djyz.service.ComboOrderService;
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
public class ComboOrderServiceImpl implements ComboOrderService {
    @Autowired
    private ComboOrderMapper comboOrderMapper;
    @Autowired
    private ShootingLocationMapper shootingLocationMapper;
    @Autowired
    private ComboOrderStateMapper comboOrderStateMapper;




    /**参数：comOrderId（自动生成），price,
     *      comOderDate(自动生成今天日期)，startDate（拍摄日期，点击拍摄地点进行选择（几号）），
     *      combo.id,  customer.id,  shootingLocation.id, shootingState（默认为1）*/
    /*添加订单*/
    @Override
    public AjaxRes addComboOrders(Long coId, Long custId, Long lid, Double price, String startDate) {
        AjaxRes ajaxRes = new AjaxRes();
        try{
            //设置生成订单日期
            Date comOderDate = new Date();
            //设置订单状态
            Long shootingState = 1L;
            //添加订单
            comboOrderMapper.insert(coId,custId,lid,price,startDate,comOderDate,shootingState);
            //在shooting_days中增加那天的预定次数 首先，从shooting_location中查出天数，再看看往哪个shooting_days表中添加次数
            ShootingLocation shootingLocation = shootingLocationMapper.selectByPrimaryKey(lid);
            //往shooting_days3表中添加次数
            if(shootingLocation.getShootingDays() == 3){
                ShootingDays5 datesWithStartDay = shootingLocationMapper.getDatesWithStartDay3(startDate);
                Long shootingTimes = datesWithStartDay.getShootingTimes();
                shootingTimes += 1;
                datesWithStartDay.setShootingTimes(shootingTimes);
                //更新次数
                shootingLocationMapper.updateShootingTimes3(datesWithStartDay);
            }
            //往shooting_days5表中添加次数
            if(shootingLocation.getShootingDays() == 5){
                ShootingDays5 datesWithStartDay = shootingLocationMapper.getDatesWithStartDay5(startDate);
                Long shootingTimes = datesWithStartDay.getShootingTimes();
                shootingTimes += 1;
                datesWithStartDay.setShootingTimes(shootingTimes);
                //更新次数
                shootingLocationMapper.updateShootingTimes5(datesWithStartDay);
            }
            //往shooting_days7表中添加次数
            if(shootingLocation.getShootingDays() == 7){
                ShootingDays5 datesWithStartDay = shootingLocationMapper.getDatesWithStartDay7(startDate);
                Long shootingTimes = datesWithStartDay.getShootingTimes();
                shootingTimes += 1;
                datesWithStartDay.setShootingTimes(shootingTimes);
                //更新次数
                shootingLocationMapper.updateShootingTimes7(datesWithStartDay);
            }
            //往shooting_days10表中添加次数
            if(shootingLocation.getShootingDays() == 10){
                ShootingDays5 datesWithStartDay = shootingLocationMapper.getDatesWithStartDay10(startDate);
                Long shootingTimes = datesWithStartDay.getShootingTimes();
                shootingTimes += 1;
                datesWithStartDay.setShootingTimes(shootingTimes);
                //更新次数
                shootingLocationMapper.updateShootingTimes10(datesWithStartDay);
            }

            ajaxRes.setMsg("预约成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("预约失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    @Override
    public ComboOrder getComboOrdersWithId(Long comOrderId) {
        return comboOrderMapper.getComboOrdersWithId(comOrderId);
    }

    /*获取全部订单状态*/
    @Override
    public List<ComboOrderState> getAllOrderStates() {
        return comboOrderStateMapper.selectAll();
    }

    /*修改订单状态*/
    @Override
    public AjaxRes editOrderStateWithId(Long comOrderId, Long osId) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            comboOrderMapper.editOrderStateWithId(comOrderId,osId);
            ajaxRes.setSuccess(true);
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;

    }

    /*根据客户id查询订单*/
    @Override
    public List<ComboOrder> getComboOrderWithCustId(Long custId) {
        return comboOrderMapper.getComboOrderWithCustId(custId);
    }

    /*查询全部订单-分页*/
    @Override
    public PageList getAllComboOrders(QueryVo vo) {
        Page<Object> page = PageHelper.startPage(vo.getPageNum(), vo.getRows());

        List<ComboOrder> comboOrders = comboOrderMapper.selectAll();

        PageList pageList = new PageList();
        pageList.setTotal(page.getTotal());
        pageList.setRows(comboOrders);

        return pageList;
    }


}
