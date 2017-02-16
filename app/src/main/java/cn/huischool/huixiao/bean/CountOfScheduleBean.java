package cn.huischool.huixiao.bean;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/8/29.
 */
public class CountOfScheduleBean extends BaseResponse {


    /**
     * afficheCount : 98
     * approvalCount : 1
     * noticeCount : 8
     */

    private ResultsBean results;

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public static class ResultsBean {
        private int afficheCount;
        private int approvalCount;
        private int noticeCount;

        public int getAfficheCount() {
            return afficheCount;
        }

        public void setAfficheCount(int afficheCount) {
            this.afficheCount = afficheCount;
        }

        public int getApprovalCount() {
            return approvalCount;
        }

        public void setApprovalCount(int approvalCount) {
            this.approvalCount = approvalCount;
        }

        public int getNoticeCount() {
            return noticeCount;
        }

        public void setNoticeCount(int noticeCount) {
            this.noticeCount = noticeCount;
        }
    }
}
