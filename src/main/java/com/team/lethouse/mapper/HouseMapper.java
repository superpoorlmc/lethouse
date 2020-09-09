package com.team.lethouse.mapper;

import com.team.lethouse.entity.House;
import com.team.lethouse.entity.HouseExample;
import com.team.lethouse.util.Params;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //查询显示该用户的所有房屋信息
    List<House> selectHousesByUserId(Integer userId);

    //带条件查询所有房屋信息
    List<House> selectHouseByParams(Params params);
}