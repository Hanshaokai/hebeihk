package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/8/30.
 */
public class ReceivedNoticeDetailBean extends BaseResponse{


    /**
     * content : 通知请按提
     * createTime : 2016-07-19 14:53:19
     * title : 通知
     * weiduList : [{"phone":"13831293131","realName":"张建梅"},{"phone":"15832244777","realName":"郭春会"},{"phone":"15311111111","realName":"白平丽"},{"phone":"13903363009","realName":"袁堂亮"},{"phone":"18325458795","realName":"李建芬"}]
     * senderName : 王占龙
     * htmlFileUrl : null
     * noticeFileName :
     */

    private ResultsBean results;

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String content;
        private String createTime;
        private String title;
        private String senderName;
        private String htmlFileUrl;
        private String noticeFileName;
        private String fileId;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        /**
         * phone : 13831293131
         * realName : 张建梅
         */

        private List<WeiduListBean> weiduList;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSenderName() {
            return senderName;
        }

        public void setSenderName(String senderName) {
            this.senderName = senderName;
        }

        public Object getHtmlFileUrl() {
            return htmlFileUrl;
        }

        public void setHtmlFileUrl(String htmlFileUrl) {
            this.htmlFileUrl = htmlFileUrl;
        }

        public String getNoticeFileName() {
            return noticeFileName;
        }

        public void setNoticeFileName(String noticeFileName) {
            this.noticeFileName = noticeFileName;
        }

        public List<WeiduListBean> getWeiduList() {
            return weiduList;
        }

        public void setWeiduList(List<WeiduListBean> weiduList) {
            this.weiduList = weiduList;
        }

        public static class WeiduListBean {
            private String phone;
            private String realName;

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }
        }
    }
}
