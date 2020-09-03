package com.alraisent.assetsmanagement.repository;

import com.alraisent.assetsmanagement.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
