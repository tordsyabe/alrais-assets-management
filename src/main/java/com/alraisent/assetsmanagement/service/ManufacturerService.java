package com.alraisent.assetsmanagement.service;

import com.alraisent.assetsmanagement.dto.ManufacturerDto;

import java.util.List;

public interface ManufacturerService {

    List<ManufacturerDto> getManufacturers();

    ManufacturerDto getManufacturerById(String id);

    ManufacturerDto saveManufacturer(ManufacturerDto manufacturerDto);

    void deleteManufacturer(String id);

}
