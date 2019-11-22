package com.bw.movie.bean;

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/15
 * 描述:WMovie
 * 功能：
 **/
public class XiangBean {

    /**
     * result : {"commentNum":12,"duration":"111分钟","imageUrl":"http://172.17.8.100/images/movie/stills/zgjz/zgjz1.jpg","movieActor":[{"name":"张涵予","photo":"http://172.17.8.100/images/movie/actor/zgjz/zhanghanyu.jpg","role":"刘长健"},{"name":"欧豪","photo":"http://172.17.8.100/images/movie/actor/zgjz/ouhao.jpg","role":"徐奕辰"},{"name":"袁泉","photo":"http://172.17.8.100/images/movie/actor/zgjz/yuanquan.jpg","role":"毕男"},{"name":"张天爱","photo":"http://172.17.8.100/images/movie/actor/zgjz/zhangtianai.jpg","role":"黄佳"},{"name":"李沁","photo":"http://172.17.8.100/images/movie/actor/zgjz/liqin.jpg","role":"周雅文"}],"movieDirector":[{"name":"刘伟强","photo":"http://172.17.8.100/images/movie/director/zgjz/1.jpg"}],"movieId":24,"movieType":"剧情 / 纪录","name":"中国机长","placeOrigin":"中国大陆","posterList":["http://172.17.8.100/images/movie/stills/zgjz/zgjz6.jpg","http://172.17.8.100/images/movie/stills/zgjz/zgjz5.jpg","http://172.17.8.100/images/movie/stills/zgjz/zgjz4.jpg","http://172.17.8.100/images/movie/stills/zgjz/zgjz3.jpg","http://172.17.8.100/images/movie/stills/zgjz/zgjz2.jpg","http://172.17.8.100/images/movie/stills/zgjz/zgjz1.jpg"],"releaseTime":1569772800000,"score":9.4,"shortFilmList":[{"imageUrl":"http://172.17.8.100/images/movie/stills/zgjz/zgjz4.jpg","videoUrl":"http://172.17.8.100/video/movie/zgjz/zgjz1.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/zgjz/zgjz5.jpg","videoUrl":"http://172.17.8.100/video/movie/zgjz/zgjz2.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/zgjz/zgjz3.jpg","videoUrl":"http://172.17.8.100/video/movie/zgjz/zgjz3.mp4"}],"summary":"根据2018年5月14日四川航空3U8633航班机组成功处置特情真实事件改编。机组执行航班任务时，在万米高空突遇驾驶舱风挡玻璃爆裂脱落、座舱释压的极端罕见险情，生死关头，他们临危不乱、果断应对、正确处置，确保了机上全部人员的生命安全，创造了世界民航史上的奇迹。","whetherFollow":2}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * commentNum : 12
         * duration : 111分钟
         * imageUrl : http://172.17.8.100/images/movie/stills/zgjz/zgjz1.jpg
         * movieActor : [{"name":"张涵予","photo":"http://172.17.8.100/images/movie/actor/zgjz/zhanghanyu.jpg","role":"刘长健"},{"name":"欧豪","photo":"http://172.17.8.100/images/movie/actor/zgjz/ouhao.jpg","role":"徐奕辰"},{"name":"袁泉","photo":"http://172.17.8.100/images/movie/actor/zgjz/yuanquan.jpg","role":"毕男"},{"name":"张天爱","photo":"http://172.17.8.100/images/movie/actor/zgjz/zhangtianai.jpg","role":"黄佳"},{"name":"李沁","photo":"http://172.17.8.100/images/movie/actor/zgjz/liqin.jpg","role":"周雅文"}]
         * movieDirector : [{"name":"刘伟强","photo":"http://172.17.8.100/images/movie/director/zgjz/1.jpg"}]
         * movieId : 24
         * movieType : 剧情 / 纪录
         * name : 中国机长
         * placeOrigin : 中国大陆
         * posterList : ["http://172.17.8.100/images/movie/stills/zgjz/zgjz6.jpg","http://172.17.8.100/images/movie/stills/zgjz/zgjz5.jpg","http://172.17.8.100/images/movie/stills/zgjz/zgjz4.jpg","http://172.17.8.100/images/movie/stills/zgjz/zgjz3.jpg","http://172.17.8.100/images/movie/stills/zgjz/zgjz2.jpg","http://172.17.8.100/images/movie/stills/zgjz/zgjz1.jpg"]
         * releaseTime : 1569772800000
         * score : 9.4
         * shortFilmList : [{"imageUrl":"http://172.17.8.100/images/movie/stills/zgjz/zgjz4.jpg","videoUrl":"http://172.17.8.100/video/movie/zgjz/zgjz1.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/zgjz/zgjz5.jpg","videoUrl":"http://172.17.8.100/video/movie/zgjz/zgjz2.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/zgjz/zgjz3.jpg","videoUrl":"http://172.17.8.100/video/movie/zgjz/zgjz3.mp4"}]
         * summary : 根据2018年5月14日四川航空3U8633航班机组成功处置特情真实事件改编。机组执行航班任务时，在万米高空突遇驾驶舱风挡玻璃爆裂脱落、座舱释压的极端罕见险情，生死关头，他们临危不乱、果断应对、正确处置，确保了机上全部人员的生命安全，创造了世界民航史上的奇迹。
         * whetherFollow : 2
         */

        private String commentNum;
        private String duration;
        private String imageUrl;
        private String movieId;
        private String movieType;
        private String name;
        private String placeOrigin;
        private long releaseTime;
        private String score;
        private String summary;
        private String whetherFollow;
        private List<MovieActorBean> movieActor;
        private List<MovieDirectorBean> movieDirector;
        private List<String> posterList;
        private List<ShortFilmListBean> shortFilmList;

        public String getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(String commentNum) {
            this.commentNum = commentNum;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
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

        public String getMovieType() {
            return movieType;
        }

        public void setMovieType(String movieType) {
            this.movieType = movieType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlaceOrigin() {
            return placeOrigin;
        }

        public void setPlaceOrigin(String placeOrigin) {
            this.placeOrigin = placeOrigin;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getWhetherFollow() {
            return whetherFollow;
        }

        public void setWhetherFollow(String whetherFollow) {
            this.whetherFollow = whetherFollow;
        }

        public List<MovieActorBean> getMovieActor() {
            return movieActor;
        }

        public void setMovieActor(List<MovieActorBean> movieActor) {
            this.movieActor = movieActor;
        }

        public List<MovieDirectorBean> getMovieDirector() {
            return movieDirector;
        }

        public void setMovieDirector(List<MovieDirectorBean> movieDirector) {
            this.movieDirector = movieDirector;
        }

        public List<String> getPosterList() {
            return posterList;
        }

        public void setPosterList(List<String> posterList) {
            this.posterList = posterList;
        }

        public List<ShortFilmListBean> getShortFilmList() {
            return shortFilmList;
        }

        public void setShortFilmList(List<ShortFilmListBean> shortFilmList) {
            this.shortFilmList = shortFilmList;
        }

        public static class MovieActorBean {
            /**
             * name : 张涵予
             * photo : http://172.17.8.100/images/movie/actor/zgjz/zhanghanyu.jpg
             * role : 刘长健
             */

            private String name;
            private String photo;
            private String role;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class MovieDirectorBean {
            /**
             * name : 刘伟强
             * photo : http://172.17.8.100/images/movie/director/zgjz/1.jpg
             */

            private String name;
            private String photo;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public static class ShortFilmListBean {
            /**
             * imageUrl : http://172.17.8.100/images/movie/stills/zgjz/zgjz4.jpg
             * videoUrl : http://172.17.8.100/video/movie/zgjz/zgjz1.mp4
             */

            private String imageUrl;
            private String videoUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }
        }
    }
}
