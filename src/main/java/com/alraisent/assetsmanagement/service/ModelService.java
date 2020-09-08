package com.alraisent.assetsmanagement.service;

import com.alraisent.assetsmanagement.dto.ModelDto;

import java.util.List;

public interface ModelService {

    List<ModelDto> getModels();

    ModelDto getModelById(String id);

    ModelDto saveModel(ModelDto modelDto);

    void deleteModel(String id);
}
