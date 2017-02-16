package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/7/15.
 */
public class MyCourseWareDetailBean extends BaseResponse {


    /**
     * markingAmount : 1
     * createTime : 2016-07-11 14:42:44
     * coursewareType : 已提交
     * piYueList : [{"id":"5783404c6303d3ef07f7bc11","coursewareId":"57833fec6303d3ef07f7bc10","coursewareName":"课件啦啦啦","markingType":"已批阅","opinion":"同意","comment":"good 很好呀55555555555555","readerId":"564306c0b26c43a3069cd521","readerName":"管理员","readTime":"2016-07-11 14:44:28","imgUrl":"http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/576272630cf2e6d43a83beaa"}]
     * coursewareDet : 二年级,综合实践,上册
     * fileName : chengxiangxiaoxue.ppt
     * htmlFileUrl : file-teacher-courseware.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/57833fe46303d3ef07f7bc0f/57833fe46303d3ef07f7bc0f.html
     * releaseType : 未发布
     * teacherName : 王占龙
     */

    private ResultsBean results;

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String markingAmount;
        private String createTime;
        private String coursewareType;
        private String coursewareDet;
        private String fileName;
        private String htmlFileUrl;
        private String releaseType;
        private String teacherName;
        private String browseNames;
        private String fileId;
        /**
         * id : 5783404c6303d3ef07f7bc11
         * coursewareId : 57833fec6303d3ef07f7bc10
         * coursewareName : 课件啦啦啦
         * markingType : 已批阅
         * opinion : 同意
         * comment : good 很好呀55555555555555
         * readerId : 564306c0b26c43a3069cd521
         * readerName : 管理员
         * readTime : 2016-07-11 14:44:28
         * imgUrl : http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/576272630cf2e6d43a83beaa
         */

        private List<PiYueListBean> piYueList;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public String getBrowseNames() {
            return browseNames;
        }

        public void setBrowseNames(String browseNames) {
            this.browseNames = browseNames;
        }

        public String getMarkingAmount() {
            return markingAmount;
        }

        public void setMarkingAmount(String markingAmount) {
            this.markingAmount = markingAmount;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCoursewareType() {
            return coursewareType;
        }

        public void setCoursewareType(String coursewareType) {
            this.coursewareType = coursewareType;
        }

        public String getCoursewareDet() {
            return coursewareDet;
        }

        public void setCoursewareDet(String coursewareDet) {
            this.coursewareDet = coursewareDet;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getHtmlFileUrl() {
            return htmlFileUrl;
        }

        public void setHtmlFileUrl(String htmlFileUrl) {
            this.htmlFileUrl = htmlFileUrl;
        }

        public String getReleaseType() {
            return releaseType;
        }

        public void setReleaseType(String releaseType) {
            this.releaseType = releaseType;
        }

        public String getTeacherName() {
            return teacherName;
        }

        public void setTeacherName(String teacherName) {
            this.teacherName = teacherName;
        }

        public List<PiYueListBean> getPiYueList() {
            return piYueList;
        }

        public void setPiYueList(List<PiYueListBean> piYueList) {
            this.piYueList = piYueList;
        }

        public static class PiYueListBean {
            private String id;
            private String coursewareId;
            private String coursewareName;
            private String markingType;
            private String opinion;
            private String comment;
            private String readerId;
            private String readerName;
            private String readTime;
            private String imgUrl;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCoursewareId() {
                return coursewareId;
            }

            public void setCoursewareId(String coursewareId) {
                this.coursewareId = coursewareId;
            }

            public String getCoursewareName() {
                return coursewareName;
            }

            public void setCoursewareName(String coursewareName) {
                this.coursewareName = coursewareName;
            }

            public String getMarkingType() {
                return markingType;
            }

            public void setMarkingType(String markingType) {
                this.markingType = markingType;
            }

            public String getOpinion() {
                return opinion;
            }

            public void setOpinion(String opinion) {
                this.opinion = opinion;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getReaderId() {
                return readerId;
            }

            public void setReaderId(String readerId) {
                this.readerId = readerId;
            }

            public String getReaderName() {
                return readerName;
            }

            public void setReaderName(String readerName) {
                this.readerName = readerName;
            }

            public String getReadTime() {
                return readTime;
            }

            public void setReadTime(String readTime) {
                this.readTime = readTime;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }
        }
    }
}
