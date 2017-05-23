package com.gorilla.sdkUI.dto;





import com.gorilla.sdkUI.common.ResultCodeConst;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = -8283564769604549349L;

    private String errorMsg;

    private String msg;

    private T data;

    private int code;

    public Result() {
        super();
    }

    public Result(T data) {
        super();
        this.data = data;
    }

    public Result(String msg) {
        super();
        this.msg = msg;
    }

    public Result(String msg, String errorMsg) {
        super();
        this.msg = msg;
        this.errorMsg = errorMsg;
    }

    public Result<T> setErrorInfo(String errorMsg) {
        setErrorMsg(errorMsg);
        return this;
    }

    public Result<T> setSuccessAndData(T data) {
        setData(data);
        setMsg("success");
        setErrorInfo("success");
        setCode(ResultCodeConst.OK);
        return this;
    }

    public Result<T> setSuccessAndData(T data, String errorMsg) {
        setData(data);
        setMsg("success");
        setErrorInfo(errorMsg);
        setCode(ResultCodeConst.OK);
        return this;
    }

    public Result<T> setSuccessAndData(T data, String errorMsg, int code) {
        setData(data);
        setMsg("success");
        setErrorInfo(errorMsg);
        setCode(code);
        return this;
    }

    public Result<T> setFailAndData(T data) {
        setData(data);
        setMsg("error");
        setErrorInfo("fail");
        setCode(ResultCodeConst.ERROR);
        return this;
    }

    public Result<T> setFailAndData(T data, String errorMsg) {
        setData(data);
        setMsg("error");
        setErrorInfo(errorMsg);
        setCode(ResultCodeConst.ERROR);
        return this;
    }

    public Result<T> setFailAndData(T data, String errorMsg, int code) {
        setData(data);
        setMsg("error");
        setErrorInfo(errorMsg);
        setCode(code);
        return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
