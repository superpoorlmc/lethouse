package com.team.lethouse.controller;

import com.team.lethouse.entity.Street;
import com.team.lethouse.service.StreetService;
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
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("/getStreets")
    @CrossOrigin
    public List<Street> getStreets(Integer id){
        return streetService.selectStreetsByDistrictId(id);
    }
}
