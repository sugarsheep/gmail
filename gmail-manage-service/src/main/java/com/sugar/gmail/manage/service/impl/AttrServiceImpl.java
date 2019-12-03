package com.sugar.gmail.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sugar.gmail.bean.PmsBaseAttrInfo;
import com.sugar.gmail.bean.PmsBaseAttrValue;
import com.sugar.gmail.bean.PmsBaseSaleAttr;
import com.sugar.gmail.manage.mapper.PmsBaseAttrInfoMapper;
import com.sugar.gmail.manage.mapper.PmsBaseAttrValueMapper;
import com.sugar.gmail.manage.mapper.PmsBaseSaleAttrMapper;
import com.sugar.gmail.service.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    private PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;
    @Autowired
    private PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        return pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        //新增
        if (StringUtils.isEmpty(pmsBaseAttrInfo.getId())) {
            //保存属性名
            pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);

            //保存属性值
            pmsBaseAttrInfo.getAttrValueList().forEach(a -> {
                a.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMapper.insertSelective(a);
            });
        } else {
            PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
            //删除之前的属性
            pmsBaseAttrValueMapper.delete(pmsBaseAttrValue);
            //保存属性值
            pmsBaseAttrInfo.getAttrValueList().forEach(a -> {
                a.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMapper.insertSelective(a);
            });
        }

        return "success";
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {

        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);

        return pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectAll();
    }
}
