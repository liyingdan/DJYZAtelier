package com.djyz.mapper;

import com.djyz.domain.ComboOrderState;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComboOrderStateMapper {
    int deleteByPrimaryKey(Long osId);

    int insert(ComboOrderState record);

    ComboOrderState selectByPrimaryKey(Long osId);

    List<ComboOrderState> selectAll();

    int updateByPrimaryKey(ComboOrderState record);


}