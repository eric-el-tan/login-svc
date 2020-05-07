package com.eric.user.controller;

import com.eric.user.exception.UserNotFoundException;
import com.eric.user.pojo.dto.UserDto;
import com.eric.user.pojo.dto.UserDtoV2;
import com.eric.user.service.UserService;
import com.eric.user.service.UserServiceV2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Api(tags = "user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequestMapping("/v2/user")
public class UserControllerV2 {

    @Autowired
    UserServiceV2 userServiceV2;

    @GetMapping("/")
    @ApiOperation(value = "list all users", notes = "<div>respCode:"
            + "<li>9999 = unknown error</li>"
            + "</div>")
    @ApiResponses(value = {
            @ApiResponse(code = 9999, message = "unknown error, or record not found")
    })
    public List<UserDtoV2> listUserV2(){
        return userServiceV2.listUserV2();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get a user", notes = "<div>respCode:"
            + "<li>9999 = unknown error</li>"
            + "</div>")
    @ApiResponses(value = {
            @ApiResponse(code = 9999, message = "unknown error, or record not found")
    })
    public UserDtoV2 getUserV2(@PathVariable int id){
        UserDtoV2 user = userServiceV2.findUserByIdV2(id);
        if(user == null){
            throw new UserNotFoundException("id - " + id);
        }
        return user;
    }
}
