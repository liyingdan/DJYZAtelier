package com.djyz.service.impl;

import com.djyz.domain.ShootingDays5;
import com.djyz.domain.ShootingLocation;
import com.djyz.mapper.ShootingLocationMapper;
import com.djyz.service.ShootingLocationService;
import com.djyz.util.AjaxRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ShootingLocationServiceImpl implements ShootingLocationService {
    @Autowired
    private ShootingLocationMapper shootingLocationMapper;
    @Override
    public AjaxRes addShootingLocation(ShootingLocation shootingLocation) {
        AjaxRes ajaxRes = new AjaxRes();
        try{
            shootingLocationMapper.insert(shootingLocation);
            if(shootingLocation.getShootingDays() != null || !"".equals(shootingLocation.getShootingDays())){
                ShootingDays5 shootingDays5 = new ShootingDays5();
                if(shootingLocation.getShootingDays() == 3){
                    for(int i = 1; i <= 28; i=i+4){
                        shootingDays5.setShootingDays(i+"号");
                        shootingDays5.setShootingLocationId(shootingLocation.getLid());
                        shootingDays5.setShootingTimes((long) 0);
                        //在shooting_days_5中增加记录
                        shootingLocationMapper.addShootingDays3_location(shootingDays5);
                    }
                }
                if(shootingLocation.getShootingDays() == 5){
                    for(int i = 1; i <= 28; i=i+6){
                        shootingDays5.setShootingDays(i+"号");
                        shootingDays5.setShootingLocationId(shootingLocation.getLid());
                        shootingDays5.setShootingTimes((long) 0);
                        //在shooting_days_5中增加记录
                        shootingLocationMapper.addShootingDays5_location(shootingDays5);
                    }
                }
                if(shootingLocation.getShootingDays() == 7){
                    for(int i = 1; i <= 28; i=i+8){
                        shootingDays5.setShootingDays(i+"号");
                        shootingDays5.setShootingLocationId(shootingLocation.getLid());
                        shootingDays5.setShootingTimes((long) 0);
                        //在shooting_days_5中增加记录
                        shootingLocationMapper.addShootingDays7_location(shootingDays5);
                    }
                }
                if(shootingLocation.getShootingDays() == 10){
                    for(int i = 1; i <= 28; i=i+11){
                        shootingDays5.setShootingDays(i+"号");
                        shootingDays5.setShootingLocationId(shootingLocation.getLid());
                        shootingDays5.setShootingTimes((long) 0);
                        //在shooting_days_10中增加记录
                        shootingLocationMapper.addShootingDays10_location(shootingDays5);
                    }
                }
            }

            ajaxRes.setMsg("添加拍摄地点成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("添加拍摄地点失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /*根据地点获取可拍摄的天数*/
    @Override
    public List<String> getDatesWithId(Long lid) {
        /*根据lid在shooting_location表中查询天数和最多可拍摄天数*/
        ShootingLocation shootingLocation = shootingLocationMapper.selectByPrimaryKey(lid);
        ArrayList<String> dayList = new ArrayList<>();
        if (shootingLocation.getShootingDays() == 3){
            //在day3表中查询可拍摄天数
            List<ShootingDays5> datesWithId3 = shootingLocationMapper.getDatesWithId3(lid);
            for (ShootingDays5 shootingDays3 : datesWithId3) {
                if(shootingDays3.getShootingTimes() < shootingLocation.getTimeLimit()){
                    dayList.add(shootingDays3.getShootingDays());
                }
            }
        }
        if (shootingLocation.getShootingDays() == 5){
            //在day5表中查询可拍摄天数
            List<ShootingDays5> datesWithId5 = shootingLocationMapper.getDatesWithId5(lid);
            for (ShootingDays5 shootingDays5 : datesWithId5) {
                if(shootingDays5.getShootingTimes() < shootingLocation.getTimeLimit()){
                    dayList.add(shootingDays5.getShootingDays());
                }
            }
        }
        if (shootingLocation.getShootingDays() == 7){
            //在day7表中查询可拍摄天数
            List<ShootingDays5> datesWithId7 = shootingLocationMapper.getDatesWithId7(lid);
            for (ShootingDays5 shootingDays7 : datesWithId7) {
                if(shootingDays7.getShootingTimes() < shootingLocation.getTimeLimit()){
                    dayList.add(shootingDays7.getShootingDays());
                }
            }
        }
        if (shootingLocation.getShootingDays() == 10){
            //在day10表中查询可拍摄天数
            List<ShootingDays5> datesWithId10 = shootingLocationMapper.getDatesWithId10(lid);
            for (ShootingDays5 shootingDays10 : datesWithId10) {
                if(shootingDays10.getShootingTimes() < shootingLocation.getTimeLimit()){
                    dayList.add(shootingDays10.getShootingDays());
                }
            }
        }
        System.out.println(dayList);
        return dayList;
    }
}
