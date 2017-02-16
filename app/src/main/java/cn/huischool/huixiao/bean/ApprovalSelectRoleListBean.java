package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/6/24.
 */
public class ApprovalSelectRoleListBean extends BaseResponse {


    /**
     * id : 5646ebaa94dfc8dc27283849
     * schoolId : 564306c0b26c43a3069cd5ac
     * name : 校长
     * description : 校长
     * createTime : 2015-11-14 16:07:06
     * remarkId : 0
     * enabled : null
     * linkUrl : null
     */

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String id;
        private String schoolId;
        private String name;
        private String description;
        private String createTime;
        private String remarkId;
        private Object enabled;
        private Object linkUrl;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(String schoolId) {
            this.schoolId = schoolId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getRemarkId() {
            return remarkId;
        }

        public void setRemarkId(String remarkId) {
            this.remarkId = remarkId;
        }

        public Object getEnabled() {
            return enabled;
        }

        public void setEnabled(Object enabled) {
            this.enabled = enabled;
        }

        public Object getLinkUrl() {
            return linkUrl;
        }

        public void setLinkUrl(Object linkUrl) {
            this.linkUrl = linkUrl;
        }
    }
}
