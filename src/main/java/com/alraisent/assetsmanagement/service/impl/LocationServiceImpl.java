package com.alraisent.assetsmanagement.service.impl;

import com.alraisent.assetsmanagement.dto.LocationDto;
import com.alraisent.assetsmanagement.entity.Location;
import com.alraisent.assetsmanagement.mapper.LocationMapper;
import com.alraisent.assetsmanagement.repository.LocationRepository;
import com.alraisent.assetsmanagement.service.LocationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationServiceImpl(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    @Override
    public List<LocationDto> getLocations() {

        List<LocationDto> locationDtoList = new ArrayList<>();

        locationRepository.findAll().forEach(status -> locationDtoList.add(locationMapper.entityToDto(status)));

        return locationDtoList;

    }

    @Override
    public LocationDto getLocationById(String id) {
        return locationMapper.entityToDto(locationRepository.findByUuid(id));
    }

    @Override
    public LocationDto saveLocation(LocationDto locationDto) {
        Location location = locationMapper.dtoToEntity(locationDto);

        if(locationDto.getUuid() != null) {
            Location locationFromDb = locationRepository.findByUuid(locationDto.getUuid());
            location.setId(locationFromDb.getId());
            location.setCreatedAt(locationFromDb.getCreatedAt());
            location.setUpdatedAt(LocalDateTime.now());

            return locationMapper.entityToDto(locationRepository.save(location));
        }

        location.setCreatedAt(LocalDateTime.now());

        location.setUuid(UUID.randomUUID().toString());

        return locationMapper.entityToDto(locationRepository.save(location));
    }

    @Override
    public void deleteLocation(String id) {
        Location locationToDelete = locationRepository.findByUuid(id);

        locationRepository.delete(locationToDelete);
    }
}
