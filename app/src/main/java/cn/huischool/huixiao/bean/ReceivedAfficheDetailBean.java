package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/8/30.
 */
public class ReceivedAfficheDetailBean extends BaseResponse {


    /**
     * content : 方法
     * createTime : 2016-08-26 17:12:51
     * title : 公告
     * weiduList : [{"phone":"18612345686","realName":"管理员"},{"phone":"13102650258","realName":"赵静"}]
     * afficheFileName : null
     * senderName : 王占龙
     * htmlFileUrl : null
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
        private String afficheFileName;
        private String senderName;
        private String htmlFileUrl;
        /**
         * phone : 18612345686
         * realName : 管理员
         */

        private List<WeiduListBean> weiduList;
        private String fileId;

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

        public String getAfficheFileName() {
            return afficheFileName;
        }

        public void setAfficheFileName(String afficheFileName) {
            this.afficheFileName = afficheFileName;
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

        public void setHtmlFileUrl(String  htmlFileUrl) {
            this.htmlFileUrl = htmlFileUrl;
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
