package com.djyz.web;

import com.djyz.domain.Combotype;
import com.djyz.service.CombotypeService;
import com.djyz.util.AjaxRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Api(value = "/Combotype", tags = "Combotype接口")
public class CombotypeController {
    @Autowired
    private CombotypeService combotypeService;

    /*查询所有的套餐类型*/
    @ApiOperation("摄影套餐类型查询--")
    @GetMapping("/getAllCombotype")
    @ResponseBody
    public List<Combotype> getAllCombotype(){
        return combotypeService.getAllCombotype();
    }


    /*增加套餐类型*/
    @ApiOperation("摄影套餐增加--")
    @PostMapping(value = "/addCombotype/{tname}/{tdec}/{file}")
    @ResponseBody
    public AjaxRes addCombotype(@PathVariable String tname, @PathVariable String tdec,
                                  @PathVariable MultipartFile file, HttpSession session){
        return combotypeService.addCombotype(tname,tdec,file,session);
    }


    /*根据id查询套餐分类*/
    @GetMapping("/getCombotypeWithId/{tid}")
    @ResponseBody
    public Combotype getCombotypeWithId(@PathVariable Long tid){
        return combotypeService.getCombotypeWithId(tid);
    }

    /*修改套餐类型*/
    @ApiOperation("摄影套餐修改--")
    @PostMapping(value = "/editCombotype/{tid}/{tname}/{tdec}/{file}")
    @ResponseBody
    public AjaxRes editCombotype(@PathVariable Long tid, @PathVariable String tname, @PathVariable String tdec,
                                @PathVariable MultipartFile file, HttpSession session){
        return combotypeService.editCombotype(tid,tname,tdec,file,session);
    }





}
