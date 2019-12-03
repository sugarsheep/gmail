package com.sugar.gmail.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sugar.gmail.bean.PmsBaseAttrInfo;
import com.sugar.gmail.bean.PmsBaseAttrValue;
import com.sugar.gmail.bean.PmsBaseSaleAttr;
import com.sugar.gmail.service.AttrService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class AttrController {

    @Reference
    private AttrService attrService;

    @RequestMapping("/baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return attrService.baseSaleAttrList();
    }

    @RequestMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        return attrService.attrInfoList(catalog3Id);
    }

    @RequestMapping("/getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        return attrService.getAttrValueList(attrId);
    }

    @RequestMapping("/saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        return attrService.saveAttrInfo(pmsBaseAttrInfo);
    }

}
