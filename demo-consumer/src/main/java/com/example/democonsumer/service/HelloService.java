package com.example.democonsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService
{
    @Autowired
    RestTemplate restTemplate;


    public String hiService(String name)
    {
        return restTemplate.getForObject("http://SERVICE-DEMO/hi?name=" + name, String.class);
    }

    /**
     *  断路器 如果服务不通 调用错误处理方法
     * @param name
     * @return
     */
//    @HystrixCommand(fallbackMethod = "errorMethod")
    public String hiServiceToTest(String name){
        ResponseEntity<Object> forEbtity = restTemplate.getForEntity("http://SERVICE-DEMO/hi?name=" + name, Object.class);
        Object forObject = restTemplate.getForObject("http://SERVICE-DEMO/hi?name=" + name, Object.class);
        return "";
    }

    public String errorMethod(String name){
        return "key" + name + ",there is some problem with error page";
    }
}