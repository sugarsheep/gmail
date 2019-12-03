package com.sugar.gmail.service;

import com.sugar.gmail.bean.PmsProductInfo;

import java.util.List;

public interface SpuService {
    List<PmsProductInfo> spuList(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);
}
