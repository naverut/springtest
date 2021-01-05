package com.hellow;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Data
    private static class DemoRequest {
        private Integer id;
        private String name;
    }


    @Autowired
    private MessageSource messageSource;
        @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public void create(@RequestBody DemoRequest request) {
        System.out.println(request);
    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public DemoRequest index(@RequestParam(value = "name", defaultValue = "World") String name) {
        DemoRequest demo = new DemoRequest();
        demo.id = 1;
        demo.name = name;
        return demo;
    }
}
