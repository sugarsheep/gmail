package com.sugar.gmail.user.common;

public class ResponseBean {
    private int code;
    private String message;
    private Object data;

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
