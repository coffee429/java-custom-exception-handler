package com.ms2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FailResponse {
    private String code;
    private String message;
}
