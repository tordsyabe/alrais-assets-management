package com.alraisent.assetsmanagement.service.impl;

import com.alraisent.assetsmanagement.dto.CategoryDto;
import com.alraisent.assetsmanagement.dto.ManufacturerDto;
import com.alraisent.assetsmanagement.dto.ModelDto;
import com.alraisent.assetsmanagement.entity.Model;
import com.alraisent.assetsmanagement.mapper.ModelMapper;
import com.alraisent.assetsmanagement.repository.ModelRepository;
import com.alraisent.assetsmanagement.service.CategoryService;
import com.alraisent.assetsmanagement.service.ManufacturerService;
import com.alraisent.assetsmanagement.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;
    private final ManufacturerService manufacturerService;
    private final CategoryService categoryService;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper, ManufacturerService manufacturerService, CategoryService categoryService) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
        this.manufacturerService = manufacturerService;
        this.categoryService = categoryService;
    }

    @Override
    public List<ModelDto> getModels() {

        List<ModelDto> modelDtoList = new ArrayList<>();


        modelRepository.findAll().forEach(model -> modelDtoList.add(modelMapper.entityToDto(model)));

        return modelDtoList;
    }

    @Override
    public ModelDto saveModel(ModelDto modelDto) {

        ManufacturerDto manufacturerDto = manufacturerService.getManufacturerById(modelDto.getManufacturerId());
        CategoryDto categoryDto = categoryService.getCategoryById(modelDto.getCategoryId());

        modelDto.setCategoryDto(categoryDto);
        modelDto.setManufacturerDto(manufacturerDto);
        modelDto.setUuid(UUID.randomUUID().toString());

        Model savedModel = modelRepository.save(modelMapper.dtoToEntity(modelDto));

        return modelMapper.entityToDto(savedModel);
    }
}
