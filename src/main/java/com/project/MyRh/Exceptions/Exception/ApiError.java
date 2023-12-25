package com.project.MyRh.Exceptions.Exception;

import lombok.*;

@Data
@AllArgsConstructor
public class ApiError {
    private String errorMessage;
    private String errorCode;
}
