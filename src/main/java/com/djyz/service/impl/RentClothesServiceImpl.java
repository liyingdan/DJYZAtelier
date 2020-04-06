package com.djyz.service.impl;

import com.djyz.service.RedisService;
import com.djyz.util.AjaxRes;
import com.djyz.domain.RentClothes;
import com.djyz.mapper.RentClothesMapper;
import com.djyz.service.RentClothesService;
import com.djyz.util.PageList;
import com.djyz.util.QueryVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RentClothesServiceImpl implements RentClothesService {
    @Autowired
    private RentClothesMapper rentClothesMapper;
    @Autowired
    private RedisService redisService;

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
        //新建存数据库的 map
//        Map<String, Object> stringObjectMap = new HashMap<>();
        try{
//            //先保存到数据库
            rentClothesMapper.insert(rentClothes);
//
//            Long cloId = rentClothes.getCloId();
//            System.out.println("cloId----------------------"+cloId);
//            //封装调用 redis 的map
//            stringObjectMap.put("cloId",cloId);
//            stringObjectMap.put("cloName",rentClothes.getCloName());
//            stringObjectMap.put("cloPrice",rentClothes.getCloPrice());
//            stringObjectMap.put("cloPicture",rentClothes.getCloPicture());
//            stringObjectMap.put("cloAmount",rentClothes.getCloAmount());
//            stringObjectMap.put("cloType",rentClothes.getCloType());
//            //得到类型id
//            Long cloType = rentClothes.getCloType();
//            //生成redis中保存的对应的hashId
//            String hashId = "rentCloType_" + cloType;
//            // 根据 类型id 先保存到 redis 中
//            Boolean aBoolean = redisService.saveHashValue(hashId, stringObjectMap);
//            if(!aBoolean){
//                ajaxRes.setMsg("redis---新增租赁服装失败");
//                ajaxRes.setSuccess(false);
//                return ajaxRes;
//            }
            ajaxRes.setMsg("新增租赁服装成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("新增租赁服装失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    @Override
    public AjaxRes deleteRentClothesWithId(Long cloId) {
        AjaxRes ajaxRes = new AjaxRes();
        try{
            //删除服务器里面的图片图片
//            RentClothes rentClothes1 = rentClothesMapper.selectByPrimaryKey(cloId);
//            String cloPicture = rentClothes1.getCloPicture();
            /*String path = session.getServletContext().getRealPath("/images");
            if(cloPicture != null || !"".equals(cloPicture)){
                File file = new File(path+'/'+cloPicture);
                file.delete();
            }*/
//            fileUpload.deleteFile(cloPicture,session);

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
