package com.team.lethouse.service;

import com.team.lethouse.entity.Street;

import java.util.List;

/**
 * @创建人 廖明超
 * @创建时间 2020/9/6
 * @描述
 */
public interface StreetService {
    //通过区域id查询相应街道
    List<Street> selectStreetsByDistrictId(Integer id);
}
