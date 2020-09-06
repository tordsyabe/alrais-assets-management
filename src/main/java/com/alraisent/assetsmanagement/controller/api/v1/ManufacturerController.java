package com.alraisent.assetsmanagement.controller.api.v1;

import com.alraisent.assetsmanagement.dto.ManufacturerDto;
import com.alraisent.assetsmanagement.mapper.ManufacturerMapper;
import com.alraisent.assetsmanagement.request.ManufacturerRequest;
import com.alraisent.assetsmanagement.response.ManufacturerResponse;
import com.alraisent.assetsmanagement.service.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/manufacturers")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;
    private final ManufacturerMapper manufacturerMapper;

    public ManufacturerController(ManufacturerService manufacturerService, ManufacturerMapper manufacturerMapper) {
        this.manufacturerService = manufacturerService;
        this.manufacturerMapper = manufacturerMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ManufacturerResponse> showAllManufacturer() {

        List<ManufacturerResponse> manufacturerResponseList = new ArrayList<>();

        manufacturerService.getManufacturers().forEach(manufacturerDto -> manufacturerResponseList
                .add(manufacturerMapper.dtoToResponse(manufacturerDto)));

        return manufacturerResponseList;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ManufacturerResponse showManufacturer(@PathVariable String id) {

        return manufacturerMapper.dtoToResponse(manufacturerService.getManufacturerById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ManufacturerResponse saveManufacturer(@RequestBody ManufacturerRequest manufacturerRequest) {

        ManufacturerDto manufacturerDto = manufacturerMapper.requestToDto(manufacturerRequest);

        return manufacturerMapper.dtoToResponse(manufacturerService.saveManufacturer(manufacturerDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteManufacturer(@PathVariable String id) {

        manufacturerService.deleteManufacturer(id);
    }
}
