package com.ongdev.lotto.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Data
public class ApiResponseMessage {

    private HttpStatus httpStatus;
    private Object obj;

    private Map<String, Object> result = new HashMap<String, Object>();

    private String message;

    public ApiResponseMessage(HttpStatus httpStatus, Object obj) {
        this.httpStatus = httpStatus;
        this.obj = obj;
        SetResultMessage();
    }

    private void SetResultMessage() {

        if (httpStatus == HttpStatus.OK) {
            message = "success";
        } else if (httpStatus == HttpStatus.BAD_REQUEST) {
            message = "bad request";
        } else if (httpStatus == HttpStatus.NOT_FOUND) {
            message = "not found";
        }

        result.put("message", message);
        result.put("responseDate", obj);
    }
}
