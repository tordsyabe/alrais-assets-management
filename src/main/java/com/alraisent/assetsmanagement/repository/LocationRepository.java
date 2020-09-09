package com.alraisent.assetsmanagement.repository;

import com.alraisent.assetsmanagement.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface LocationRepository extends JpaRepository<Location, Long> {

    Location findByUuid(String id);

}
