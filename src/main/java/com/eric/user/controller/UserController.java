package com.eric.user.controller;

import com.eric.user.exception.UserNotFoundException;
import com.eric.user.pojo.dto.UserDto;
import com.eric.user.service.UserService;
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
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    @ApiOperation(value = "list all users", notes = "<div>respCode:"
            + "<li>9999 = unknown error</li>"
            + "</div>")
    @ApiResponses(value = {
            @ApiResponse(code = 9999, message = "unknown error, or record not found")
    })
    public List<UserDto> listUser(){
        return userService.listUser();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get a user", notes = "<div>respCode:"
            + "<li>9999 = unknown error</li>"
            + "</div>")
    @ApiResponses(value = {
            @ApiResponse(code = 9999, message = "unknown error, or record not found")
    })
    public UserDto getUser(@PathVariable int id){
        UserDto user = userService.findUserById(id);
        if(user == null){
            throw new UserNotFoundException("id - " + id);
        }
        return user;
    }

    @PostMapping("/")
    @ApiOperation(value = "insert a user", notes = "<div>respCode:"
            + "<li>9999 = unknown error</li>"
            + "</div>")
    @ApiResponses(value = {
            @ApiResponse(code = 9999, message = "unknown error, or record not found")
    })
    public ResponseEntity<Object> insertUser(@RequestBody UserDto user){
        UserDto savedUser = userService.insertUser(user);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
