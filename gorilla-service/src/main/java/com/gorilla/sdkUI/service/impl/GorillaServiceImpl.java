package com.gorilla.sdkUI.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gorilla.sdkUI.dao.GorillaCaseConfigMapper;
import com.gorilla.sdkUI.dao.GorillaDataParmsConfigMapper;
import com.gorilla.sdkUI.dao.GorillaResultConfigMapper;
import com.gorilla.sdkUI.model.*;
import com.gorilla.sdkUI.service.GorillaService;
import com.gorilla.sdkUI.util.StringUtil;
import com.gorilla.sdkUI.util.safeBase64;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by deanwang on 2017/5/8.
 */
@Service
public class GorillaServiceImpl implements GorillaService {

    @Resource
    private GorillaCaseConfigMapper gorillaCaseConfigMapper;

    @Resource
    private GorillaDataParmsConfigMapper gorillaDataParmsConfigMapper;

    @Resource
    private GorillaResultConfigMapper gorillaResultConfigMapper;

    /**
     * UI用例上传接口
     *
     * @param recordTag       必传
     * @param caseVersion     必传
     * @param caseName        必传
     * @param caseRecordValue 必传
     * @param systemVersion
     * @param device
     * @return caseId
     */
    @Override
    public Long uploadGorillaCase(String recordTag, String caseVersion, String caseName, String caseRecordValue, String systemVersion, String device) {
        if (StringUtil.isEmpty(recordTag) && StringUtil.isEmpty(caseVersion) && StringUtil.isEmpty(caseRecordValue) && StringUtil.isEmpty(caseName)) {
//            logger.error("必传参数为空！");
            return -1L;
        }

        GorillaCaseConfig gorillaCaseConfig = new GorillaCaseConfig();
        gorillaCaseConfig.setCaseName(caseName);
        gorillaCaseConfig.setCaseVersion(caseVersion);
        gorillaCaseConfig.setRecordTag(recordTag);
        gorillaCaseConfig.setCaseRecordValue(caseRecordValue);
        gorillaCaseConfig.setDevice(device);
        gorillaCaseConfig.setSystemVersion(systemVersion);
        gorillaCaseConfig.setCreateTime(new Date());
        gorillaCaseConfigMapper.insert(gorillaCaseConfig);

        Long caseId = gorillaCaseConfig.getId();
        if (caseId <= 0) {
//            logger.error("数据库插入记录失败！");
            return -1L;
        }
        return caseId;
    }

    /**
     * 网络数据上传接口
     *
     * @param version       必传
     * @param caseId        必传
     * @param url           必传
     * @param requestData   必传
     * @param responseData  必传
     * @param device        必传
     * @param systemVersion 必传
     * @return dataParms_Id
     */
    @Override
    public Long uploadGorillaDataParms(String version, String caseId, String url, String requestData, String responseData, String device, String systemVersion) throws IOException {
        if (StringUtil.isEmpty(version) && StringUtil.isEmpty(caseId) && StringUtil.isEmpty(url) && StringUtil.isEmpty(requestData)) {
//            logger.error("必传参数为空！");
            return -1L;
        }
        String responseValue;

        if (StringUtil.isJSONValid(responseData)) {
            JSONObject jsonObj = JSON.parseObject(responseData);
            if (StringUtil.isNotEmpty(jsonObj.getString("msg"))) {
                String msg = jsonObj.getString("msg");
                if (safeBase64.safeUrlBase64Decode(msg).length == 0) {
                    responseValue = requestData;
                }else{
                    responseValue = safeBase64.safeUrlBase64Decode(msg).toString();
                }
            } else {
                responseValue = requestData;
            }

        } else {
            responseValue = requestData;
        }

        GorillaDataParmsConfig gorillaDataParmsConfig = new GorillaDataParmsConfig();
        gorillaDataParmsConfig.setVersion(version);
        gorillaDataParmsConfig.setCaseId(Long.valueOf(caseId));
        gorillaDataParmsConfig.setUrl(url);
        gorillaDataParmsConfig.setRequestData(requestData);
        gorillaDataParmsConfig.setResponseData(responseData);
        gorillaDataParmsConfig.setResponseValue(responseValue);
        gorillaDataParmsConfig.setDevice(device);
        gorillaDataParmsConfig.setSystemVersion(systemVersion);
        gorillaDataParmsConfig.setCreateTime(new Date());
        gorillaDataParmsConfigMapper.insert(gorillaDataParmsConfig);
        Long dataParmsId = gorillaDataParmsConfig.getId();
        if (dataParmsId <= 0) {
//            logger.error("数据库插入记录失败！");
            return -1L;
        }
        return dataParmsId;
    }

    /**
     * 获取指定UI用例数据
     *
     * @param caseId
     * @return
     */
    @Override
    public List<GorillaCaseConfig> getGorillaCase(String caseId) {
        if (StringUtil.isEmpty(caseId)) {
//            logger.error("getGateOrder缺少参数");
            return Collections.emptyList();
        }

        GorillaCaseConfigExample example = new GorillaCaseConfigExample();
        GorillaCaseConfigExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(Long.valueOf(caseId));
        return gorillaCaseConfigMapper.selectByExample(example);
    }

    /**
     * 获取指定用例关联的网路请求
     *
     * @param caseId
     * @param url
     * @return
     */
    @Override
    public List<GorillaDataParmsConfig> getGorillaDataParms(String caseId, String url) {
        if (StringUtil.isEmpty(caseId) || StringUtil.isEmpty(url)) {
//            logger.error("getGateOrder缺少参数");
            return Collections.emptyList();
        }
        GorillaDataParmsConfigExample example = new GorillaDataParmsConfigExample();
        GorillaDataParmsConfigExample.Criteria criteria = example.createCriteria();
        criteria.andUrlEqualTo(url).andCaseIdEqualTo(Long.valueOf(caseId));
        return gorillaDataParmsConfigMapper.selectByExample(example);
    }

    /**
     * 上传用例测试结果接口
     *
     * @param caseId
     * @param uuid
     * @param status
     * @param device
     * @param systemVersion
     * @return
     */
    @Override
    public Long uploadGorillaResult(String caseId, String uuid, String status, String device, String systemVersion) {
        if (StringUtil.isEmpty(caseId) && StringUtil.isEmpty(uuid) && StringUtil.isEmpty(status)) {
//            logger.error("必传参数为空！");
            return -1L;
        }
        GorillaResultConfig gorillaResultConfig = new GorillaResultConfig();
        gorillaResultConfig.setCaseId(Long.valueOf(caseId));
        gorillaResultConfig.setUuid(Long.valueOf(uuid));
        gorillaResultConfig.setStatus(status);
        gorillaResultConfig.setCreateTime(new Date());
        gorillaResultConfig.setDevice(device);
        gorillaResultConfig.setSystemVersion(systemVersion);
        gorillaResultConfigMapper.insert(gorillaResultConfig);
        Long resultId = gorillaResultConfig.getId();
        if (resultId <= 0) {
//            logger.error("数据库插入记录失败！");
            return -1L;
        }
        return resultId;

    }

    /**
     * 获取一组用例的所有case
     *
     * @param caseVersion
     * @param recordTag
     * @return
     */
    @Override
    public List<GorillaCaseConfig> getGorillaCaseByTag(String caseVersion, String recordTag) {
        if (StringUtil.isEmpty(caseVersion) && StringUtil.isEmpty(recordTag)) {
//            logger.error("getGateOrder缺少参数");
            return Collections.emptyList();
        }

        GorillaCaseConfigExample example = new GorillaCaseConfigExample();
        GorillaCaseConfigExample.Criteria criteria = example.createCriteria();
        criteria.andCaseVersionEqualTo(caseVersion).andRecordTagEqualTo(recordTag);
        example.setOrderByClause("ID ASC");
        return gorillaCaseConfigMapper.selectByExample(example);
    }


    /**
     * 获取一组用例的所有case
     *
     * @param caseId
     * @return
     */
    @Override
    public boolean deleteGorillaCase(String caseId) {
        if (StringUtil.isEmpty(caseId)) {
//            logger.error("getGateOrder缺少参数");
            return false;
        }
        GorillaCaseConfigExample example = new GorillaCaseConfigExample();
        GorillaCaseConfigExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(Long.valueOf(caseId));
        return gorillaCaseConfigMapper.deleteByExample(example) > 0;
    }


}
