package com.ms2.controller;

import com.ms2.model.FailResponse;
import com.ms2.model.GetSampleResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/v1")
public interface MS2ControllerApi {

    @GetMapping("/json")
    ResponseEntity<GetSampleResponse> getJsonData(@RequestParam boolean hasError);

    @GetMapping(path = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<FailResponse> getXmlData ();

}
