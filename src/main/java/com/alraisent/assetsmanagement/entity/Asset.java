package com.alraisent.assetsmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "assets")
public class Asset extends BaseEntity{

    @Column(nullable = false)
    private String assetTag;

    @OneToOne
    private Model model;

    @Column(nullable = false)
    private Status status;

    @Column(unique = true, nullable = false)
    private String serial;

    @Column(nullable = false)
    private String name;

    private LocalDate purchaseDate;

    @OneToOne
    private Supplier supplier;

    private String purchaseNumber;

    private String purchaseCost;

    private int warranty;

    private String notes;

    @Column(nullable = false)
    private Location location;

    private String image;

}
