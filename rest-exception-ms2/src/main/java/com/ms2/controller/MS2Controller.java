package com.ms2.controller;

import com.ms2.model.FailResponse;
import com.ms2.model.GetSampleResponse;
import com.ms2.service.MS2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MS2Controller implements MS2ControllerApi{

    private final MS2Service service;
    @Override
    public ResponseEntity<GetSampleResponse> getJsonData (boolean hasError) {
        return service.getJsonData(hasError);
    }

    @Override
    public ResponseEntity<FailResponse> getXmlData () {
        return service.getXmlResponse();
    }
}
