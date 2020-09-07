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
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @OneToMany(mappedBy = "category")
    private List<Model> models = new ArrayList<>();

}
