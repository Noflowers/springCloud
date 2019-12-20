package com.example.demoproducer;

import com.example.demoproducer.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
//@EnableEurekaClient
@SpringBootApplication
public class DemoproducerApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoproducerApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public Object home(@RequestParam String name)
    {
        Map<String,Object> map = new HashMap<String,Object>();
        User user = new User(1,"mingzi");
        String s = "hi " + name + ",i am from port:" + port;
        map.put("user",user);
        map.put("s",s);
        return map;
    }

}
