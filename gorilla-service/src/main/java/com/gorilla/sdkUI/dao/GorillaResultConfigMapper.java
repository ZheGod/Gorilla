package com.gorilla.sdkUI.dao;


import com.gorilla.sdkUI.model.GorillaResultConfig;
import com.gorilla.sdkUI.model.GorillaResultConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GorillaResultConfigMapper {
    long countByExample(GorillaResultConfigExample example);

    int deleteByExample(GorillaResultConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GorillaResultConfig record);

    int insertSelective(GorillaResultConfig record);

    List<GorillaResultConfig> selectByExample(GorillaResultConfigExample example);

    GorillaResultConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GorillaResultConfig record, @Param("example") GorillaResultConfigExample example);

    int updateByExample(@Param("record") GorillaResultConfig record, @Param("example") GorillaResultConfigExample example);

    int updateByPrimaryKeySelective(GorillaResultConfig record);

    int updateByPrimaryKey(GorillaResultConfig record);
}