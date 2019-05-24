package com.djyz.service.impl;

import com.djyz.domain.ComboOrder;
import com.djyz.domain.ShootingDays5;
import com.djyz.domain.ShootingLocation;
import com.djyz.mapper.ComboOrderMapper;
import com.djyz.mapper.ShootingLocationMapper;
import com.djyz.service.ComboOrderService;
import com.djyz.util.AjaxRes;
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


    /*查询全部订单*/
    @Override
    public List<ComboOrder> getAllComboOrders() {
        return comboOrderMapper.selectAll();
    }

    /**参数：comOrderId（自动生成），price,
     *      comOderDate(自动生成今天日期)，startDate（拍摄日期，点击拍摄地点进行选择（几号）），
     *      combo.id,  customer.id,  shootingLocation.id, shootingState（默认为1）*/
    /*添加订单*/
    @Override
    public AjaxRes addComboOrders(ComboOrder comboOrder) {
        AjaxRes ajaxRes = new AjaxRes();
        try{
            //设置生成订单日期
            comboOrder.setComOderDate(new Date());
            comboOrder.setShootingState((long) 1);

            //添加订单
            comboOrderMapper.insert(comboOrder);
            //在shooting_days中增加那天的预定次数 首先，从shooting_location中查出天数，再看看往哪个shooting_days表中添加次数
            ShootingLocation shootingLocation = shootingLocationMapper.selectByPrimaryKey(comboOrder.getShootingLocation().getLid());
            //往shooting_days3表中添加次数
            if(shootingLocation.getShootingDays() == 3){
                ShootingDays5 datesWithStartDay = shootingLocationMapper.getDatesWithStartDay3(comboOrder.getStartDate());
                Long shootingTimes = datesWithStartDay.getShootingTimes();
                shootingTimes += 1;
                datesWithStartDay.setShootingTimes(shootingTimes);
                //更新次数
                shootingLocationMapper.updateShootingTimes3(datesWithStartDay);
            }
            //往shooting_days5表中添加次数
            if(shootingLocation.getShootingDays() == 5){
                ShootingDays5 datesWithStartDay = shootingLocationMapper.getDatesWithStartDay5(comboOrder.getStartDate());
                Long shootingTimes = datesWithStartDay.getShootingTimes();
                shootingTimes += 1;
                datesWithStartDay.setShootingTimes(shootingTimes);
                //更新次数
                shootingLocationMapper.updateShootingTimes5(datesWithStartDay);
            }
            //往shooting_days7表中添加次数
            if(shootingLocation.getShootingDays() == 7){
                ShootingDays5 datesWithStartDay = shootingLocationMapper.getDatesWithStartDay7(comboOrder.getStartDate());
                Long shootingTimes = datesWithStartDay.getShootingTimes();
                shootingTimes += 1;
                datesWithStartDay.setShootingTimes(shootingTimes);
                //更新次数
                shootingLocationMapper.updateShootingTimes7(datesWithStartDay);
            }
            //往shooting_days10表中添加次数
            if(shootingLocation.getShootingDays() == 10){
                ShootingDays5 datesWithStartDay = shootingLocationMapper.getDatesWithStartDay10(comboOrder.getStartDate());
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




}
