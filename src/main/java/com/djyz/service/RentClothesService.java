package com.djyz.service;

import com.djyz.util.AjaxRes;
import com.djyz.domain.RentClothes;
import com.djyz.util.PageList;
import com.djyz.util.QueryVo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface RentClothesService {
    List<RentClothes> getClothesWithTypeId(Long cloType);


    AjaxRes addRentClothes(RentClothes rentClothes);

    AjaxRes deleteRentClothesWithId(Long cloId);

    /*根据id获取租赁服装*/
    RentClothes getClothesWithId(Long cloId);

    void updateRentClothes(RentClothes rentClothes);

    PageList getAllRentClothes(QueryVo vo);

    List<RentClothes> getAllClothes(QueryVo vo);
}
