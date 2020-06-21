package com.syh.senior5.controller;

import com.syh.senior5.entity.House;
import com.syh.senior5.entity.HouseVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.path}")
    private String filePath;
    @Value("${file.domain}")
    private String fileDomain;

    @RequestMapping("upload")
    public HashMap<String, Object> upload(@RequestParam("file") MultipartFile file) {
        //返回的结果
        HashMap<String, Object> imgInfo = new HashMap<>();
        //文件名称
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + extName;
        File saveFile = new File(filePath, fileName);
        try {
            file.transferTo(saveFile);
            imgInfo.put("result",true);
            imgInfo.put("imgUrl", fileDomain + fileName);
            imgInfo.put("fileName", fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return imgInfo;
    }

}
