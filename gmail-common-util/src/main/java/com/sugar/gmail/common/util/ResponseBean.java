package com.sugar.gmail.common.util;

public class ResponseBean {
    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseBean() {
        this.code = ResponseCode.SUCCESS.code;
    }

    public ResponseBean warn(Object data, String message) {
        this.code = ResponseCode.WARN.code;
        this.data = data;
        this.message = message;
        return this;
    }

    public ResponseBean success(Object data, String message) {
        this.code = ResponseCode.SUCCESS.code;
        this.data = data;
        this.message = message;
        return this;
    }

    public ResponseBean error(Object data, String message) {
        this.code = ResponseCode.ERROR.code;
        this.data = data;
        this.message = message;
        return this;
    }

    enum ResponseCode {
        ERROR(-1), SUCCESS(0), WARN(1);
        private int code;

        ResponseCode(int code) {
            this.code = code;
        }
    }
}
