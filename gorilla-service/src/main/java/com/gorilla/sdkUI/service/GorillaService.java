package com.gorilla.sdkUI.service;


import com.gorilla.sdkUI.model.GorillaCaseConfig;
import com.gorilla.sdkUI.model.GorillaDataParmsConfig;

import java.io.IOException;
import java.util.List;

/**
 * Created by deanwang on 2017/5/8.
 */
public interface GorillaService {

    Long uploadGorillaCase(String recordTag, String caseVersion, String caseName, String caseRecordValue, String systemVersion, String device);

    Long uploadGorillaDataParms(String version, String caseId, String url, String requestData, String responseData, String device, String systemVersion) throws IOException;

    List<GorillaCaseConfig> getGorillaCase(String caseId);

    List<GorillaDataParmsConfig> getGorillaDataParms(String caseId, String url);

    Long uploadGorillaResult(String caseId, String uuid, String status, String device, String systemVersion);

    List<GorillaCaseConfig> getGorillaCaseByTag(String caseVersion, String recordTag);

    boolean deleteGorillaCase(String caseId);
}
