package com.example.database.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.awt.image.PixelGrabber;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@Builder
public class ApiResponse {
    private int code;
    private String message;
    private Object data;

    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ApiResponse success (Object data, int code, String message) {
        Object dataList = new ArrayList<>();
        if (!ObjectUtils.isEmpty(data)) {
            dataList = data;
        }
        return ApiResponse.builder()
                .message(StringUtils.hasText(message) ? message : "")
                .code(code)
                .data(dataList)
                .build();
    }
}
