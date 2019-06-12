package com.djyz.mapper;

import com.djyz.domain.ClothesOrderState;
import java.util.List;

public interface ClothesOrderStateMapper {
    int deleteByPrimaryKey(Integer cosId);

    int insert(ClothesOrderState record);

    ClothesOrderState selectByPrimaryKey(Integer cosId);

    List<ClothesOrderState> selectAll();

    int updateByPrimaryKey(ClothesOrderState record);
}