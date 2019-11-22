package com.bw.movie.bean;

/**
 *@describe(描述)：RegBean
 *@data（日期）: 2019/11/12
 *@time（时间）: 16:27
 *@author（作者）:dongyanjun
 **/
public class RegBean {

    /**
     * message : 注册成功
     * status : 0000
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
