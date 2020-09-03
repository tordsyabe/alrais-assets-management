package com.alraisent.assetsmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column
    private String address;

    @Column
    private String contactName;

    @Column
    private String email;

    @Column
    private String phone;

}
