package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.entity.TestEntity;
public interface TestMapper {
	public List<TestEntity> getAllListByPage(@Param("start")int start,@Param("start")int end);
	public Integer getCountForAllListByPage(TestEntity testEntity);
}
