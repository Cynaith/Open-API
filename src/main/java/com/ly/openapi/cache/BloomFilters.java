package com.ly.openapi.cache;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.ly.openapi.service.ApiService;
import com.ly.openapi.utils.SpringUtil;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author: Cynaith
 **/
public class BloomFilters {
    ApiService apiService = null;

    public BloomFilters() {
        this.apiService = (ApiService) SpringUtil.getBean("apiServiceImpl");
    }

    public static BloomFilter<String> filter = BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8),10000,0.01);
    public void init(){
        System.out.println("BloomFilter init");
        List<String> keys = apiService.getKeys();
        for (String key : keys) {
            filter.put(key);
        }
        System.out.println("BloomFilter inited");
    }
    public static boolean exist(String key){
        return filter.mightContain(key);
    }
}
