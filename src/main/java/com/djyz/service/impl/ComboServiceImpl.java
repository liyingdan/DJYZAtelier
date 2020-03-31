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
    public AjaxRes addCombo(Combo combo, MultipartFile[] files, MultipartFile smPicture, HttpSession session) {
        AjaxRes ajaxRes = new AjaxRes();
        ArrayList<String> filenames = new ArrayList<>();
        try {
            //上传小图
            if(smPicture != null || !"".equals(smPicture)){
                String filename1 = fileUpload.upload(smPicture, session);
                combo.setCoPicture(filename1);
            }
            //上传细节图
            if(files != null || !"".equals(files)){
                for (MultipartFile file : files) {
                    //上传图片
                    String filename = fileUpload.upload(file, session);
                    filenames.add(filename);
                }
                combo.setDetailPic1(filenames.get(0));
                combo.setDetailPic2(filenames.get(1));
                combo.setDetailPic3(filenames.get(2));
                combo.setDetailPic4(filenames.get(3));
                combo.setDetailPic5(filenames.get(4));
            }

            /*ArrayList<ShootingLocation> arrayList = new ArrayList<>();
            ShootingLocation shootingLocation1 = new ShootingLocation();
            shootingLocation1.setLid((long) 1);
            ShootingLocation shootingLocation2 = new ShootingLocation();
            shootingLocation2.setLid((long) 3);
            ShootingLocation shootingLocation3 = new ShootingLocation();
            shootingLocation3.setLid((long) 4);
            arrayList.add(shootingLocation1);
            arrayList.add(shootingLocation2);
            arrayList.add(shootingLocation3);
            combo.setShootingLocations(arrayList);*/

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
