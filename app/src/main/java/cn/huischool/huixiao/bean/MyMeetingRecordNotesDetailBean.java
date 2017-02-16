package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/8/15.
 */
public class MyMeetingRecordNotesDetailBean extends BaseResponse{


    /**
     * markingAmount : 1
     * meetContext : 开会政策
     * createTime : 2016-08-03 15:08:58
     * meetTime : 2016-06-03
     * browseNames : 王占龙,王者书,
     * allPerson : 王，李敏
     * speaker : 王校长
     * meetHost : 李老师
     * meetAddress : 富平
     * spokesMan : 王校长
     * meetTitle : 讨论
     * ReadOverList : [{"id":"57a1a75b3ca9fa8fd42bc5fa","meetRecordId":"57a1988a3ca974c72228b42a","meetRecordName":"讨论","markingType":"1","comment":"讨论结果很值得鼓励","readerId":"577f55456303834778758395","readerName":"王者书","readTime":"2016-08-03 16:12:11","imgUrl":"http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue/57a29a593ca9686aa00e8b2e"}]
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
        private String meetContext;
        private String createTime;
        private String meetTime;
        private String browseNames;
        private String allPerson;
        private String speaker;
        private String meetHost;
        private String meetAddress;
        private String spokesMan;
        private String meetTitle;
        private String fileId;
        /**
         * id : 57a1a75b3ca9fa8fd42bc5fa
         * meetRecordId : 57a1988a3ca974c72228b42a
         * meetRecordName : 讨论
         * markingType : 1
         * comment : 讨论结果很值得鼓励
         * readerId : 577f55456303834778758395
         * readerName : 王者书
         * readTime : 2016-08-03 16:12:11
         * imgUrl : http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue/57a29a593ca9686aa00e8b2e
         */

        private List<ReadOverListBean> ReadOverList;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public String getMarkingAmount() {
            return markingAmount;
        }

        public void setMarkingAmount(String markingAmount) {
            this.markingAmount = markingAmount;
        }

        public String getMeetContext() {
            return meetContext;
        }

        public void setMeetContext(String meetContext) {
            this.meetContext = meetContext;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getMeetTime() {
            return meetTime;
        }

        public void setMeetTime(String meetTime) {
            this.meetTime = meetTime;
        }

        public String getBrowseNames() {
            return browseNames;
        }

        public void setBrowseNames(String browseNames) {
            this.browseNames = browseNames;
        }

        public String getAllPerson() {
            return allPerson;
        }

        public void setAllPerson(String allPerson) {
            this.allPerson = allPerson;
        }

        public String getSpeaker() {
            return speaker;
        }

        public void setSpeaker(String speaker) {
            this.speaker = speaker;
        }

        public String getMeetHost() {
            return meetHost;
        }

        public void setMeetHost(String meetHost) {
            this.meetHost = meetHost;
        }

        public String getMeetAddress() {
            return meetAddress;
        }

        public void setMeetAddress(String meetAddress) {
            this.meetAddress = meetAddress;
        }

        public String getSpokesMan() {
            return spokesMan;
        }

        public void setSpokesMan(String spokesMan) {
            this.spokesMan = spokesMan;
        }

        public String getMeetTitle() {
            return meetTitle;
        }

        public void setMeetTitle(String meetTitle) {
            this.meetTitle = meetTitle;
        }

        public List<ReadOverListBean> getReadOverList() {
            return ReadOverList;
        }

        public void setReadOverList(List<ReadOverListBean> ReadOverList) {
            this.ReadOverList = ReadOverList;
        }

        public static class ReadOverListBean {
            private String id;
            private String meetRecordId;
            private String meetRecordName;
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

            public String getMeetRecordId() {
                return meetRecordId;
            }

            public void setMeetRecordId(String meetRecordId) {
                this.meetRecordId = meetRecordId;
            }

            public String getMeetRecordName() {
                return meetRecordName;
            }

            public void setMeetRecordName(String meetRecordName) {
                this.meetRecordName = meetRecordName;
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
