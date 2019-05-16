package com.djyz.mapper;

import com.djyz.domain.ShootingLocation;
import java.util.List;

public interface ShootingLocationMapper {
    int deleteByPrimaryKey(Long lid);

    int insert(ShootingLocation record);

    ShootingLocation selectByPrimaryKey(Long lid);

    List<ShootingLocation> selectAll();

    int updateByPrimaryKey(ShootingLocation record);
}