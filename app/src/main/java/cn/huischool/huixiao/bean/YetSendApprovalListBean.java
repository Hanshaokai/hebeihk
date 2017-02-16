package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/6/15.
 */
public class YetSendApprovalListBean extends BaseResponse {


    /**
     * content : 申请出差一个月
     * id : 57bfdc8ada8c542f2f419046
     * approvalFileName :
     * createTime : 2016-08-26 14:07:05
     * title : null
     * approvalInfo : [{"id":"57bfdc8ada8c542f2f419047","approvalTime":"2016-08-26 14:10:07","approversIdsNum":"1","approverId":"577f537c6303834778758391","approver_imgurl":"http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue/57a29bd93ca96419dc331134","opinion":"1","comment":"同意okok","approvalId":"57bfdc8ada8c542f2f419046","approverName":"王占龙"},{"id":"57bfdc8ada8c542f2f419048","approvalTime":"2016-08-26 14:14:05","approversIdsNum":"2","approverId":"577f5614630383477875839d","approver_imgurl":null,"opinion":"0","comment":"不同意啦","approvalId":"57bfdc8ada8c542f2f419046","approverName":"袁堂亮"},{"id":"57bfdc8ada8c542f2f419049","approvalTime":null,"approversIdsNum":"3","approverId":"577f5691630383477875839f","approver_imgurl":null,"opinion":null,"comment":null,"approvalId":"57bfdc8ada8c542f2f419046","approverName":"李建芬"}]
     * approvalStatus : 2
     * htmlFileUrl :
     * creater_imgurl : http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/57abdd640cf26d8718dea2f0
     * creater : 王静
     * approvalType : 1
     * recipientNames :
     * approvalFileId :
     */

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String content;
        private String id;
        private String approvalFileName;
        private String createTime;
        private Object title;
        private String approvalStatus;
        private String htmlFileUrl;
        private String creater_imgurl;
        private String creater;
        private String approvalType;
        private String recipientNames;
        private String approvalFileId;
        /**
         * id : 57bfdc8ada8c542f2f419047
         * approvalTime : 2016-08-26 14:10:07
         * approversIdsNum : 1
         * approverId : 577f537c6303834778758391
         * approver_imgurl : http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue/57a29bd93ca96419dc331134
         * opinion : 1
         * comment : 同意okok
         * approvalId : 57bfdc8ada8c542f2f419046
         * approverName : 王占龙
         */

        private List<ApprovalInfoBean> approvalInfo;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getApprovalFileName() {
            return approvalFileName;
        }

        public void setApprovalFileName(String approvalFileName) {
            this.approvalFileName = approvalFileName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getTitle() {
            return title;
        }

        public void setTitle(Object title) {
            this.title = title;
        }

        public String getApprovalStatus() {
            return approvalStatus;
        }

        public void setApprovalStatus(String approvalStatus) {
            this.approvalStatus = approvalStatus;
        }

        public String getHtmlFileUrl() {
            return htmlFileUrl;
        }

        public void setHtmlFileUrl(String htmlFileUrl) {
            this.htmlFileUrl = htmlFileUrl;
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

        public String getApprovalType() {
            return approvalType;
        }

        public void setApprovalType(String approvalType) {
            this.approvalType = approvalType;
        }

        public String getRecipientNames() {
            return recipientNames;
        }

        public void setRecipientNames(String recipientNames) {
            this.recipientNames = recipientNames;
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

        public static class ApprovalInfoBean {
            private String id;
            private String approvalTime;
            private String approversIdsNum;
            private String approverId;
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

            public String getApproverId() {
                return approverId;
            }

            public void setApproverId(String approverId) {
                this.approverId = approverId;
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
