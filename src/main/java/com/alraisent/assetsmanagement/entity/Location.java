package com.alraisent.assetsmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "currentLocation")
    private List<Asset> assets = new ArrayList<>();

}
