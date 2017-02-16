package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/6/14.
 */
public class OfOneGradeAllClassBean  extends BaseResponse{


    /**
     * id : 56430cc460c1de3b17083c94
     * schoolId : 564306c0b26c43a3069cd5ac
     * gradeId : 56430cbc60c1de3b17083c8e
     * classNum : 1
     * name : 1班
     * createTime : 2015-11-11 17:39:16
     * gradeuated : 0
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
        private String gradeId;
        private int classNum;
        private String name;
        private String createTime;
        private String gradeuated;
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

        public String getGradeId() {
            return gradeId;
        }

        public void setGradeId(String gradeId) {
            this.gradeId = gradeId;
        }

        public int getClassNum() {
            return classNum;
        }

        public void setClassNum(int classNum) {
            this.classNum = classNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getGradeuated() {
            return gradeuated;
        }

        public void setGradeuated(String gradeuated) {
            this.gradeuated = gradeuated;
        }

        public String getEnabled() {
            return enabled;
        }

        public void setEnabled(String enabled) {
            this.enabled = enabled;
        }
    }
}
