package com.team.lethouse.service.impl;

import com.team.lethouse.entity.District;
import com.team.lethouse.entity.DistrictExample;
import com.team.lethouse.mapper.DistrictMapper;
import com.team.lethouse.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @创建人 廖明超
 * @创建时间 2020/9/6
 * @描述
 */
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired(required = false)
    private DistrictMapper districtMapper;
    @Override
    public List<District> selectDistricts() {
        return districtMapper.selectByExample(new DistrictExample());
    }
}
