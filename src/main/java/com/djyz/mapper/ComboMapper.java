package com.djyz.mapper;

import com.djyz.domain.Combo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComboMapper {
    int deleteByPrimaryKey(Long coId);

    int insert(Combo record);

    Combo selectByPrimaryKey(Long coId);

    List<Combo> selectAll();

    int updateByPrimaryKey(Combo record);

    void insertComboLocationRel(@Param("coId") Long coId, @Param("lid") Long lid);
}