package com.murugoapp.murugo_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebGateway {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
