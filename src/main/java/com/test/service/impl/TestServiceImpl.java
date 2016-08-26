package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.TestEntity;
import com.test.mapper.TestMapper;
import com.test.service.TestService;
import com.test.util.PageVo;
@Service("testService")
public class TestServiceImpl implements TestService {
@Autowired 
private TestMapper testMapper;
    @Override
    public PageVo<TestEntity> getAllListByPage(PageVo<TestEntity> pageVo, int start, int end) {
        List<TestEntity> list =   testMapper.getAllListByPage(start, end);
        pageVo.setVoList(list);
        return pageVo;
    }

    @Override
    public Integer getCountForAllListByPage(TestEntity testEntity) {
        return   testMapper.getCountForAllListByPage(testEntity);
         
    }

}
