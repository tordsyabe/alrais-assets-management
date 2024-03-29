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
@Table(name = "manufacturers")
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
    private String supportPhone;

    @Column
    private String supportEmail;

    @OneToMany(mappedBy = "manufacturer")
    private List<Model> models = new ArrayList<>();
}
