package com.djyz.mapper;

import com.djyz.domain.Combotype;
import java.util.List;

public interface CombotypeMapper {
    int deleteByPrimaryKey(Long tid);

    int insert(Combotype record);

    Combotype selectByPrimaryKey(Long tid);

    List<Combotype> selectAll();

    int updateByPrimaryKey(Combotype record);
}