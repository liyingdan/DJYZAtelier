package com.djyz.util;

import com.djyz.domain.ShootingDays5;
import com.djyz.mapper.ShootingLocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

public class ComboOrderAddTimeUtil {
    @Autowired
    private ShootingLocationMapper shootingLocationMapper;

    /*获得datesWithStartDay*/
    private ShootingDays5 getdatesWithStartDay(Long shootingDays,String startDate){
        if(shootingDays == 3){
            return shootingLocationMapper.getDatesWithStartDay3(startDate);
        } else if(shootingDays == 5){
            return shootingLocationMapper.getDatesWithStartDay5(startDate);
        } else if(shootingDays == 7){
            return shootingLocationMapper.getDatesWithStartDay7(startDate);
        }else {
            return shootingLocationMapper.getDatesWithStartDay10(startDate);
        }
    }

    //更新次数
    private void addTimeMe(Long shootingDays,ShootingDays5 datesWithStartDay){
        System.out.println("增加-----------------------------------");
        if(shootingDays == 3){
            shootingLocationMapper.updateShootingTimes3(datesWithStartDay);
        } else if(shootingDays == 5){
            shootingLocationMapper.updateShootingTimes5(datesWithStartDay);
        } else if(shootingDays == 7){
            shootingLocationMapper.updateShootingTimes7(datesWithStartDay);
        }else {
            shootingLocationMapper.updateShootingTimes10(datesWithStartDay);
        }
    }


    //主体方法-更新次数
    public void addTime(Long shootingDays,String startDate){
        ShootingDays5 datesWithStartDay = getdatesWithStartDay(shootingDays, startDate);
        System.out.println("datesWithStartDay-------------------"+datesWithStartDay);
        Long shootingTimes = datesWithStartDay.getShootingTimes();
        shootingTimes += 1;
        datesWithStartDay.setShootingTimes(shootingTimes);
        System.out.println("datesWithStartDay--------------------"+datesWithStartDay);
        //更新次数
        addTimeMe(shootingDays,datesWithStartDay);
    }



}
