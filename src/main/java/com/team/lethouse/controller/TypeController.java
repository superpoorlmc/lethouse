package com.team.lethouse.controller;

import com.team.lethouse.entity.Type;
import com.team.lethouse.service.TypeService;
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
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("/getTypes")
    @CrossOrigin
    public List<Type> getTypes(){
        return typeService.selectTypes();
    }
}
