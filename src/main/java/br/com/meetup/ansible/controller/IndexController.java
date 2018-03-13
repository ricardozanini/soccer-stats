package br.com.meetup.ansible.controller;

import java.util.Date;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    public IndexController() {

    }

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        model.put("time", new Date());
        return "index";
    }

}
