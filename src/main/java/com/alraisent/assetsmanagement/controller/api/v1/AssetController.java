package com.alraisent.assetsmanagement.controller.api.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/assets")
public class AssetController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String showAssets() {
        return "Hi am assets";
    }
}
