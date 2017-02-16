package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/6/14.
 */
public class AllSubjectBean extends BaseResponse {


    /**
     * id : 56430cda60c1de3b17083cb8
     * schoolId : 564306c0b26c43a3069cd5ac
     * name : 语文
     * subjectDesc : 语文
     * createTime : 2015-11-11 17:39:38
     * enabled : 0
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
        private String subjectDesc;
        private String createTime;
        private String enabled;

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

        public String getSubjectDesc() {
            return subjectDesc;
        }

        public void setSubjectDesc(String subjectDesc) {
            this.subjectDesc = subjectDesc;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getEnabled() {
            return enabled;
        }

        public void setEnabled(String enabled) {
            this.enabled = enabled;
        }
    }
}
