package com.alraisent.assetsmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "locations")
public class Location extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column
    private String address;

    @Column
    private String city;

}
