package com.bw.movie.bean;

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/13
 * 描述:WMovie
 * 功能：
 **/
public class MovieBean {

    /**
     * result : [{"id":1,"name":"青春光线电影院"},{"id":2,"name":"大观楼电影院"},{"id":3,"name":"首都电影院"},{"id":4,"name":"魔影国际影城"},{"id":6,"name":"北京CBD万达广场店"},{"id":8,"name":"北京博纳影城朝阳门旗舰店"},{"id":10,"name":"华谊兄弟影院"},{"id":12,"name":"美嘉欢乐影城中关村店"},{"id":14,"name":"中影国际影城北京小西天店"}]
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
         * id : 1
         * name : 青春光线电影院
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
