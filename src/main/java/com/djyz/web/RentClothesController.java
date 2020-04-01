package com.djyz.web;

import com.alibaba.fastjson.JSONObject;
import com.djyz.util.*;
import com.djyz.domain.RentClothes;
import com.djyz.service.RentClothesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.management.Query;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@Controller
@Api(value = "/RentClothes", tags = "RentClothes接口")
public class RentClothesController {
    @Autowired
    private RentClothesService rentClothesService;
    @Autowired
    private FileUpload fileUpload;

    /*根据服装分类的id获取服装*/
    @GetMapping("/getClothesWithTypeId/{cloType}")
    @ResponseBody
    public List<RentClothes> getClothesWithTypeId(@PathVariable Long cloType){
        List<RentClothes> clothes = rentClothesService.getClothesWithTypeId(cloType);
        return clothes;
    }

    /*添加租赁服装*/
    @ApiOperation("租赁服装增加--")
    @PostMapping(value = "/addRentClothes")
    @ResponseBody
    public AjaxRes addRentClothes(RentClothes rentClothes) throws IOException {
        return rentClothesService.addRentClothes(rentClothes);
    }


    /*根据id删除租赁服装*/
    @DeleteMapping("/deleteRentClothesWithId/{cloId}")
    @ResponseBody
    public AjaxRes deleteRentClothesWithId(@PathVariable Long cloId, HttpSession session){
        return rentClothesService.deleteRentClothesWithId(cloId,session);
    }

    /*根据id获取租赁服装*/
    @GetMapping("/getClothesWithId/{cloId}")
    @ResponseBody
    public RentClothes getClothesWithId(@PathVariable Long cloId){
        return rentClothesService.getClothesWithId(cloId);
    }

    /*修改租赁服装------------put过不来方法上--先使用post代替-----返回值错误，但是可以正确修改内容*/
   @ApiOperation("租赁服装修改--")
   @PostMapping(value = "/editRentClothes")
   @ResponseBody
   public AjaxRes editRentClothes(RentClothes rentClothes) throws IOException {
       AjaxRes ajaxRes = new AjaxRes();
       RentClothes clothesWithId = rentClothesService.getClothesWithId(rentClothes.getCloId());
       try{
           if(rentClothes.getCloName() != null || !"".equals(rentClothes.getCloName()))
               clothesWithId.setCloName(rentClothes.getCloName());
           if(rentClothes.getCloPrice() != null)
               clothesWithId.setCloPrice(rentClothes.getCloPrice());
           if(rentClothes.getCloAmount() != null)
               clothesWithId.setCloAmount(rentClothes.getCloAmount());
           if(rentClothes.getCloType() != null)
               clothesWithId.setCloType(rentClothes.getCloType());
           //如果file不为空，删除之前上传到服务器的图片，然后再上传新的图片
           if(rentClothes.getCloPicture() != null || !"".equals(rentClothes.getCloPicture()))
               clothesWithId.setCloPicture(rentClothes.getCloPicture());

           //更新
           rentClothesService.updateRentClothes(clothesWithId);

           ajaxRes.setMsg("更新租赁服装成功");
           ajaxRes.setSuccess(true);
       }catch (Exception e){
           ajaxRes.setMsg("更新租赁服装失败");
           ajaxRes.setSuccess(false);
       }
       return ajaxRes;
   }


   /*查询全部租赁服装-分页*/
    @GetMapping("/getAllRentClothes")
    @ResponseBody
    public PageList getAllRentClothes(QueryVo vo){
        return rentClothesService.getAllRentClothes(vo);

    }

    /*查询租赁服装-不分页-高级查询*/
    @GetMapping("/getAllClothes")
    @ResponseBody
    public List<RentClothes> getAllClothes(QueryVo vo){
        return rentClothesService.getAllClothes(vo);
    }




    }
