package com.ivarsexample.calendardemo.controller;

import com.ivarsexample.calendardemo.config.ContentCalendarProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    private final ContentCalendarProperties properties;

    @Value("${cc.welcomeMessage: Default Welcome Message}") //The value is injected from application.properties
    private String welcomeMessage;

    @Value("${cc.about}")
    private String about;

    //Properties will be autowired and the attribute values will be automatically provided from
    //application.properties . We have specified that it should use "cc.<variablename>" there.
    public HomeController(ContentCalendarProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public ContentCalendarProperties home() {
       return properties;
    }
//    public Map<String, String> home() {
//       return Map.of("welcomeMessage", welcomeMessage, "about", about);
//    }
}
