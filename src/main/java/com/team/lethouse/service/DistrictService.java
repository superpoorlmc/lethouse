package com.team.lethouse.service;

import com.team.lethouse.entity.District;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @创建人 廖明超
 * @创建时间 2020/9/6
 * @描述
 */
public interface DistrictService {
    List<District> selectDistricts();
}
