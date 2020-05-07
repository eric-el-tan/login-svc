package com.eric.user.repository;

import com.eric.user.pojo.po.UserPo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private static List<UserPo> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new UserPo(1, "Adam", LocalDate.now()));
        users.add(new UserPo(2, "Betty", LocalDate.of(2000, 1, 1)));
        users.add(new UserPo(3, "Cathy", LocalDate.of(1950, 12, 25)));
    }

    public List<UserPo> findAll(){
        return users;
    }

    public UserPo saveUser(UserPo user){
        if (user.getId()==null || user.getId() == 0)
            user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public UserPo findOne(int id){
        for (UserPo user:users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
