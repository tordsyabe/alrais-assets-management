package com.alraisent.assetsmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "assetModels")
public class AssetModel extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column
    private Manufacturer manufacturer;

    @Column
    private Category category;

    @Column
    private String modelNumber;
}
