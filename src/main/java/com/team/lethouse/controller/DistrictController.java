package com.team.lethouse.controller;

import com.team.lethouse.entity.District;
import com.team.lethouse.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @创建人 廖明超
 * @创建时间 2020/9/6
 * @描述
 */
@RestController
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("/getDistricts")
    @CrossOrigin
    public List<District> getDistricts(){
        return districtService.selectDistricts();
    }
}
