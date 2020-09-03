package com.alraisent.assetsmanagement.controller.api.v1;

import com.alraisent.assetsmanagement.mapper.ModelMapper;
import com.alraisent.assetsmanagement.response.ModelResponse;
import com.alraisent.assetsmanagement.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/models")
public class ModelController {

    private final ModelService modelService;
    private final ModelMapper modelMapper;

    public ModelController(ModelService modelService, ModelMapper modelMapper) {
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<ModelResponse> getAllModels() {

        List<ModelResponse> modelResponses =  new ArrayList<>();

        modelService.getModels().forEach(modelDto -> modelResponses.add(modelMapper.dtoToResponse(modelDto)));

        return modelResponses;
    }
}
