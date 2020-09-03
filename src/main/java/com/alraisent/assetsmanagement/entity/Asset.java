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
public class Asset extends BaseEntity{

    @Column(nullable = false)
    private Company company;

    @Column(nullable = false)
    private String assetTag;

    @Column
    private Model model;

    @Column(nullable = false)
    private Status status;

    @Column(unique = true, nullable = false)
    private String serial;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Column
    private Supplier supplier;

    @Column
    private String purchaseNumber;

    @Column
    private String purchaseCost;

    @Column
    private int warranty;

    @Column
    private String notes;

    @Column(nullable = false)
    private Location defaultLocation;

    @Column
    private String image;

}
