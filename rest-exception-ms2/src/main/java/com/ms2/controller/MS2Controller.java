package com.ms2.controller;

import com.ms2.model.GetSampleResponse;
import com.ms2.service.MS2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MS2Controller implements MS2ControllerApi{

    private final MS2Service service;
    @Override
    public ResponseEntity<GetSampleResponse> getSampleData (boolean hasError) {
        return service.getSampleData(hasError);
    }
}
