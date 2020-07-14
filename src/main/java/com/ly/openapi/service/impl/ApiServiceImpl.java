package com.ly.openapi.service.impl;

import com.google.common.hash.BloomFilter;
import com.ly.openapi.cache.BloomFilters;
import com.ly.openapi.cache.LRUCache;
import com.ly.openapi.mapping.ApiMapping;
import com.ly.openapi.service.ApiService;
import com.oracle.tools.packager.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author: Cynaith
 **/
@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    ApiMapping apiMapping;

    @Override
    @Transactional
    public String getMessage(String word) {
        String noMsg = "暂无该信息，请重新更换描述词语。";
        String msg = null;
        if (BloomFilters.exist(word)){
            if ((msg = LRUCache.get(word))==null){
                if ((msg = apiMapping.getMessage(word))!=null){
                    LRUCache.put(word,msg);
                    return msg;
                }else {
                    System.out.println("BloomFilter过滤失败");
                    return noMsg;
                }

            }
            else {
                System.out.println("LRU命中");
                return msg;
            }
        }else {
            System.out.println("被过滤");
            return noMsg;
        }
    }

    @Override
    public List<String> getKeys() {
        return apiMapping.getKeys();
    }
}
