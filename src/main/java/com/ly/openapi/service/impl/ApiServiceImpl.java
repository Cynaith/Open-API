package com.ly.openapi.service.impl;

import com.ly.openapi.mapping.ApiMapping;
import com.ly.openapi.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Cynaith
 **/
@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    ApiMapping apiMapping;

    @Override
    public String getMessage(String word) {
        return apiMapping.getMessage(word);
    }
}
