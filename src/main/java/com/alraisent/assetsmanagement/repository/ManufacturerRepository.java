package com.alraisent.assetsmanagement.repository;

import com.alraisent.assetsmanagement.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Manufacturer findByUuid(String id);
}
