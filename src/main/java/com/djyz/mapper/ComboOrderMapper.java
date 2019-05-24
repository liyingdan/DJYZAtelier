package com.djyz.mapper;

import com.djyz.domain.ComboOrder;
import com.djyz.domain.ShootingLocation;

import java.util.List;

public interface ComboOrderMapper {
    int deleteByPrimaryKey(String comOrderId);

    int insert(ComboOrder record);

    ComboOrder selectByPrimaryKey(String comOrderId);

    List<ComboOrder> selectAll();

    int updateByPrimaryKey(ComboOrder record);




}