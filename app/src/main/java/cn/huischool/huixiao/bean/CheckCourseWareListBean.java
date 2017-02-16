package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/7/28.
 */
public class CheckCourseWareListBean extends BaseResponse {


    /**
     * markingAmount : 1
     * id : 57833fec6303d3ef07f7bc10
     * coursewareFileName : chengxiangxiaoxue.ppt
     * creater_name : 王占龙
     * coursewareDet : 二年级,综合实践,上册
     * coursewareName : 课件啦啦啦
     * creater_imgurl : http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/5785f40e6303719e8ff1e847
     */

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String markingAmount;
        private String id;
        private String coursewareFileName;
        private String creater_name;
        private String coursewareDet;
        private String coursewareName;
        private String creater_imgurl;

        public String getMarkingAmount() {
            return markingAmount;
        }

        public void setMarkingAmount(String markingAmount) {
            this.markingAmount = markingAmount;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCoursewareFileName() {
            return coursewareFileName;
        }

        public void setCoursewareFileName(String coursewareFileName) {
            this.coursewareFileName = coursewareFileName;
        }

        public String getCreater_name() {
            return creater_name;
        }

        public void setCreater_name(String creater_name) {
            this.creater_name = creater_name;
        }

        public String getCoursewareDet() {
            return coursewareDet;
        }

        public void setCoursewareDet(String coursewareDet) {
            this.coursewareDet = coursewareDet;
        }

        public String getCoursewareName() {
            return coursewareName;
        }

        public void setCoursewareName(String coursewareName) {
            this.coursewareName = coursewareName;
        }

        public String getCreater_imgurl() {
            return creater_imgurl;
        }

        public void setCreater_imgurl(String creater_imgurl) {
            this.creater_imgurl = creater_imgurl;
        }
    }
}
