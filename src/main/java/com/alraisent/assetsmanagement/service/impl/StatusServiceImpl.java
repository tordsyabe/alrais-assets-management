package com.alraisent.assetsmanagement.service.impl;

import com.alraisent.assetsmanagement.dto.StatusDto;
import com.alraisent.assetsmanagement.entity.Category;
import com.alraisent.assetsmanagement.entity.Status;
import com.alraisent.assetsmanagement.mapper.StatusMapper;
import com.alraisent.assetsmanagement.repository.StatusRepository;
import com.alraisent.assetsmanagement.service.StatusService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;
    private final StatusMapper statusMapper;

    public StatusServiceImpl(StatusRepository statusRepository, StatusMapper statusMapper) {
        this.statusRepository = statusRepository;
        this.statusMapper = statusMapper;
    }

    @Override
    public List<StatusDto> getStatus() {

        List<StatusDto> statusDtoList = new ArrayList<>();

        statusRepository.findAll().forEach(status -> statusDtoList.add(statusMapper.entityToDto(status)));

        return statusDtoList;
    }

    @Override
    public StatusDto getStatusById(String id){

        return statusMapper.entityToDto(statusRepository.findByUuid(id));
    }

    @Override
    public StatusDto saveStatus(StatusDto statusDto) {

        Status status = statusMapper.dtoToEntity(statusDto);

        if(statusDto.getUuid() != null) {
            Status categoryFromDb = statusRepository.findByUuid(statusDto.getUuid());
            status.setId(categoryFromDb.getId());
            status.setCreatedAt(categoryFromDb.getCreatedAt());
            status.setUpdatedAt(LocalDateTime.now());

            return statusMapper.entityToDto(statusRepository.save(status));
        }

        status.setCreatedAt(LocalDateTime.now());

        status.setUuid(UUID.randomUUID().toString());

        return statusMapper.entityToDto(statusRepository.save(status));

    }

    @Override
    public void deleteStatus(String id) {

    }
}
