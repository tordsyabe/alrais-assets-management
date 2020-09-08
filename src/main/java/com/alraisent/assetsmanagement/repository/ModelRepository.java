package com.alraisent.assetsmanagement.repository;

import com.alraisent.assetsmanagement.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {

    Model findByUuid(String id);
}
