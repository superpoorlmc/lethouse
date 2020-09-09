package com.team.lethouse;

import com.github.pagehelper.PageInfo;
import com.team.lethouse.controller.HouseController;
import com.team.lethouse.controller.UsersController;
import com.team.lethouse.entity.House;
import com.team.lethouse.entity.Street;
import com.team.lethouse.entity.Users;
import com.team.lethouse.mapper.HouseMapper;
import com.team.lethouse.service.HouseService;
import com.team.lethouse.service.StreetService;
import com.team.lethouse.service.UsersService;
import com.team.lethouse.util.Params;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LethouseApplicationTests {
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    HouseService houseService;
    @Test
    public void contexkLtLoads() {
        PageInfo<House> housePageInfo = houseService.selectHousesByParams(new Params());
        System.out.println("总页数:"+housePageInfo.getPages());
    }

}
