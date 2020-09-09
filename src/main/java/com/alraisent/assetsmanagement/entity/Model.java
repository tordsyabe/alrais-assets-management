package com.alraisent.assetsmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private Manufacturer manufacturer;

    @ManyToOne
    private Category category;

    @Column(nullable = false)
    private String modelNumber;

    @OneToMany(mappedBy = "model")
    private List<Asset> assets = new ArrayList<>();
}
