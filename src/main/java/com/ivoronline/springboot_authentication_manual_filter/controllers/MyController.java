package com.ivoronline.springboot_authentication_manual_filter.controllers;

import com.ivoronline.springboot_authentication_manual_filter.config.MyAuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @Autowired MyAuthenticationManager myAuthenticationManager;

  @ResponseBody
  @RequestMapping("/Hello")
  public String hello() {
    return "Hello from Controller";
  }

}
