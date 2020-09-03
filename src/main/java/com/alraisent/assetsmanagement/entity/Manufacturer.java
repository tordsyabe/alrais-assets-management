package com.alraisent.assetsmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "manufacturer")
public class Manufacturer extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column
    private String image;

    @Column
    private String website;

    @Column
    private String supportUrl;

    @Column
    private String supporPhone;

    @Column
    private String supportEmail;


}
