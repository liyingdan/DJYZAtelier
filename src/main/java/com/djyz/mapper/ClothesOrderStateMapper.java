package com.djyz.mapper;

import com.djyz.domain.ClothesOrderState;
import java.util.List;

public interface ClothesOrderStateMapper {
    int deleteByPrimaryKey(Long cosId);

    int insert(ClothesOrderState record);

    ClothesOrderState selectByPrimaryKey(Long cosId);

    List<ClothesOrderState> selectAll();

    int updateByPrimaryKey(ClothesOrderState record);
}