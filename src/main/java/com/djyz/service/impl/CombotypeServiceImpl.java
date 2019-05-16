package com.djyz.service.impl;

import com.djyz.domain.Combotype;
import com.djyz.mapper.CombotypeMapper;
import com.djyz.service.CombotypeService;
import com.djyz.util.AjaxRes;
import com.djyz.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional
public class CombotypeServiceImpl implements CombotypeService {
    @Autowired
    private CombotypeMapper combotypeMapper;
    @Autowired
    private FileUpload fileUpload;



    @Override
    public List<Combotype> getAllCombotype() {
        return combotypeMapper.selectAll();
    }

    /*增加套餐类型*/
    @Override
    public AjaxRes addCombotype(String tname, String tdec, MultipartFile file, HttpSession session) {
        AjaxRes ajaxRes = new AjaxRes();
        try{
            Combotype combotype = new Combotype();
            combotype.setTname(tname);
            combotype.setTdec(tdec);
            //上传图片
            if(file != null || !"".equals(file)){
                String filename = fileUpload.upload(file, session);
                combotype.setTpicture(filename);
            }
            //新增
            combotypeMapper.insert(combotype);

            ajaxRes.setMsg("新增套餐类型成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("新增套餐类型失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /*根据id查询套餐分类*/
    @Override
    public Combotype getCombotypeWithId(Long tid) {
        return combotypeMapper.selectByPrimaryKey(tid);
    }

    /*编辑套餐类型*/
    @Override
    public AjaxRes editCombotype(Long tid, String tname, String tdec, MultipartFile file, HttpSession session) {
        AjaxRes ajaxRes = new AjaxRes();
        Combotype combotype = new Combotype();
        try{
            combotype.setTid(tid);
            combotype.setTname(tname);
            combotype.setTdec(tdec);
            if(file != null || !"".equals(file)){
                Combotype combotype1 = combotypeMapper.selectByPrimaryKey(tid);
                String tpicture = combotype1.getTpicture();
                //删除原来的图片
                if(tpicture != null || !"".equals(tpicture)){
                    fileUpload.deleteFile(tpicture,session);
                }
                //上传新的图片
                String filename = fileUpload.upload(file, session);
                combotype.setTpicture(filename);
            }
            //修改
            combotypeMapper.updateByPrimaryKey(combotype);

            ajaxRes.setMsg("修改套餐类型成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("修改套餐类型失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }




}
