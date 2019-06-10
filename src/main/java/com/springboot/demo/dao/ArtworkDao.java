package com.springboot.demo.dao;

import com.springboot.demo.model.ArtworkDO;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface ArtworkDao {

    ArtworkDO getById(@Param("id") Integer id);
}
