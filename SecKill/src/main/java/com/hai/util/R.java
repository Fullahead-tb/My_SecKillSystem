package com.hai.util;

/**
 * 为响应信息设置统一规范
 */
public class R<T> {
    private boolean result;
    private String message;

    private T data;

    public R(boolean result,String message){
        this.result = result;
        this.message = message;
    }

    public R(boolean result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
