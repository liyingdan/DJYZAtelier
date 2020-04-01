package com.djyz.web;

import com.djyz.util.FileUpload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

    @ApiOperation("上传图片")
    @PostMapping(value = "/uploadPicture",
            consumes = "multipart/*", headers = "content-type=multipart/form-data")
    @ResponseBody
    public String uploadPicture(MultipartFile file, HttpSession session) throws IOException {
        return fileUpload.upload(file, session);
    }

}
