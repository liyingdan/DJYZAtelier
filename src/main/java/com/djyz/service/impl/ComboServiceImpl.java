package com.djyz.service.impl;

import com.djyz.domain.Combo;
import com.djyz.domain.ShootingLocation;
import com.djyz.mapper.ComboMapper;
import com.djyz.service.ComboService;
import com.djyz.service.RedisService;
import com.djyz.util.AjaxRes;
import com.djyz.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ComboServiceImpl implements ComboService {
    @Autowired
    private ComboMapper comboMapper;
    @Autowired
    private FileUpload fileUpload;
    @Autowired
    private RedisService redisService;

    /*添加套餐*/
    @Override
    public AjaxRes addCombo(Combo combo) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            //保存套餐
            comboMapper.insert(combo);

            //保存套餐和拍摄地点的关系
            for (ShootingLocation shootingLocation : combo.getShootingLocations()) {
                comboMapper.insertComboLocationRel(combo.getCoId(),shootingLocation.getLid());
            }

            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    @Override
    public List<Combo> getAllCombo() {
        return comboMapper.selectAll();
    }

    /*
    * 根据id获取摄影套餐 redis---数据库
    * */
    @Override
    public Combo getComboWithId(Long coId) {
        Combo combo = comboMapper.selectByPrimaryKey(coId);


        return combo;
    }

    @Override
    public List<Combo> getCombosWithAid(Long tid) {
        return comboMapper.getCombosWithAid(tid);
    }

    /*根据id删除*/
    @Override
    public AjaxRes deleteCombosWith(Long comOrderId) {
        return null;
    }

}
