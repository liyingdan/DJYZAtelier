package com.djyz.web;

import com.djyz.mapper.ComboOrderMapper;
import com.djyz.util.AjaxRes;
import com.djyz.util.FileUpload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author liyingdan
 * @date 2020/4/1
 */
@Controller
@Api(value = "/UploadPic", tags = "UploadPic接口")
public class UploadController {
    @Autowired
    private FileUpload fileUpload;
    @Autowired
    private ComboOrderMapper comboOrderMapper;

    @ApiOperation("上传图片")
    @PostMapping(value = "/uploadPicture",
            consumes = "multipart/*", headers = "content-type=multipart/form-data")
    @ResponseBody
    public String uploadPicture(MultipartFile file, HttpSession session) throws IOException {
        return fileUpload.upload(file, session);
    }

    /**
     * 摄影师上传拍摄完成的照片
     * 参数：上传图片，订单id
     * */
    @ApiOperation("上传拍摄订单图片")
    @PostMapping(value = "/uploadComboOrderPicture",
            consumes = "multipart/*", headers = "content-type=multipart/form-data")
    @ResponseBody
    public AjaxRes uploadComboOrderPicture(Long comOrderId, MultipartFile file, HttpSession session) throws IOException {
        AjaxRes ajaxRes = new AjaxRes();

        try {

            String comboOrderProducts = fileUpload.upload(file, session);

            comboOrderMapper.uploadComboOrderPicture(comOrderId,comboOrderProducts);

            ajaxRes.setSuccess(true);
        } catch (IOException e) {
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg(e.getMessage());
        }
        return ajaxRes;


    }


    /*
    * 下载文件
    * */
    @ApiOperation("下载文件")
    @GetMapping("/fileDownload/{fileName}")
    public void fileDownload(String fileName, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws Exception {
        fileUpload.fileDownload(fileName,req,resp,session);
    }


}
