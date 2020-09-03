package com.alraisent.assetsmanagement.service.impl;

import com.alraisent.assetsmanagement.dto.ModelDto;
import com.alraisent.assetsmanagement.mapper.ModelMapper;
import com.alraisent.assetsmanagement.repository.ModelRepository;
import com.alraisent.assetsmanagement.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ModelDto> getModels() {

        List<ModelDto> modelDtoList = new ArrayList<>();


        modelRepository.findAll().forEach(model -> modelDtoList.add(modelMapper.entityToDto(model)));

        return modelDtoList;
    }
}
