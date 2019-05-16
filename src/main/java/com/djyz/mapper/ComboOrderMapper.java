package com.djyz.mapper;

import com.djyz.domain.ComboOrder;
import java.util.List;

public interface ComboOrderMapper {
    int deleteByPrimaryKey(Long comOrderId);

    int insert(ComboOrder record);

    ComboOrder selectByPrimaryKey(Long comOrderId);

    List<ComboOrder> selectAll();

    int updateByPrimaryKey(ComboOrder record);
}