package com.sugar.gmail.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @param
 * @return
 */
@Data
public class PmsProductInfo implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "product_name")
    private String spuName;

    @Column
    private String description;

    @Column
    private  String catalog3Id;

    @Transient
    private List<PmsProductSaleAttr> spuSaleAttrList;
    @Transient
    private List<PmsProductImage> spuImageList;
}


