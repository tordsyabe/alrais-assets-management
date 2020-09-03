package com.alraisent.assetsmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String uuid = UUID.randomUUID().toString();

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private LocalDate deletedAt;
}
