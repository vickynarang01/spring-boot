package com.test.micro.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;

@Api(tags = "Microservices", description = "Micro1 User Details")
@RestController
@RequestMapping("/v1")
public class Micro1Controller {


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Normal response returns array of User Details. Empty array will be returned in case nothing was found.")
    })
    @ApiOperation(value = "The operation returns User Details")
    @RequestMapping(value= "/user",method = RequestMethod.GET,produces = MediaType.TEXT_PLAIN)
    public String getHello()
    {
        return "Hello SpringBoot";
    }
}
