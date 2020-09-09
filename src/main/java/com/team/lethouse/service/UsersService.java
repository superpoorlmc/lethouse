package com.team.lethouse.service;

import com.team.lethouse.entity.Users;

/**
 * @创建人 廖明超
 * @创建时间 2020/9/6
 * @描述
 */
public interface UsersService {
    //注册用户
    int insertUser(Users users);
    //登录验证用户是否存在
    Users selectUserContain(String name,String password);
}
