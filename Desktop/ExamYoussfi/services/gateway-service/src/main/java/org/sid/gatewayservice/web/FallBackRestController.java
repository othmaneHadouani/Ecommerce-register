package org.sid.gatewayservice.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
class FallBackRestController{

    @GetMapping("/restCountriesFallback")
    public Map<String,String> restCountriesFallback(){
        Map<String,String> map=new HashMap<>();
        map.put("message","Default Rest Countries Fallback service");
        map.put("countries","Algeria, Morocco");
        return map;
    }

    @GetMapping("/muslimsalatFallback")
    public Map<String,String> muslimsalatback(){
        Map<String,String> map=new HashMap<>();
        map.put("message","Default Muslim Fallback service");
        map.put("Fajr","07:00");
        map.put("DOHR","14:00");
        return map;
    }
}

