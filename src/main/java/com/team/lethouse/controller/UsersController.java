package com.team.lethouse.controller;

import com.team.lethouse.entity.Users;
import com.team.lethouse.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @创建人 廖明超
 * @创建时间 2020/9/6
 * @描述
 */
@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/addUser")
    @CrossOrigin
    public int addUser(Users users){
        return usersService.insertUser(users);
    }

    @RequestMapping("/login")
    @CrossOrigin
    public int login(String name, String password, HttpSession session){
        Users user = usersService.selectUserContain(name, password);
        if (user!=null){
            session.setAttribute("userInfo",user);
            session.setMaxInactiveInterval(30*60);
            return 1;
        }else {
            return 0;
        }
    }
}
