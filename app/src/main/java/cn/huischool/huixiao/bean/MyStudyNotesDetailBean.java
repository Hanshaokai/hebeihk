package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/8/17.
 */
public class MyStudyNotesDetailBean extends BaseResponse {


    /**
     * markingAmount : 1
     * studyAddress : 学习地点
     * createTime : 2016-08-16 11:36:57
     * studyTitle : 学习主题
     * browseNames : 王占龙,
     * learnNotes : 学习笔记限制500个字
     * learnLesson : 学习感悟限制500个字
     * studySource : 内容出处
     * ReadOverList : [{"id":"57b2a1e70cf28d9548c2b6e4","studyNotesId":"57b28a5a3ca9859ed0ff5c96","studyNotesName":"学习主题","markingType":"1","comment":"学习主题 继续  学无止境","readerId":"577f537c6303834778758391","readerName":"王占龙","readTime":"2016-08-16 13:17:27","imgUrl":"http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue/57a29bd93ca96419dc331134"}]
     * studyTime : 2016-08-16
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
        private String studyAddress;
        private String createTime;
        private String studyTitle;
        private String browseNames;
        private String learnNotes;
        private String learnLesson;
        private String studySource;
        private String studyTime;
        /**
         * id : 57b2a1e70cf28d9548c2b6e4
         * studyNotesId : 57b28a5a3ca9859ed0ff5c96
         * studyNotesName : 学习主题
         * markingType : 1
         * comment : 学习主题 继续  学无止境
         * readerId : 577f537c6303834778758391
         * readerName : 王占龙
         * readTime : 2016-08-16 13:17:27
         * imgUrl : http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue/57a29bd93ca96419dc331134
         */

        private List<ReadOverListBean> ReadOverList;

        public String getMarkingAmount() {
            return markingAmount;
        }

        public void setMarkingAmount(String markingAmount) {
            this.markingAmount = markingAmount;
        }

        public String getStudyAddress() {
            return studyAddress;
        }

        public void setStudyAddress(String studyAddress) {
            this.studyAddress = studyAddress;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getStudyTitle() {
            return studyTitle;
        }

        public void setStudyTitle(String studyTitle) {
            this.studyTitle = studyTitle;
        }

        public String getBrowseNames() {
            return browseNames;
        }

        public void setBrowseNames(String browseNames) {
            this.browseNames = browseNames;
        }

        public String getLearnNotes() {
            return learnNotes;
        }

        public void setLearnNotes(String learnNotes) {
            this.learnNotes = learnNotes;
        }

        public String getLearnLesson() {
            return learnLesson;
        }

        public void setLearnLesson(String learnLesson) {
            this.learnLesson = learnLesson;
        }

        public String getStudySource() {
            return studySource;
        }

        public void setStudySource(String studySource) {
            this.studySource = studySource;
        }

        public String getStudyTime() {
            return studyTime;
        }

        public void setStudyTime(String studyTime) {
            this.studyTime = studyTime;
        }

        public List<ReadOverListBean> getReadOverList() {
            return ReadOverList;
        }

        public void setReadOverList(List<ReadOverListBean> ReadOverList) {
            this.ReadOverList = ReadOverList;
        }

        public static class ReadOverListBean {
            private String id;
            private String studyNotesId;
            private String studyNotesName;
            private String markingType;
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

            public String getStudyNotesId() {
                return studyNotesId;
            }

            public void setStudyNotesId(String studyNotesId) {
                this.studyNotesId = studyNotesId;
            }

            public String getStudyNotesName() {
                return studyNotesName;
            }

            public void setStudyNotesName(String studyNotesName) {
                this.studyNotesName = studyNotesName;
            }

            public String getMarkingType() {
                return markingType;
            }

            public void setMarkingType(String markingType) {
                this.markingType = markingType;
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
