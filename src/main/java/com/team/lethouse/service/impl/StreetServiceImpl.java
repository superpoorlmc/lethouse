package com.team.lethouse.service.impl;

import com.team.lethouse.entity.Street;
import com.team.lethouse.entity.StreetExample;
import com.team.lethouse.mapper.StreetMapper;
import com.team.lethouse.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @创建人 廖明超
 * @创建时间 2020/9/6
 * @描述
 */
@Service
public class StreetServiceImpl implements StreetService {
    @Autowired(required = false)
    private StreetMapper streetMapper;
    @Override
    public List<Street> selectStreetsByDistrictId(Integer id) {
        List<Street> streets =null;
                StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        if (id!=null) {
            criteria.andDistrictIdEqualTo(id);
            streets = streetMapper.selectByExample(streetExample);
        }
        return streets;
    }
}
