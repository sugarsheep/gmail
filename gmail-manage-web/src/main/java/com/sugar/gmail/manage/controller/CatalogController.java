package com.sugar.gmail.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sugar.gmail.bean.PmsBaseCatalog1;
import com.sugar.gmail.bean.PmsBaseCatalog2;
import com.sugar.gmail.bean.PmsBaseCatalog3;
import com.sugar.gmail.service.CatalogService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CatalogController {

    @Reference
    private CatalogService catalogService;

    @PostMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1() {
        return catalogService.getCatalog1();
    }
    @PostMapping("/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        return catalogService.getCatalog2(catalog1Id);
    }
    @PostMapping("/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        return catalogService.getCatalog3(catalog2Id);
    }
}
