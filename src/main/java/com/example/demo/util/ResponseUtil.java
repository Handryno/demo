package com.example.demo.util;

import com.example.demo.dto.ResponseService;

public class ResponseUtil {
    public static ResponseService setResponse(Constants.RESPONSE response, Object obj) {
        ResponseService res = new ResponseService();
        res.setResponseCode(response.getCode());
        res.setResponseDesc(response.getDescription());
        res.setData(obj);
        return res;
    }

    public static ResponseService setResponse(Constants.RESPONSE response, String customMessage, Object obj) {
        ResponseService res = new ResponseService();
        res.setResponseCode(response.getCode());
        res.setResponseDesc(customMessage);
        res.setData(obj);
        return res;
    }
}
