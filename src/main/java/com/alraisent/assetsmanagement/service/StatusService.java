package com.alraisent.assetsmanagement.service;

import com.alraisent.assetsmanagement.dto.StatusDto;

import java.util.List;

public interface StatusService {

    List<StatusDto> getStatus();

    StatusDto getStatusById(String id);

    StatusDto saveStatus(StatusDto statusDto);

    void deleteStatus(String id);
}
