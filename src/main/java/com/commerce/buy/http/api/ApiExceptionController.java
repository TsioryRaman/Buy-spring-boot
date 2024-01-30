package com.commerce.buy.http.api;

import com.commerce.buy.common.exception.entityException.NoSuchEntityException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exception")
public class ApiExceptionController {

    @GetMapping()
    public String getResponse() throws NoSuchEntityException
    {
        if(false)
        {
            return "Hello";
        }
        throw new NoSuchEntityException("No entity Found");
    }

}
