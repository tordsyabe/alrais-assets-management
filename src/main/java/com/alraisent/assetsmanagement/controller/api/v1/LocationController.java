package com.alraisent.assetsmanagement.controller.api.v1;

import com.alraisent.assetsmanagement.dto.LocationDto;
import com.alraisent.assetsmanagement.mapper.LocationMapper;
import com.alraisent.assetsmanagement.request.LocationRequest;
import com.alraisent.assetsmanagement.response.LocationResponse;
import com.alraisent.assetsmanagement.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/locations")
public class LocationController {

    private final LocationService locationService;
    private final LocationMapper locationMapper;

    public LocationController(LocationService locationService, LocationMapper locationMapper) {
        this.locationService = locationService;
        this.locationMapper = locationMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LocationResponse> showAllLocations() {

        List<LocationResponse> locationResponseList = new ArrayList<>();

        locationService.getLocations().forEach(locationDto -> locationResponseList
                .add(locationMapper.dtoToResponse(locationDto)));

        return locationResponseList;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LocationResponse showLocation(@PathVariable String id) {

        return locationMapper.dtoToResponse(locationService.getLocationById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LocationResponse saveLocation(@RequestBody LocationRequest locationRequest) {

        LocationDto locationDto = locationMapper.requestToDto(locationRequest);

        return locationMapper.dtoToResponse(locationService.saveLocation(locationDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLocation(@PathVariable String id) {
        locationService.deleteLocation(id);
    }
}
