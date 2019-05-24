package com.djyz.web;

import com.djyz.domain.ShootingLocation;
import com.djyz.service.ShootingLocationService;
import com.djyz.util.AjaxRes;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Api(value = "/ShootingLocation", tags = "ShootingLocation接口")
public class ShootingLocationController {
    @Autowired
    private ShootingLocationService shootingLocationService;

    /*增加摄影地点*/
    @PostMapping("/addShootingLocation")
    @ResponseBody
    public AjaxRes addShootingLocation(ShootingLocation shootingLocation){
        System.out.println("web---------------------"+shootingLocation);
        return shootingLocationService.addShootingLocation(shootingLocation);
    }

    /*根据地点获取可拍摄的天数--添加订单之前*/
    @GetMapping("/getDatesWithId/{lid}")
    @ResponseBody
    public List<String> getDatesWithId(@PathVariable Long lid){
        return shootingLocationService.getDatesWithId(lid);
    }
}
