package com.djyz.mapper;

import com.djyz.domain.ShootingDays5;
import com.djyz.domain.ShootingLocation;
import java.util.List;

public interface ShootingLocationMapper {
    int deleteByPrimaryKey(Long lid);

    int insert(ShootingLocation record);

    ShootingLocation selectByPrimaryKey(Long lid);

    List<ShootingLocation> selectAll();

    int updateByPrimaryKey(ShootingLocation record);

    void addShootingDays3_location(ShootingDays5 shootingDays5);

    void addShootingDays5_location(ShootingDays5 shootingDays5);

    void addShootingDays7_location(ShootingDays5 shootingDays5);

    void addShootingDays10_location(ShootingDays5 shootingDays5);


    List<ShootingDays5> getDatesWithId3(Long lid);
    List<ShootingDays5> getDatesWithId5(Long lid);
    List<ShootingDays5> getDatesWithId7(Long lid);
    List<ShootingDays5> getDatesWithId10(Long lid);

    ShootingDays5 getDatesWithStartDay3(String startDate);
    ShootingDays5 getDatesWithStartDay5(String startDate);
    ShootingDays5 getDatesWithStartDay7(String startDate);
    ShootingDays5 getDatesWithStartDay10(String startDate);

    void updateShootingTimes3(ShootingDays5 datesWithStartDay);
    void updateShootingTimes5(ShootingDays5 datesWithStartDay);
    void updateShootingTimes7(ShootingDays5 datesWithStartDay);
    void updateShootingTimes10(ShootingDays5 datesWithStartDay);
}