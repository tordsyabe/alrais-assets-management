package com.alraisent.assetsmanagement.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StatusResponse {

    private String uuid;

    private String name;

    private String type;

    private String notes;
}
