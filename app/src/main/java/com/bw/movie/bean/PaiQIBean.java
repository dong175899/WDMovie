package com.bw.movie.bean;

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/21
 * 描述:WMovie
 * 功能：
 **/
public class PaiQIBean {

    /**
     * result : [{"beginTime":"20:00:00","endTime":"21:48:00","fare":0.01,"hallId":138,"id":592,"screeningHall":"2号激光厅"},{"beginTime":"17:00:00","endTime":"23:55:00","fare":0.01,"hallId":139,"id":665,"screeningHall":"3号厅"},{"beginTime":"22:00:00","endTime":"23:55:00","fare":0.01,"hallId":142,"id":668,"screeningHall":"6号厅"},{"beginTime":"19:00:00","endTime":"20:53:00","fare":0.01,"hallId":138,"id":672,"screeningHall":"2号激光厅"},{"beginTime":"20:00:00","endTime":"21:48:00","fare":0.01,"hallId":138,"id":680,"screeningHall":"2号激光厅"},{"beginTime":"20:00:00","endTime":"21:48:00","fare":0.01,"hallId":142,"id":684,"screeningHall":"6号厅"}]
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
         * beginTime : 20:00:00
         * endTime : 21:48:00
         * fare : 0.01
         * hallId : 138
         * id : 592
         * screeningHall : 2号激光厅
         */

        private String beginTime;
        private String endTime;
        private String fare;
        private String hallId;
        private int id;
        private String screeningHall;

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getFare() {
            return fare;
        }

        public void setFare(String fare) {
            this.fare = fare;
        }

        public String getHallId() {
            return hallId;
        }

        public void setHallId(String hallId) {
            this.hallId = hallId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getScreeningHall() {
            return screeningHall;
        }

        public void setScreeningHall(String screeningHall) {
            this.screeningHall = screeningHall;
        }
    }
}
