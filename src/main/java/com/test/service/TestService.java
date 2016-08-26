package com.test.service;


import com.test.entity.TestEntity;
import com.test.util.PageVo;
public interface TestService {
    public PageVo<TestEntity> getAllListByPage(PageVo<TestEntity> pageVo ,int start,int end) ;
	public Integer getCountForAllListByPage(TestEntity testEntity);
}
