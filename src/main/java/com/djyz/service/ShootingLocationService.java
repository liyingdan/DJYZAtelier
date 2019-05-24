package com.djyz.service;

import com.djyz.domain.ShootingLocation;
import com.djyz.util.AjaxRes;

import java.util.List;

public interface ShootingLocationService {
    AjaxRes addShootingLocation(ShootingLocation shootingLocation);

    /*根据地点获取可拍摄的天数*/
    List<String> getDatesWithId(Long lid);
}
