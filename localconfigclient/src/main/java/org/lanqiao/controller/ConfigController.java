package org.lanqiao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

   @Value("${server.port}")
    private String port;

   @Value("${fool}")
   private String fool;

   @RequestMapping("/index")
   public String index(){
       return this.port+","+this.fool;
   }
}
