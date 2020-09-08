package com.alraisent.assetsmanagement.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StatusRequest {

    private String uuid;

    private String name;

    private String type;

    private String notes;
}
