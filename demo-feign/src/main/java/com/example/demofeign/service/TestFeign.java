    package com.example.demofeign.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


//@FeignClient(name="service-producer",configuration = FeignConfig.class)
public interface TestFeign {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    JSONObject getHi(@RequestParam("name") String name);

}
