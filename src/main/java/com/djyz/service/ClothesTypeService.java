package com.djyz.service;

import com.djyz.util.AjaxRes;
import com.djyz.domain.ClothesType;

import java.util.List;

public interface ClothesTypeService {
    public List<ClothesType> getAllClothesType();

    /*新增衣服种类*/
    AjaxRes addClothesType(ClothesType clothesType);

    AjaxRes deleteClothesType(Long id);

    /*根据id查询*/
    ClothesType getClothesTypeWithId(Long id);

    AjaxRes updateClothesType(ClothesType clothesType);

    List<ClothesType> getTypeAndClothes();
}
