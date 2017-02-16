package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/7/26.
 */
public class CheckGrammarListBean extends BaseResponse {


    /**
     * markingAmount : 1
     * id : 57833bb86303d3ef07f7bc0e
     * lessonName : 测试教案0711
     * creater_name : 王占龙
     * fileName : 新建 Microsoft Word 文档 (2).docx
     * lessonDet : 二年级,综合实践,上册
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
        private String lessonName;
        private String creater_name;
        private String fileName;
        private String lessonDet;
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

        public String getLessonName() {
            return lessonName;
        }

        public void setLessonName(String lessonName) {
            this.lessonName = lessonName;
        }

        public String getCreater_name() {
            return creater_name;
        }

        public void setCreater_name(String creater_name) {
            this.creater_name = creater_name;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getLessonDet() {
            return lessonDet;
        }

        public void setLessonDet(String lessonDet) {
            this.lessonDet = lessonDet;
        }

        public String getCreater_imgurl() {
            return creater_imgurl;
        }

        public void setCreater_imgurl(String creater_imgurl) {
            this.creater_imgurl = creater_imgurl;
        }
    }
}
