package com.ms2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GetSampleResponse {
    private SuccessResponse data;
    private FailResponse error;
}

