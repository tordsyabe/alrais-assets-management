package com.alraisent.assetsmanagement.repository;

import com.alraisent.assetsmanagement.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
