package cn.huischool.huixiao.bean;

import java.io.Serializable;
import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/8/31.
 */
public class ApprovalDetailBean extends BaseResponse {

    /**
     * content : 资金申请内容
     * id : 57bfd63dda8c661eacd4e5d6
     * approvalFileName : chengxiangxiaoxue-修改.docx
     * createTime : 2016-08-26 13:40:09
     * approvalInfo : [{"id":"57bfd63dda8c661eacd4e5d7","approvalTime":"2016-08-26 13:44:54","approversIdsNum":"1","approverId":"577f537c6303834778758391","approver_imgurl":"http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue/57a29bd93ca96419dc331134","opinion":"1","comment":"很好同意","approvalId":"57bfd63dda8c661eacd4e5d6","approverName":"王占龙"},{"id":"57bfd63eda8c661eacd4e5d8","approvalTime":"2016-08-26 13:58:01","approversIdsNum":"2","approverId":"577f5691630383477875839f","approver_imgurl":null,"opinion":"1","comment":"同意啦啦","approvalId":"57bfd63dda8c661eacd4e5d6","approverName":"李建芬"},{"id":"57bfd63eda8c661eacd4e5d9","approvalTime":null,"approversIdsNum":"3","approverId":"577f5614630383477875839d","approver_imgurl":null,"opinion":null,"comment":null,"approvalId":"57bfd63dda8c661eacd4e5d6","approverName":"袁堂亮"}]
     * approversIdsNum : 1
     * htmlFileUrl :
     * opinion : 1
     * creater : 王静
     * approvalType : 0
     * recipientNames :
     */

    private ResultsBean results;

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public static class ResultsBean implements Serializable{
        private String content;
        private String id;
        private String approvalFileName;
        private String createTime;
        private String approversIdsNum;
        private String htmlFileUrl;
        private String opinion;
        private String creater;
        private String approvalType;
        private String recipientNames;
        private String fileId;
        /**
         * id : 57bfd63dda8c661eacd4e5d7
         * approvalTime : 2016-08-26 13:44:54
         * approversIdsNum : 1
         * approverId : 577f537c6303834778758391
         * approver_imgurl : http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue/57a29bd93ca96419dc331134
         * opinion : 1
         * comment : 很好同意
         * approvalId : 57bfd63dda8c661eacd4e5d6
         * approverName : 王占龙
         */

        private List<ApprovalInfoBean> approvalInfo;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

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

        public String getApproversIdsNum() {
            return approversIdsNum;
        }

        public void setApproversIdsNum(String approversIdsNum) {
            this.approversIdsNum = approversIdsNum;
        }

        public String getHtmlFileUrl() {
            return htmlFileUrl;
        }

        public void setHtmlFileUrl(String htmlFileUrl) {
            this.htmlFileUrl = htmlFileUrl;
        }

        public String getOpinion() {
            return opinion;
        }

        public void setOpinion(String opinion) {
            this.opinion = opinion;
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
