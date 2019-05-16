package com.djyz.service.impl;

import com.djyz.util.AjaxRes;
import com.djyz.domain.ClothesType;
import com.djyz.mapper.ClothesTypeMapper;
import com.djyz.service.ClothesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ClothesTypeServiceImpl implements ClothesTypeService {
    @Autowired
    private ClothesTypeMapper clothesTypeMapper;
    /*获取全部租赁衣服种类*/
    @Override
    public List<ClothesType> getAllClothesType() {

        return clothesTypeMapper.selectAll();
    }

    @Override
    public AjaxRes addClothesType(ClothesType clothesType) {
        AjaxRes ajaxRes = new AjaxRes();
        try{
            clothesTypeMapper.insert(clothesType);
            ajaxRes.setMsg("新增衣服种类成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("新增衣服种类失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    @Override
    public AjaxRes deleteClothesType(Long id) {
        AjaxRes ajaxRes = new AjaxRes();
        try{
            /*打破租赁衣服和分类的关系*/
            clothesTypeMapper.updateClothesTypeRel(id);
            clothesTypeMapper.deleteByPrimaryKey(id);
            ajaxRes.setMsg("删除衣服种类成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("删除衣服种类失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    @Override
    public ClothesType getClothesTypeWithId(Long id) {
        return clothesTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public AjaxRes updateClothesType(ClothesType clothesType) {
        AjaxRes ajaxRes = new AjaxRes();
        try{
            clothesTypeMapper.updateByPrimaryKey(clothesType);
            ajaxRes.setMsg("更新衣服种类成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("更新衣服种类失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /*获取全部租赁衣服种类-包括租赁服装*/
    @Override
    public List<ClothesType> getTypeAndClothes() {
        return clothesTypeMapper.getTypeAndClothes();
    }
}
