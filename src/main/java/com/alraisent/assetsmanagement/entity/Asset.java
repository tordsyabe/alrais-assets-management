package com.alraisent.assetsmanagement.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "assets")
public class Asset extends BaseEntity{

    @Column(nullable = false)
    private String assetTag;

    @Column(unique = true, nullable = false)
    private String serial;

    @Column(nullable = false)
    private String name;

    private LocalDate purchaseDate;

    private String purchaseNumber;

    private String purchaseCost;

    private int warranty;

    private String notes;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Status status;

    @ManyToOne
    private Model model;

    private String image;

}
