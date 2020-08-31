package com.alraisent.assetsmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "assets")
public class Asset extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String serial;

    @Column(nullable = false)
    private String tag;

    @Column
    private AssetModel assetModel;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Company company;

    @Column
    private LocalDate purchaseDate;

    @Column
    private int warranty;

    @Column String notes;

    @Column Location location;

    @Column String image;



}
