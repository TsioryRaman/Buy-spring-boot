package com.commerce.buy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
public class TestController {

    @GetMapping()
    public String getString()
    {
        return "Coucou lol are s worlss";
    }

    @GetMapping("list/{id}")
    public List<String> getList(@PathVariable String id)
    {
        List<String> data = new ArrayList<String>();
        data.add("salut");
        data.add("ca va? " + id);

        return data;
    }

}
