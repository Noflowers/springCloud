package com.example.democonsumer.service;

import com.example.democonsumer.util.ResultCode;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@FeignClient("SERVICE-PRODUCER")
public class producerService {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String reduceStock(@RequestParam("name") String name);
}

@Service
public class HelloService
{
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    producerService producerService;

    public String hiService(String name)
    {
        producerService.reduceStock(name);
        return restTemplate.getForObject("http://SERVICE-PRODUCER/hi?name=" + name, String.class);
    }

    /**
     *  断路器 如果服务不通 调用错误处理方法
     * @param name
     * @return
     */
//    @HystrixCommand(fallbackMethod = "errorMethod")
    public Object hiServiceToTest(String name){
        ResponseEntity<Object> forEbtity = restTemplate.getForEntity("http://SERVICE-PRODUCER/hi?name=" + name, Object.class);
        Object forObject = restTemplate.getForObject("http://SERVICE-PRODUCER/hi?name=" + name, Object.class);
        return forObject;
    }

    public String errorMethod(String name){
        return "key" + name + ",there is some problem with error page";
    }
}