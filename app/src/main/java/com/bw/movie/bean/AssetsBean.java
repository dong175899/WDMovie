package com.bw.movie.bean;

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/13
 * 描述:WMovie
 * 功能：
 **/
public class AssetsBean {

    /**
     * result : [{"regionId":1,"regionName":"海淀区"},{"regionId":2,"regionName":"朝阳区"},{"regionId":3,"regionName":"东城区"},{"regionId":4,"regionName":"西城区"},{"regionId":5,"regionName":"石景山区"},{"regionId":6,"regionName":"丰台区"},{"regionId":7,"regionName":"昌平区"},{"regionId":8,"regionName":"房山区"},{"regionId":9,"regionName":"大兴区"},{"regionId":10,"regionName":"通州区"},{"regionId":11,"regionName":"顺义区"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * regionId : 1
         * regionName : 海淀区
         */

        private String regionId;
        private String regionName;

        public String getRegionId() {
            return regionId;
        }

        public void setRegionId(String regionId) {
            this.regionId = regionId;
        }

        public String getRegionName() {
            return regionName;
        }

        public void setRegionName(String regionName) {
            this.regionName = regionName;
        }
    }
}
