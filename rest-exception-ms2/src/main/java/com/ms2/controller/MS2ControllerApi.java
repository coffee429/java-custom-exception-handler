package com.ms2.controller;

import com.ms2.model.GetSampleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/v1")
public interface MS2ControllerApi {

    @GetMapping("/data")
    public ResponseEntity<GetSampleResponse> getSampleData(@RequestParam boolean hasError);

}
