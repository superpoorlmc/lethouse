package com.team.lethouse.service.impl;

import com.team.lethouse.entity.Users;
import com.team.lethouse.entity.UsersExample;
import com.team.lethouse.mapper.UsersMapper;
import com.team.lethouse.service.UsersService;
import com.team.lethouse.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @创建人 廖明超
 * @创建时间 2020/9/6
 * @描述
 */
@Service
public class UsersServiceImpl implements UsersService{
    @Autowired(required = false)
    private UsersMapper usersMapper;
    @Override
    public int insertUser(Users users) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        if (users.getName()!=null)
            criteria.andNameEqualTo(users.getName());
        List<Users> list = usersMapper.selectByExample(usersExample);
        if (list!=null&&list.size()>0) {
            return 0;//表示注册用户名重复
        } else {
            users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
            return usersMapper.insertSelective(users);
        }
    }

    @Override
    public Users selectUserContain(String name, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        if (name!=null)
            criteria.andNameEqualTo(name);
        if (password!=null)
            criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> users = usersMapper.selectByExample(usersExample);
        if (users!=null&&users.size()==1){
            return users.get(0);
        }else {
            return null;
        }
    }
}
