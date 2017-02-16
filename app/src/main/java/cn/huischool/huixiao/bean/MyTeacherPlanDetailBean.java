package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/7/13.
 */
public class MyTeacherPlanDetailBean extends BaseResponse {


    /**
     * markingAmount : 1
     * createTime : 2016-07-11 14:25:13
     * piYueList : [{"id":"578342656303d3ef07f7bc12","lessonId":"57833bb86303d3ef07f7bc0e","lessonName":"测试教案0711","markingType":"已批阅","opinion":"同意","comment":"666666666","readerId":"564306c0b26c43a3069cd521","readerName":"管理员","readTime":"2016-07-11 14:53:24","imgUrl":"http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/576272630cf2e6d43a83beaa"}]
     * lessonType : 已提交
     * fileName : 新建 Microsoft Word 文档 (2).docx
     * lessonDet : 二年级,综合实践,上册
     * releaseType : 发布到平台
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
        private String lessonType;
        private String fileName;
        private String lessonDet;
        private String releaseType;
        private String teacherName;
        private String htmlFileUrl;
        private String browseNames;
        private String fileId;

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

        public String getHtmlFileUrl() {
            return htmlFileUrl;
        }

        public void setHtmlFileUrl(String htmlFileUrl) {
            this.htmlFileUrl = htmlFileUrl;
        }

        /**
         * id : 578342656303d3ef07f7bc12
         * lessonId : 57833bb86303d3ef07f7bc0e
         * lessonName : 测试教案0711
         * markingType : 已批阅
         * opinion : 同意
         * comment : 666666666
         * readerId : 564306c0b26c43a3069cd521
         * readerName : 管理员
         * readTime : 2016-07-11 14:53:24
         * imgUrl : http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/576272630cf2e6d43a83beaa
         */

        private List<PiYueListBean> piYueList;

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

        public String getLessonType() {
            return lessonType;
        }

        public void setLessonType(String lessonType) {
            this.lessonType = lessonType;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getLessonDet() {
            return lessonDet;
        }

        public void setLessonDet(String lessonDet) {
            this.lessonDet = lessonDet;
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
            private String lessonId;
            private String lessonName;
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

            public String getLessonId() {
                return lessonId;
            }

            public void setLessonId(String lessonId) {
                this.lessonId = lessonId;
            }

            public String getLessonName() {
                return lessonName;
            }

            public void setLessonName(String lessonName) {
                this.lessonName = lessonName;
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
