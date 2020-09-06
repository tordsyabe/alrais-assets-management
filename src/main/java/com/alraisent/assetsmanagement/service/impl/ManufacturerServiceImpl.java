package com.alraisent.assetsmanagement.service.impl;

import com.alraisent.assetsmanagement.dto.ManufacturerDto;
import com.alraisent.assetsmanagement.entity.Manufacturer;
import com.alraisent.assetsmanagement.mapper.ManufacturerMapper;
import com.alraisent.assetsmanagement.repository.ManufacturerRepository;
import com.alraisent.assetsmanagement.service.ManufacturerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerMapper manufacturerMapper;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository, ManufacturerMapper manufacturerMapper) {
        this.manufacturerRepository = manufacturerRepository;
        this.manufacturerMapper = manufacturerMapper;
    }

    @Override
    public List<ManufacturerDto> getManufacturers() {

        List<ManufacturerDto> manufacturerDtoList = new ArrayList<>();

        manufacturerRepository.findAll().forEach(manufacturer -> manufacturerDtoList
                .add(manufacturerMapper.entityToDto(manufacturer)));

        return manufacturerDtoList;
    }

    @Override
    public ManufacturerDto getManufacturerById(String id) {

        return manufacturerMapper.entityToDto( manufacturerRepository.findByUuid(id));
    }

    @Override
    public ManufacturerDto saveManufacturer(ManufacturerDto manufacturerDto) {

        Manufacturer manufacturer = manufacturerMapper.dtoToEntity(manufacturerDto);

        if(manufacturerDto.getUuid() != null) {
            Manufacturer manufacturerFromDb = manufacturerRepository.findByUuid(manufacturerDto.getUuid());

            manufacturer.setId(manufacturerFromDb.getId());
            manufacturer.setCreatedAt(manufacturerFromDb.getCreatedAt());
            manufacturer.setUpdatedAt(LocalDateTime.now());

            return manufacturerMapper.entityToDto(manufacturerRepository.save(manufacturer));
        }

        manufacturer.setCreatedAt(LocalDateTime.now());
        manufacturer.setUuid(UUID.randomUUID().toString());

        return manufacturerMapper.entityToDto(manufacturerRepository.save(manufacturer));
    }

    @Override
    public void deleteManufacturer(String id) {

        Manufacturer manufacturerToDelete = manufacturerRepository.findByUuid(id);

        manufacturerRepository.delete(manufacturerToDelete);

    }
}
