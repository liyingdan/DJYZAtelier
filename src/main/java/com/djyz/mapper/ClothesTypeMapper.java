package com.djyz.mapper;

import com.djyz.domain.ClothesType;
import java.util.List;

public interface ClothesTypeMapper {
    int deleteByPrimaryKey(Long cloTypeId);

    int insert(ClothesType record);

    ClothesType selectByPrimaryKey(Long cloTypeId);

    List<ClothesType> selectAll();

    int updateByPrimaryKey(ClothesType record);

    void updateClothesTypeRel(Long id);

    List<ClothesType> getTypeAndClothes();
}
