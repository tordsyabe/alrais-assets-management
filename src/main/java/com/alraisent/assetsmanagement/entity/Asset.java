package com.alraisent.assetsmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "assets")
public class Asset extends BaseEntity{

    @Column(nullable = false)
    private String assetTag;

    @ManyToOne
    private Model model;

    @Column(unique = true, nullable = false)
    private String serial;

    @Column(nullable = false)
    private String name;

    private LocalDateTime purchaseDate;

    private String purchaseNumber;

    private String purchaseCost;

    private int warranty;

    private String notes;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Location currentLocation;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Status status;

    private String image;

}
