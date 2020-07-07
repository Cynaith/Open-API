package com.ly.openapi.mapping;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author: Cynaith
 **/
@Repository
@Mapper
public interface ApiMapping {

    @Select("select message from zb_dream where title = #{title}")
    public String getMessage(String title);
}
