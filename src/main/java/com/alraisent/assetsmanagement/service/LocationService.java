package com.alraisent.assetsmanagement.service;

import com.alraisent.assetsmanagement.dto.LocationDto;

import java.util.List;

public interface LocationService {

    List<LocationDto> getLocations();

    LocationDto getLocationById(String id);

    LocationDto saveLocation(LocationDto locationDto);

    void deleteLocation(String id);
}
