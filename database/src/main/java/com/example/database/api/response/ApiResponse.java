package com.example.database.api.response;

import lombok.*;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.awt.image.PixelGrabber;
import java.util.ArrayList;

// json response body for login

@Setter
@Getter
@AllArgsConstructor
@Builder
public class ApiResponse {
    private int statusCode;

    private Object userInfo;
}
