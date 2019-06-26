package com.springboot.demo.dao;

import com.springboot.demo.model.ArtworkDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArtworkDao {

    @Select("select * from artwork where id = #{id}")
    ArtworkDO getById(@Param("id") Integer id);

    @Select("select * from artwork where sid = #{sid}")
    ArtworkDO getBySid(@Param("sid") String sid);
}
