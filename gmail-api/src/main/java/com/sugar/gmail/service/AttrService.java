package com.sugar.gmail.service;

import com.sugar.gmail.bean.PmsBaseAttrInfo;
import com.sugar.gmail.bean.PmsBaseAttrValue;
import com.sugar.gmail.bean.PmsBaseSaleAttr;

import java.util.List;

public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
