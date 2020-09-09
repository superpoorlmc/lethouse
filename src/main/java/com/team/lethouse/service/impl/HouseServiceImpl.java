package com.team.lethouse.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.lethouse.entity.House;
import com.team.lethouse.mapper.HouseMapper;
import com.team.lethouse.service.HouseService;
import com.team.lethouse.util.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @创建人 廖明超
 * @创建时间 2020/9/6
 * @描述
 */
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired(required = false)
    private HouseMapper houseMapper;

    @Override
    public int insertHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> selectHouses(Integer id, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<House> houses = houseMapper.selectHousesByUserId(id);
        return new PageInfo<>(houses);
    }

    @Override
    public int deleteHouseById(String id) {
        return houseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<House> selectHousesByParams(Params params) {
        PageHelper.startPage(params.getPage(), params.getPageSize());
        if (params.getTitle() != null)
            params.setTitle("%" + params.getTitle() + "%");                      //模糊查询标题
        List<House> houses = houseMapper.selectHouseByParams(params);
        return new PageInfo<>(houses);
    }
}
