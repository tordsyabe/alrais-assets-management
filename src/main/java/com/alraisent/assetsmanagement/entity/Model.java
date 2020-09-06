package com.alraisent.assetsmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private Manufacturer manufacturer;

    @Column
    private Category category;

    @Column(nullable = false)
    private String modelNumber;
}
