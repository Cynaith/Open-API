package com.ly.openapi.controller;

import com.ly.openapi.model.vo.ResponseWrapper;
import com.ly.openapi.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Cynaith
 **/

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    ApiService apiService;

    @RequestMapping("/zgjm")
    public ResponseWrapper zgjm(@RequestParam("word") String word){
        String msg = apiService.getMessage(word);
        return ResponseWrapper.success(msg);
    }
}
