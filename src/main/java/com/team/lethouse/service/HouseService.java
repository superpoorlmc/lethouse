package com.team.lethouse.service;

import com.github.pagehelper.PageInfo;
import com.team.lethouse.entity.House;
import com.team.lethouse.util.Params;

/**
 * @创建人 廖明超
 * @创建时间 2020/9/6
 * @描述
 */
public interface HouseService {
    //添加房屋信息
    int insertHouse(House house);
    //分页查询该用户所有房屋信息
    PageInfo<House> selectHouses(Integer id,Integer page,Integer pageSize);
    //删单条房屋信息
    int deleteHouseById(String id);
    //带条件分页查询所有房屋信息
    PageInfo<House> selectHousesByParams(Params params);
}
