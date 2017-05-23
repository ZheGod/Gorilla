package com.gorilla.sdkUI.dao;

import com.gorilla.sdkUI.model.GorillaDataParmsConfig;
import com.gorilla.sdkUI.model.GorillaDataParmsConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GorillaDataParmsConfigMapper {
    long countByExample(GorillaDataParmsConfigExample example);

    int deleteByExample(GorillaDataParmsConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GorillaDataParmsConfig record);

    int insertSelective(GorillaDataParmsConfig record);

    List<GorillaDataParmsConfig> selectByExample(GorillaDataParmsConfigExample example);

    GorillaDataParmsConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GorillaDataParmsConfig record, @Param("example") GorillaDataParmsConfigExample example);

    int updateByExample(@Param("record") GorillaDataParmsConfig record, @Param("example") GorillaDataParmsConfigExample example);

    int updateByPrimaryKeySelective(GorillaDataParmsConfig record);

    int updateByPrimaryKey(GorillaDataParmsConfig record);
}