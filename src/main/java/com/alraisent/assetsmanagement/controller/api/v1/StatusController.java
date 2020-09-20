package com.alraisent.assetsmanagement.controller.api.v1;

import com.alraisent.assetsmanagement.dto.StatusDto;
import com.alraisent.assetsmanagement.mapper.StatusMapper;
import com.alraisent.assetsmanagement.request.StatusRequest;
import com.alraisent.assetsmanagement.response.StatusResponse;
import com.alraisent.assetsmanagement.service.StatusService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("api/v1/status")
public class StatusController {

    private final StatusService statusService;
    private final StatusMapper statusMapper;

    public StatusController(StatusService statusService, StatusMapper statusMapper) {
        this.statusService = statusService;
        this.statusMapper = statusMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StatusResponse> showAllStatus() {

        List<StatusResponse> statusResponseList = new ArrayList<>();

        statusService.getStatus().forEach(statusDto -> statusResponseList
                .add(statusMapper.dtoToResponse(statusDto)));

        return statusResponseList;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StatusResponse showStatus(@PathVariable String id) {

        return statusMapper.dtoToResponse(statusService.getStatusById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public StatusResponse saveStatus(@RequestBody StatusRequest statusRequest) {

        StatusDto statusDto = statusMapper.requestToDto(statusRequest);

        return statusMapper.dtoToResponse(statusService.saveStatus(statusDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStatus(@PathVariable String id) {
        statusService.deleteStatus(id);
    }
}
