package com.eric.user.service;

import com.eric.user.pojo.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> listUser();

    UserDto findUserById(int id);

    UserDto insertUser(UserDto user);

}
