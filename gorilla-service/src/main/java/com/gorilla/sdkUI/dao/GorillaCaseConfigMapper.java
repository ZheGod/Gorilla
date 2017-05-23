package com.gorilla.sdkUI.dao;

import com.gorilla.sdkUI.model.GorillaCaseConfig;
import com.gorilla.sdkUI.model.GorillaCaseConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GorillaCaseConfigMapper {
    long countByExample(GorillaCaseConfigExample example);

    int deleteByExample(GorillaCaseConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GorillaCaseConfig record);

    int insertSelective(GorillaCaseConfig record);

    List<GorillaCaseConfig> selectByExample(GorillaCaseConfigExample example);

    GorillaCaseConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GorillaCaseConfig record, @Param("example") GorillaCaseConfigExample example);

    int updateByExample(@Param("record") GorillaCaseConfig record, @Param("example") GorillaCaseConfigExample example);

    int updateByPrimaryKeySelective(GorillaCaseConfig record);

    int updateByPrimaryKey(GorillaCaseConfig record);

}