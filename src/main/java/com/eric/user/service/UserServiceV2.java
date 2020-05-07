package com.eric.user.service;

import com.eric.user.pojo.dto.UserDtoV2;

import java.util.List;

public interface UserServiceV2 {

    List<UserDtoV2> listUserV2();

    UserDtoV2 findUserByIdV2(int id);


}
