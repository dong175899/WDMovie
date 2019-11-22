package com.bw.movie.bean;

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/12
 * 描述:WMovie
 * 功能：
 **/
public class ZhTopBean {


    /**
     * result : [{"director":"\r\n刘伟强","horizontalImage":"http://172.17.8.100/images/movie/stills/zgjz/zgjz1_h.jpg","imageUrl":"http://172.17.8.100/images/movie/stills/zgjz/zgjz1.jpg","movieId":24,"name":"中国机长","score":9.4,"starring":"张涵予,欧豪,袁泉,张天爱,李沁"},{"director":"曾国祥","horizontalImage":"http://172.17.8.100/images/movie/stills/sndn/sndn1_h.jpg","imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieId":22,"name":"少年的你","score":9.5,"starring":"周冬雨,易烊千玺,张耀,周也,尹昉"},{"director":"克里斯托弗·麦奎里","horizontalImage":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1_h.jpg","imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","movieId":16,"name":"碟中谍6：全面瓦解","score":8.9,"starring":"汤姆·克鲁斯,亨利·卡维尔,丽贝卡·弗格森,西蒙·佩吉"},{"director":"陈凯歌","horizontalImage":"http://172.17.8.100/images/movie/stills/whwdzg/whwdzg1_h.jpg","imageUrl":"http://172.17.8.100/images/movie/stills/whwdzg/whwdzg1.jpg","movieId":23,"name":"我和我的祖国","score":9.7,"starring":"黄渤,张译,杜江,葛优,刘昊然,吴京"},{"director":"钱嘉乐","horizontalImage":"http://172.17.8.100/images/movie/stills/hjxd/hjxd1_h.jpg","imageUrl":"http://172.17.8.100/images/movie/stills/hjxd/hjxd1.jpg","movieId":18,"name":"黄金兄弟","score":9.3,"starring":"郑伊健,陈小春,谢天华,林晓峰"}]
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
         * director :
         刘伟强
         * horizontalImage : http://172.17.8.100/images/movie/stills/zgjz/zgjz1_h.jpg
         * imageUrl : http://172.17.8.100/images/movie/stills/zgjz/zgjz1.jpg
         * movieId : 24
         * name : 中国机长
         * score : 9.4
         * starring : 张涵予,欧豪,袁泉,张天爱,李沁
         */

        private String director;
        private String horizontalImage;
        private String imageUrl;
        private String movieId;
        private String name;
        private String score;
        private String starring;

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getHorizontalImage() {
            return horizontalImage;
        }

        public void setHorizontalImage(String horizontalImage) {
            this.horizontalImage = horizontalImage;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getMovieId() {
            return movieId;
        }

        public void setMovieId(String movieId) {
            this.movieId = movieId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }
    }
}
