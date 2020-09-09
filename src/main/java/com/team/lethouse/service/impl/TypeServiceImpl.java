package com.team.lethouse.service.impl;

import com.team.lethouse.entity.Type;
import com.team.lethouse.entity.TypeExample;
import com.team.lethouse.mapper.TypeMapper;
import com.team.lethouse.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @创建人 廖明超
 * @创建时间 2020/9/6
 * @描述
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired(required = false)
    private TypeMapper typeMapper;
    @Override
    public List<Type> selectTypes() {
        return typeMapper.selectByExample(new TypeExample());
    }
}
