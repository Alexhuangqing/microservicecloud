package com.zjx.springcloud.dao;

import com.zjx.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Alex
 * @Desc <p></p>
 * @Date 2018/8/26 15:00
 */
@Mapper
public interface DeptDao {
    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
