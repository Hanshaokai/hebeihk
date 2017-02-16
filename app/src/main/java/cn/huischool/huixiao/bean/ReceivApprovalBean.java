package cn.huischool.huixiao.bean;

import java.io.Serializable;
import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/6/16.
 */
public class ReceivApprovalBean extends BaseResponse {


    /**
     * createTime : 2016-07-01 10:14:39
     * approvalFileName :
     * approvalTime : 2016-07-01 10:14:53
     * approversIdsNum : 1
     * creater_imgurl : http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/5756444cdf650e58deb458b7
     * creater : 王占龙
     * approvalId : 5775d20f2c6161e420c007ac
     * content : 报销报销报销
     * title : 测试0701
     * approvalInfo : [{"id":"5775d20f2c6161e420c007ad","approvalTime":"2016-07-01 10:14:53","approversIdsNum":"1","approver_imgurl":"http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/5756444cdf650e58deb458b7","opinion":"1","comment":"很好","approvalId":"5775d20f2c6161e420c007ac","approverName":"王占龙"},{"id":"5775d2122c6161e420c007ae","approvalTime":"2016-07-01 10:16:28","approversIdsNum":"2","approver_imgurl":null,"opinion":"1","comment":"必须同意","approvalId":"5775d20f2c6161e420c007ac","approverName":"袁堂亮"},{"id":"5775d2122c6161e420c007af","approvalTime":"2016-07-01 10:18:25","approversIdsNum":"3","approver_imgurl":"http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/5756444cdf650e58deb458b7","opinion":"1","comment":"都同意了","approvalId":"5775d20f2c6161e420c007ac","approverName":"王占龙"},{"id":"5775d3042c6161e420c007b0","approvalTime":null,"approversIdsNum":null,"approver_imgurl":null,"opinion":null,"comment":null,"approvalId":"5775d20f2c6161e420c007ac","approverName":"王国胜"}]
     * approvalStatus : 3
     * opinion : 1
     * comment : 很好
     * approvalType : 5
     * approverName : 王占龙
     * approvalFileId :
     */

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean implements Serializable {
        private String createTime;
        private String approvalFileName;
        private String approvalTime;
        private String approversIdsNum;
        private String creater_imgurl;
        private String creater;
        private String approvalId;
        private String content;
        private String title;
        private String approvalStatus;
        private String opinion;
        private String comment;
        private String approvalType;
        private String approverName;
        private String approvalFileId;
        private String htmlFileUrl;
        private String recipientNames;

        public String getRecipientNames() {
            return recipientNames;
        }

        public void setRecipientNames(String recipientNames) {
            this.recipientNames = recipientNames;
        }

        public String getHtmlFileUrl() {
            return htmlFileUrl;
        }

        public void setHtmlFileUrl(String htmlFileUrl) {
            this.htmlFileUrl = htmlFileUrl;
        }

        /**
         * id : 5775d20f2c6161e420c007ad
         * approvalTime : 2016-07-01 10:14:53
         * approversIdsNum : 1
         * approver_imgurl : http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/5756444cdf650e58deb458b7
         * opinion : 1
         * comment : 很好
         * approvalId : 5775d20f2c6161e420c007ac
         * approverName : 王占龙
         */

        private List<ApprovalInfoBean> approvalInfo;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getApprovalFileName() {
            return approvalFileName;
        }

        public void setApprovalFileName(String approvalFileName) {
            this.approvalFileName = approvalFileName;
        }

        public String getApprovalTime() {
            return approvalTime;
        }

        public void setApprovalTime(String approvalTime) {
            this.approvalTime = approvalTime;
        }

        public String getApproversIdsNum() {
            return approversIdsNum;
        }

        public void setApproversIdsNum(String approversIdsNum) {
            this.approversIdsNum = approversIdsNum;
        }

        public String getCreater_imgurl() {
            return creater_imgurl;
        }

        public void setCreater_imgurl(String creater_imgurl) {
            this.creater_imgurl = creater_imgurl;
        }

        public String getCreater() {
            return creater;
        }

        public void setCreater(String creater) {
            this.creater = creater;
        }

        public String getApprovalId() {
            return approvalId;
        }

        public void setApprovalId(String approvalId) {
            this.approvalId = approvalId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getApprovalStatus() {
            return approvalStatus;
        }

        public void setApprovalStatus(String approvalStatus) {
            this.approvalStatus = approvalStatus;
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

        public String getApprovalType() {
            return approvalType;
        }

        public void setApprovalType(String approvalType) {
            this.approvalType = approvalType;
        }

        public String getApproverName() {
            return approverName;
        }

        public void setApproverName(String approverName) {
            this.approverName = approverName;
        }

        public String getApprovalFileId() {
            return approvalFileId;
        }

        public void setApprovalFileId(String approvalFileId) {
            this.approvalFileId = approvalFileId;
        }

        public List<ApprovalInfoBean> getApprovalInfo() {
            return approvalInfo;
        }

        public void setApprovalInfo(List<ApprovalInfoBean> approvalInfo) {
            this.approvalInfo = approvalInfo;
        }

        public static class ApprovalInfoBean implements Serializable {
            private String id;
            private String approvalTime;
            private String approversIdsNum;
            private String approver_imgurl;
            private String opinion;
            private String comment;
            private String approvalId;
            private String approverName;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getApprovalTime() {
                return approvalTime;
            }

            public void setApprovalTime(String approvalTime) {
                this.approvalTime = approvalTime;
            }

            public String getApproversIdsNum() {
                return approversIdsNum;
            }

            public void setApproversIdsNum(String approversIdsNum) {
                this.approversIdsNum = approversIdsNum;
            }

            public String getApprover_imgurl() {
                return approver_imgurl;
            }

            public void setApprover_imgurl(String approver_imgurl) {
                this.approver_imgurl = approver_imgurl;
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

            public String getApprovalId() {
                return approvalId;
            }

            public void setApprovalId(String approvalId) {
                this.approvalId = approvalId;
            }

            public String getApproverName() {
                return approverName;
            }

            public void setApproverName(String approverName) {
                this.approverName = approverName;
            }
        }
    }
}
