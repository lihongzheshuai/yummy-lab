package com.coderli.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class DemoController {

    @RequestMapping("/justdemo")
    @ResponseBody
    public void demo(@RequestParam Map<String, String> wumingMap) {
        System.out.println(wumingMap);
        System.out.println("demo controller");
    }

}
