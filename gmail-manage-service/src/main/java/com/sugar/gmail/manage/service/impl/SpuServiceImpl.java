package com.sugar.gmail.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sugar.gmail.bean.PmsProductImage;
import com.sugar.gmail.bean.PmsProductInfo;
import com.sugar.gmail.bean.PmsProductSaleAttr;
import com.sugar.gmail.bean.PmsProductSaleAttrValue;
import com.sugar.gmail.manage.mapper.PmsProductImageMapper;
import com.sugar.gmail.manage.mapper.PmsProductInfoMapper;
import com.sugar.gmail.manage.mapper.PmsProductSaleAttrMapper;
import com.sugar.gmail.manage.mapper.PmsProductSaleAttrValueMapper;
import com.sugar.gmail.service.SpuService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired
    private PmsProductImageMapper pmsProductImageMapper;
    @Autowired
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        return pmsProductInfoMapper.select(pmsProductInfo);
    }

    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        if(pmsProductInfo == null){
            return;
        }
        //保存商品信息
        pmsProductInfoMapper.insert(pmsProductInfo);

        String productInfoId = pmsProductInfo.getId();

        //保存商品图片信息
        List<PmsProductImage> spuImageList = pmsProductInfo.getSpuImageList();
        if(CollectionUtils.isNotEmpty(spuImageList)){
            spuImageList.forEach(pmsProductImage -> pmsProductImage.setProductId(productInfoId));
            pmsProductImageMapper.insertList(pmsProductInfo.getSpuImageList());
        }

        //保存商品属性
        List<PmsProductSaleAttr> spuSaleAttrList = pmsProductInfo.getSpuSaleAttrList();
        if(CollectionUtils.isNotEmpty(spuSaleAttrList)){
            spuSaleAttrList.forEach(pmsProductSaleAttr -> pmsProductSaleAttr.setProductId(productInfoId));
            pmsProductSaleAttrMapper.insertList(spuSaleAttrList);
            //保存商品属性值
            for (PmsProductSaleAttr pmsProductSaleAttr : spuSaleAttrList) {
                List<PmsProductSaleAttrValue> spuSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();
                if(CollectionUtils.isNotEmpty(spuSaleAttrValueList)){
                    spuSaleAttrValueList.forEach(pmsProductSaleAttrValue -> pmsProductSaleAttrValue.setProductId(productInfoId));
                    pmsProductSaleAttrValueMapper.insertList(spuSaleAttrValueList);
                }
            }
        }

    }
}
