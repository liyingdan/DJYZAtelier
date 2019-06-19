package com.djyz.service.impl;

import com.djyz.util.AjaxRes;
import com.djyz.domain.RentClothes;
import com.djyz.mapper.RentClothesMapper;
import com.djyz.service.RentClothesService;
import com.djyz.util.FileUpload;
import com.djyz.util.PageList;
import com.djyz.util.QueryVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional
public class RentClothesServiceImpl implements RentClothesService {
    @Autowired
    private RentClothesMapper rentClothesMapper;
    @Autowired
    private FileUpload fileUpload;

    /*根据服装分类的id获取服装*/
    @Override
    public List<RentClothes> getClothesWithTypeId(Long cloType) {
        List<RentClothes> clothes = rentClothesMapper.getClothesWithTypeId(cloType);
        return clothes;
    }

    /*添加租赁服装*/
    @Override
    public AjaxRes addRentClothes(RentClothes rentClothes) {
        AjaxRes ajaxRes = new AjaxRes();
        try{
            rentClothesMapper.insert(rentClothes);
            ajaxRes.setMsg("新增租赁服装成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("新增租赁服装失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    @Override
    public AjaxRes deleteRentClothesWithId(Long cloId, HttpSession session) {
        AjaxRes ajaxRes = new AjaxRes();
        try{
            //删除服务器里面的图片图片
            RentClothes rentClothes1 = rentClothesMapper.selectByPrimaryKey(cloId);
            String cloPicture = rentClothes1.getCloPicture();
            /*String path = session.getServletContext().getRealPath("/images");
            if(cloPicture != null || !"".equals(cloPicture)){
                File file = new File(path+'/'+cloPicture);
                file.delete();
            }*/
            fileUpload.deleteFile(cloPicture,session);

            rentClothesMapper.deleteByPrimaryKey(cloId);
            ajaxRes.setMsg("删除租赁服装成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("删除租赁服装失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /*根据id获取租赁服装*/
    @Override
    public RentClothes getClothesWithId(Long cloId) {
        return rentClothesMapper.selectByPrimaryKey(cloId);

    }

    @Override
    public void updateRentClothes(RentClothes rentClothes) {
        rentClothesMapper.updateByPrimaryKey(rentClothes);
    }


    /*查询全部租赁服装-分页*/
    @Override
    public PageList getAllRentClothes(QueryVo vo) {
        Page<Object> page = PageHelper.startPage(vo.getPageNum(), vo.getRows());

        List<RentClothes> rentClothes = rentClothesMapper.selectAll(vo);
        //封装pageList
        PageList pageList = new PageList();
        pageList.setTotal(page.getTotal());
        pageList.setRows(rentClothes);

        return pageList;
    }

    /*查询全部-不分页-高级查询*/
    @Override
    public List<RentClothes> getAllClothes(QueryVo vo) {
        return rentClothesMapper.selectAll(vo);
    }


}
