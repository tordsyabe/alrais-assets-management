package com.alraisent.assetsmanagement.repository;

import com.alraisent.assetsmanagement.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {

    Status findByUuid(String id);
}
