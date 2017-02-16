package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/8/17.
 */
public class MyActivitiesOfTeachAndResearchDetailBean extends BaseResponse {


    /**
     * markingAmount : 1
     * createTime : 2016-08-16 15:51:56
     * browseNames : 王占龙,
     * activityContent : 活动内容
     * address : 河北省保定市
     * rtime : 2016-08-16
     * rgroup : 1
     * allPerson : 参与人员
     * ReadOverList : [{"id":"57b2c7de0cf2549272b4930a","researchActivityId":"57b2c61c3ca9b35fbad6bd6d","researchActivityName":"中心议题","markingType":"1","comment":"很好ok的","readerId":"577f537c6303834778758391","readerName":"王占龙","readTime":"2016-08-16 15:59:26","imgUrl":"http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue/57a29bd93ca96419dc331134"}]
     * simpleReview : 简单评议：
     * centerTitle : 中心议题
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
        private String browseNames;
        private String activityContent;
        private String address;
        private String rtime;
        private String rgroup;
        private String allPerson;
        private String simpleReview;
        private String centerTitle;
        /**
         * id : 57b2c7de0cf2549272b4930a
         * researchActivityId : 57b2c61c3ca9b35fbad6bd6d
         * researchActivityName : 中心议题
         * markingType : 1
         * comment : 很好ok的
         * readerId : 577f537c6303834778758391
         * readerName : 王占龙
         * readTime : 2016-08-16 15:59:26
         * imgUrl : http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue/57a29bd93ca96419dc331134
         */

        private List<ReadOverListBean> ReadOverList;

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

        public String getBrowseNames() {
            return browseNames;
        }

        public void setBrowseNames(String browseNames) {
            this.browseNames = browseNames;
        }

        public String getActivityContent() {
            return activityContent;
        }

        public void setActivityContent(String activityContent) {
            this.activityContent = activityContent;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getRtime() {
            return rtime;
        }

        public void setRtime(String rtime) {
            this.rtime = rtime;
        }

        public String getRgroup() {
            return rgroup;
        }

        public void setRgroup(String rgroup) {
            this.rgroup = rgroup;
        }

        public String getAllPerson() {
            return allPerson;
        }

        public void setAllPerson(String allPerson) {
            this.allPerson = allPerson;
        }

        public String getSimpleReview() {
            return simpleReview;
        }

        public void setSimpleReview(String simpleReview) {
            this.simpleReview = simpleReview;
        }

        public String getCenterTitle() {
            return centerTitle;
        }

        public void setCenterTitle(String centerTitle) {
            this.centerTitle = centerTitle;
        }

        public List<ReadOverListBean> getReadOverList() {
            return ReadOverList;
        }

        public void setReadOverList(List<ReadOverListBean> ReadOverList) {
            this.ReadOverList = ReadOverList;
        }

        public static class ReadOverListBean {
            private String id;
            private String researchActivityId;
            private String researchActivityName;
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

            public String getResearchActivityId() {
                return researchActivityId;
            }

            public void setResearchActivityId(String researchActivityId) {
                this.researchActivityId = researchActivityId;
            }

            public String getResearchActivityName() {
                return researchActivityName;
            }

            public void setResearchActivityName(String researchActivityName) {
                this.researchActivityName = researchActivityName;
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
