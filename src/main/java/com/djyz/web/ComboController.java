package com.djyz.web;

import com.alibaba.fastjson.JSONObject;
import com.djyz.domain.Combo;
import com.djyz.service.ComboService;
import com.djyz.util.AjaxRes;
import com.djyz.util.CommonUtil;
import com.djyz.util.StatusEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Api(value = "/combo", tags = "combo接口")
public class ComboController {
    @Autowired
    private ComboService comboService;

    /*获取所有的摄影套餐*/
    @GetMapping("/getAllCombo")
    @ResponseBody
    public List<Combo> getAllCombo(){
        return comboService.getAllCombo();
    }

    /*根据id获取套餐*/
    @GetMapping("/getComboWithId/{coId}")
    @ResponseBody
    public Combo getComboWithId(@PathVariable Long coId){
        return comboService.getComboWithId(coId);
    }

    /*添加摄影套餐(增加可拍摄地点和相应的价格)*/
    @PostMapping("/addCombo")
    @ResponseBody
    public AjaxRes addCombo(Combo combo){
        return comboService.addCombo(combo);
    }

    /*根据套餐分类id获取该类所有套餐*/
    @GetMapping("/getCombosWithAid/{tid}")
    @ResponseBody
    public List<Combo> getCombosWithAid(@PathVariable Long tid){
        return comboService.getCombosWithAid(tid);
    }

    /*根据id删除*/
    @DeleteMapping("/deleteCombosWith/{comOrderId}")
    @ResponseBody
    public AjaxRes deleteCombosWith(@PathVariable Long comOrderId){
        return comboService.deleteCombosWith(comOrderId);
    }




}
