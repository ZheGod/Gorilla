package com.gorilla.sdkUI.controller.gorilla;

import com.google.gson.Gson;
import com.gorilla.sdkUI.dto.Result;
import com.gorilla.sdkUI.model.GorillaCaseConfig;
import com.gorilla.sdkUI.model.GorillaDataParmsConfig;
import com.gorilla.sdkUI.service.GorillaService;
import com.gorilla.sdkUI.util.StringUtil;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by deanwang on 2017/5/8.
 */
@RestController
@RequestMapping("/gorilla")
public class GorillaController {
    @Resource
    private GorillaService gorillaService;

    @RequestMapping(value = "/uploadGorillaCase", method = {RequestMethod.POST})
    public Result<String> uploadGorillaCase(@RequestParam(value = "recordTag") String recordTag,
                                            @RequestParam(value = "caseVersion") String caseVersion,
                                            @RequestParam(value = "caseName") String caseName,
                                            @RequestParam(value = "caseRecordValue") String caseRecordValue,
                                            @RequestParam(value = "systemVersion", required = false, defaultValue = "") String systemVersion,
                                            @RequestParam(value = "device", required = false, defaultValue = "") String device)

    {
        Result<String> result = new Result<>();
        try {
            if (StringUtil.isEmpty(recordTag) && StringUtil.isEmpty(caseVersion) && StringUtil.isEmpty(caseName) && StringUtil.isEmpty(caseRecordValue)) {
                result.setFailAndData(null, "必填参数不能为空");
                return result;
            }
            Long caseId = gorillaService.uploadGorillaCase(recordTag, caseVersion, caseName, caseRecordValue, systemVersion, device);
            result.setSuccessAndData(String.valueOf(caseId), "UI用例上传成功");
        } catch (Exception e) {
            result.setFailAndData(String.valueOf(e), "异常信息");
        }
        return result;
    }

    @RequestMapping(value = "/uploadGorillaDataParms", method = {RequestMethod.POST})
    public Result<String> uploadGorillaDataParms(@RequestParam(value = "version") String version,
                                                 @RequestParam(value = "caseId") String caseId,
                                                 @RequestParam(value = "url") String url,
                                                 @RequestParam(value = "requestData") String requestData,
                                                 @RequestParam(value = "responseData") String responseData,
                                                 @RequestParam(value = "systemVersion", required = false, defaultValue = "") String systemVersion,
                                                 @RequestParam(value = "device", required = false, defaultValue = "") String device)

    {
        Result<String> result = new Result<>();
        if (StringUtil.isEmpty(version) && StringUtil.isEmpty(caseId) && StringUtil.isEmpty(url) && StringUtil.isEmpty(requestData) && StringUtil.isEmpty(responseData)) {
            result.setFailAndData(null, "必填参数不能为空");
            return result;
        }
        Long dataParmsId = 0L;
        try {
            dataParmsId = gorillaService.uploadGorillaDataParms(version, caseId, url, requestData, responseData, systemVersion, device);
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.setSuccessAndData(String.valueOf(dataParmsId), "网络数据上传成功");
        return result;
    }

    @RequestMapping(value = "/uploadGorillaResult", method = {RequestMethod.POST})
    public Result<String> uploadGorillaResult(@RequestParam(value = "caseId") String caseId,
                                              @RequestParam(value = "uuid") String uuid,
                                              @RequestParam(value = "status") String status,
                                              @RequestParam(value = "systemVersion", required = false, defaultValue = "") String systemVersion,
                                              @RequestParam(value = "device", required = false, defaultValue = "") String device)

    {
        Result<String> result = new Result<>();
        if (StringUtil.isEmpty(uuid) && StringUtil.isEmpty(caseId) && StringUtil.isEmpty(status)) {
            result.setFailAndData(null, "必填参数不能为空");
            return result;
        }
        Long result_Id = gorillaService.uploadGorillaResult(caseId, uuid, status, systemVersion, device);
        result.setSuccessAndData(String.valueOf(result_Id), "上传用例测试结果成功");
        return result;
    }

    @RequestMapping(value = "/getGorillaCase", method = {RequestMethod.POST})
    public Result<List<GorillaCaseConfig>> getGorillaCase(@RequestParam(value = "caseId") String caseId)

    {
        Result<List<GorillaCaseConfig>> result = new Result<>();
        List<GorillaCaseConfig> gorillaCaseConfig = new ArrayList<>();
        if (StringUtil.isEmpty(caseId)) {
            result.setFailAndData(null, "必填参数caseId不能为空");
            return result;
        }
        gorillaCaseConfig = gorillaService.getGorillaCase(caseId);
        if (gorillaCaseConfig.isEmpty()) {
            result.setFailAndData(gorillaCaseConfig, "数据库中不存在caseId为" + caseId + " 的记录");
            return result;
        }
        result.setSuccessAndData(gorillaCaseConfig, "获取指定UI用例数据成功");
        return result;
    }

    @RequestMapping(value = "/getGorillaDataParms", method = {RequestMethod.POST})
    public Result<List<GorillaDataParmsConfig>> getGorillaDataParms(@RequestParam(value = "caseId") String caseId,
                                                                    @RequestParam(value = "url") String url)

    {
        Result<List<GorillaDataParmsConfig>> result = new Result<>();
        List<GorillaDataParmsConfig> gorillaDataParmsConfig = new ArrayList<>();

        if (StringUtil.isEmpty(caseId) && StringUtil.isEmpty(url)) {
            result.setFailAndData(null, "必填参数不能为空");
            return result;
        }
        gorillaDataParmsConfig = gorillaService.getGorillaDataParms(caseId, url);
        String json = new Gson().toJson(gorillaDataParmsConfig);
        if (gorillaDataParmsConfig.isEmpty()) {
            result.setFailAndData(gorillaDataParmsConfig, "数据库中不存在caseId为 " + caseId + " ,url为 " + url + " 的记录!");
            return result;
        }
        result.setSuccessAndData(gorillaDataParmsConfig, "获取指定用例关联的网路请求成功");
        return result;
    }

    @RequestMapping(value = "/getGorillaCaseByTag", method = {RequestMethod.POST})
    public Result<List<GorillaCaseConfig>> getGorillaCaseByTag(@RequestParam(value = "caseVersion") String caseVersion,
                                                               @RequestParam(value = "recordTag") String recordTag)

    {
        Result<List<GorillaCaseConfig>> result = new Result<>();
        List<GorillaCaseConfig> gorillaCaseConfig = new ArrayList<>();
        if (StringUtil.isEmpty(caseVersion) && StringUtil.isEmpty(recordTag)) {
            result.setFailAndData(gorillaCaseConfig, "必填参数不能为空");
            return result;
        }
        gorillaCaseConfig = gorillaService.getGorillaCaseByTag(caseVersion, recordTag);
        if (gorillaCaseConfig.isEmpty()) {
            result.setFailAndData(gorillaCaseConfig, "数据库中不存在caseVersion为" + caseVersion + "recordTag为" + recordTag + " 的记录");
            return result;
        }
        result.setSuccessAndData(gorillaCaseConfig, "获取一组用例的所有case成功");
        return result;
    }


}
