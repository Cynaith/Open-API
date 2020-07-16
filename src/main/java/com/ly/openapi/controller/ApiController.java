package com.ly.openapi.controller;

import com.ly.openapi.model.vo.ResponseWrapper;
import com.ly.openapi.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Cynaith
 **/

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    @Autowired
    ApiService apiService;

    @RequestMapping("/zgjm")
    public ResponseWrapper zgjm(@RequestParam("word") String word){

        String msg = apiService.getMessage(word);
        atomicInteger.getAndAdd(1);
        System.out.println(atomicInteger.get());
        return ResponseWrapper.success(msg);
    }

}
