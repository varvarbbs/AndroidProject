package com.kun.demo;

import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.Rest;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

//这里最好用字符串返回, 再用GSON处理, 否则要求数据与类100%匹配, 处理量多
@Rest(converters = {StringHttpMessageConverter.class })
public interface DemoRestClient {

    @Get("http://jsonplaceholder.typicode.com/comments")
    String getData();
}
