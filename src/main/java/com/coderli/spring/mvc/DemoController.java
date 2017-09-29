package com.coderli.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @RequestMapping("/justdemo")
    @ResponseBody
    public void demo() {
        System.out.println("demo controller");
    }

}
