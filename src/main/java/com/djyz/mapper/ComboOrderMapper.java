package com.djyz.mapper;

import com.djyz.domain.ComboOrder;
import com.djyz.domain.ShootingLocation;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ComboOrderMapper {
    int deleteByPrimaryKey(String comOrderId);

//    int insert(ComboOrder record);

    ComboOrder selectByPrimaryKey(String comOrderId);

    List<ComboOrder> selectAll();

    int updateByPrimaryKey(ComboOrder record);


    void insert(@Param("coId") Long coId, @Param("custId") Long custId,
                @Param("lid") Long lid, @Param("price") Double price,
                @Param("startDate") String startDate, @Param("comOderDate") Date comOderDate, @Param("shootingState") Long shootingState);

    ComboOrder getComboOrdersWithId(Long comOrderId);

    void editOrderStateWithId(@Param("comOrderId") Long comOrderId, @Param("osId") Long osId);

    List<ComboOrder> getComboOrderWithCustId(Long custId);

    void addPic(String pic);
}