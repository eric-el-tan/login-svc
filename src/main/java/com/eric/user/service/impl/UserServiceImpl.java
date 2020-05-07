package com.eric.user.service.impl;

import com.eric.user.pojo.dto.UserDto;
import com.eric.user.pojo.po.UserPo;
import com.eric.user.repository.UserRepository;
import com.eric.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> listUser() {
        List<UserDto> userDtos = new ArrayList<>();
        List<UserPo> users = userRepository.findAll();
        for (UserPo userPo:users) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userPo, userDto);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public UserDto findUserById(int id) {
        UserPo userPo = userRepository.findOne(id);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userPo, userDto);
        return userDto;
    }

    @Override
    public UserDto insertUser(UserDto userDto) {
        UserPo notSavedUserPo = new UserPo();
        BeanUtils.copyProperties(userDto, notSavedUserPo);
        UserPo savedUserPo = userRepository.saveUser(notSavedUserPo);
        BeanUtils.copyProperties(savedUserPo, userDto);
        return userDto;
    }
}
