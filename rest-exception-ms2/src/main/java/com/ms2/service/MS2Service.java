package com.ms2.service;

import com.ms2.model.FailResponse;
import com.ms2.model.GetSampleResponse;
import com.ms2.model.SuccessResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MS2Service {

    public ResponseEntity<GetSampleResponse> getJsonData (boolean hasError) {
        try {
            return hasError ? new ResponseEntity(buildFailRes(),
                                                 HttpStatus.INTERNAL_SERVER_ERROR) : new ResponseEntity(buildSuccessRes(),
                                                                                                        HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(buildFailRes(),
                                      HttpStatus.BAD_REQUEST);
        }

    }

    private GetSampleResponse buildSuccessRes () {
        SuccessResponse data = SuccessResponse.builder()
                                              .id(Math.random())
                                              .mess1(buildRandomMessage())
                                              .mess2(buildRandomMessage())
                                              .build();

        return GetSampleResponse.builder()
                                .data(data)
                                .build();
    }

    private GetSampleResponse buildFailRes () {
        FailResponse error = FailResponse.builder()
                                         .code("ERROR")
                                         .message(buildRandomMessage())
                                         .build();

        return GetSampleResponse.builder()
                                .error(error)
                                .build();
    }

    private String buildRandomMessage () {
        int length = 20;
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length,
                                        useLetters,
                                        useNumbers);
    }

    private FailResponse buildFailResForXml () {
        return FailResponse.builder()
                           .code("ERROR")
                           .message(buildRandomMessage())
                           .build();
    }

    public ResponseEntity<FailResponse> getXmlResponse () {
        return new ResponseEntity(buildFailResForXml(),
                                  HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
