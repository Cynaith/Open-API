package com.ly.openapi;

import com.ly.openapi.cache.LRUCache;
import com.ly.openapi.service.ApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.Map;

@SpringBootTest
class OpenApiApplicationTests {

    @Autowired
    ApiService apiService;

    @Test
    void contextLoads() {
        Map<String,String> map = LRUCache.getMap();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry m = (Map.Entry)it.next();
            System.out.println(m.getValue());
        }

        long start = System.currentTimeMillis();
        apiService.getMessage("贵人");
        apiService.getMessage("贵族");
        apiService.getMessage("强盗");
        apiService.getMessage("导师");
        apiService.getMessage("熟人");
        apiService.getMessage("亲友");
        apiService.getMessage("黑人");
        apiService.getMessage("护士");
        apiService.getMessage("厨师");
        apiService.getMessage("矿工");
        apiService.getMessage("囚犯");
        apiService.getMessage("青鱼");
        apiService.getMessage("飞鱼");
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        Iterator it1 = map.entrySet().iterator();
        while (it1.hasNext()){
            Map.Entry m = (Map.Entry)it1.next();
            System.out.println(m.getValue());
        }
        long start1 = System.currentTimeMillis();
        apiService.getMessage("贵人");
        apiService.getMessage("贵族");
        apiService.getMessage("强盗");
        apiService.getMessage("导师");
        apiService.getMessage("熟人");
        apiService.getMessage("亲友");
        apiService.getMessage("黑人");
        apiService.getMessage("护士");
        apiService.getMessage("厨师");
        apiService.getMessage("矿工");
        apiService.getMessage("囚犯");
        apiService.getMessage("青鱼");
        apiService.getMessage("飞鱼");
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);
    }

}
