package com.gorilla.sdkUI.common;

import java.io.Serializable;

/**
 * Created by zhe.wang on 5/09/17.
 * Prj gorilla
 */
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = -58927297L;

    private boolean success;

    private String errorMsg;

    public T result;

    public CommonResult() {

    }

    public CommonResult(boolean success, T result) {
        this.success = success;
        this.result = result;
    }

    public CommonResult(boolean success, String errorMsg, T result) {
        this.success = success;
        this.errorMsg = errorMsg;
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "success=" + success +
                ", errorMsg='" + errorMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
