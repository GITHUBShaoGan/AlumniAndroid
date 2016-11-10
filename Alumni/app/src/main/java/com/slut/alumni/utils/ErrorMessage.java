package com.slut.alumni.utils;

/**
 * Created by 七月在线科技 on 2016/11/8.
 */

public class ErrorMessage {

    private int errno;

    private String msg;

    public ErrorMessage(int errno, String msg) {
        this.errno = errno;
        this.msg = msg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "errno=" + errno +
                ", msg='" + msg + '\'' +
                '}';
    }
}
