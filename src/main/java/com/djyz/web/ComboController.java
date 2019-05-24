package com.djyz.web;

import com.djyz.domain.Combo;
import com.djyz.service.ComboService;
import com.djyz.util.AjaxRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    /*添加摄影套餐*/
    @PostMapping("/addCombo")
    @ResponseBody
    public AjaxRes addCombo(Combo combo, @PathVariable MultipartFile[] files, @PathVariable MultipartFile smPicture, HttpSession session){
        System.out.println(combo);
        return comboService.addCombo(combo,files,smPicture,session);
    }

    /*根据id获取套餐*/
    @GetMapping("/getComboWithId/{coId}")
    @ResponseBody
    public Combo getComboWithId(@PathVariable Long coId){
        return comboService.getComboWithId(coId);
    }



}
