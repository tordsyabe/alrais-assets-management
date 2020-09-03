package com.alraisent.assetsmanagement.controller.api.v1;

import com.alraisent.assetsmanagement.dto.ModelDto;
import com.alraisent.assetsmanagement.entity.Model;
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

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<ModelDto> getAllModels() {

        return modelService.getModels();
    }
}
