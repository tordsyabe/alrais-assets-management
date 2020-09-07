package com.alraisent.assetsmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
}
