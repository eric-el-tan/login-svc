package com.eric.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequestMapping("/login")
public class HelloWorldController {

    @GetMapping("/hello")
    @ApiOperation(value = "return hello message", notes = "<div>respCode:"
            + "<li>9999 = unknown error</li>"
            + "</div>")
    @ApiResponses(value = {
            @ApiResponse(code = 9999, message = "unknown error, or record not found")
    })
    public String getHello(){
        return "Hello World3";
    }
}
