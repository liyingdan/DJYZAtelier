package com.djyz.mapper;

import com.djyz.domain.ShootingDays5;
import java.util.List;

public interface ShootingDays5Mapper {
    int deleteByPrimaryKey(Long shootingDaysId);

    int insert(ShootingDays5 record);

    ShootingDays5 selectByPrimaryKey(Long shootingDaysId);

    List<ShootingDays5> selectAll();

    int updateByPrimaryKey(ShootingDays5 record);
}