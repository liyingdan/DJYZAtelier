package com.djyz.mapper;

import com.djyz.domain.RentClothes;
import com.djyz.util.QueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentClothesMapper {
    int deleteByPrimaryKey(Long cloId);

    int insert(RentClothes record);

    RentClothes selectByPrimaryKey(Long cloId);

    List<RentClothes> selectAll(QueryVo vo);

    int updateByPrimaryKey(RentClothes record);

    List<RentClothes> getClothesWithTypeId(Long cloType);



}