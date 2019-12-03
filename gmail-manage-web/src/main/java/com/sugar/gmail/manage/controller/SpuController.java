package com.sugar.gmail.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sugar.gmail.bean.PmsProductInfo;
import com.sugar.gmail.service.SpuService;
import com.sugar.gmail.web.util.PmsFileuploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
public class SpuController {

    private Logger logger = LoggerFactory.getLogger(SpuController.class);

    @Reference
    private SpuService spuService;

    /**
     * 图片文件上传
     *
     * @param file 文件
     * @return 文件访问url
     */
    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        String url = PmsFileuploadUtil.uploafImg(file);
        logger.info("图片url:{}",url);
        return url;
    }

    @RequestMapping("saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        spuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }

    @GetMapping("/spuList")
    public List<PmsProductInfo> spuList(String catalog3Id) {
        return spuService.spuList(catalog3Id);
    }
}
