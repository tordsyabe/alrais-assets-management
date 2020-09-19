package com.alraisent.assetsmanagement.controller.api.v1;

import com.alraisent.assetsmanagement.dto.ModelDto;
import com.alraisent.assetsmanagement.mapper.ModelMapper;
import com.alraisent.assetsmanagement.request.ModelRequest;
import com.alraisent.assetsmanagement.response.ModelResponse;
import com.alraisent.assetsmanagement.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(maxAge = 3600)
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
    public List<ModelResponse> showAllModels() {

        List<ModelResponse> modelResponses =  new ArrayList<>();

        modelService.getModels().forEach(modelDto -> modelResponses.add(modelMapper.dtoToResponse(modelDto)));

        return modelResponses;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ModelResponse showModel(@PathVariable String id) {

        return modelMapper.dtoToResponse(modelService.getModelById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ModelResponse saveModel(@RequestBody ModelRequest modelRequest) {

        ModelDto modelDto = modelMapper.requestToDto(modelRequest);

        return modelMapper.dtoToResponse(modelService.saveModel(modelDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteModel(@PathVariable String id) {
        modelService.deleteModel(id);
    }

}
