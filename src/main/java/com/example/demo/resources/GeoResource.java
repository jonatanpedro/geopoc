package com.example.demo.resources;

import com.example.demo.domain.GeoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoResource {

    private GeoUseCase useCase;

    @Autowired
    public GeoResource(GeoUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/coord")
    public String coord(@RequestParam(value = "lat") Double lat, @RequestParam(value = "long") Double lon) {
        if (useCase.verifyIfLatLongIsInRegion(lat, lon))
            return "ok";
        return "Nok";
    }
}
