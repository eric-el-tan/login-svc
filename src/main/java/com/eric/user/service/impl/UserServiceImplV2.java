package com.eric.user.service.impl;

import com.eric.user.calculation.UserCalculation;
import com.eric.user.pojo.dto.UserDto;
import com.eric.user.pojo.dto.UserDtoV2;
import com.eric.user.pojo.po.UserPo;
import com.eric.user.repository.UserRepository;
import com.eric.user.service.UserService;
import com.eric.user.service.UserServiceV2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplV2 implements UserServiceV2 {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDtoV2> listUserV2() {
        List<UserDtoV2> userDtos = new ArrayList<>();
        List<UserPo> users = userRepository.findAll();
        for (UserPo userPo:users) {
            UserDtoV2 userDto = new UserDtoV2();
            BeanUtils.copyProperties(userPo, userDto);
            userDto.setAge(UserCalculation.calculateAge(userDto.getDob()));
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public UserDtoV2 findUserByIdV2(int id) {
        UserPo userPo = userRepository.findOne(id);
        UserDtoV2 userDto = new UserDtoV2();
        BeanUtils.copyProperties(userPo, userDto);
        userDto.setAge(UserCalculation.calculateAge(userDto.getDob()));
        return userDto;
    }
}
