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

//    List<RentClothes> selectAllClothes(@Param("keyword") String keyword, @Param("price") Double price, @Param("ctype") int ctype);

//    List<RentClothes> selectAll(String keyword);
}