package cn.huischool.huixiao.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2017/1/9.
 */

public class CommitNumberListBean extends BaseResponse {


    /**
     * results : {"total":1,"page":1,"pageSize":8,"records":2,"rows":[{"id":"577f4ec26303834778758275","realName":"张国会","creater_imgurl":null,"lesson_count":0,"courseware_count":0,"myLesson_count":0,"meetRecord_count":0,"researchActivity_count":0,"studyNotes_count":0},{"id":"577f4f2963038347787582ad","realName":"王静","creater_imgurl":"http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/57abdd640cf26d8718dea2f0","lesson_count":39,"courseware_count":11,"myLesson_count":16,"meetRecord_count":9,"researchActivity_count":4,"studyNotes_count":6}]}
     * errors : null
     */

    private ResultsBean results;


    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }


    public static class ResultsBean {
        /**
         * total : 1
         * page : 1
         * pageSize : 8
         * records : 2
         * rows : [{"id":"577f4ec26303834778758275","realName":"张国会","creater_imgurl":null,"lesson_count":0,"courseware_count":0,"myLesson_count":0,"meetRecord_count":0,"researchActivity_count":0,"studyNotes_count":0},{"id":"577f4f2963038347787582ad","realName":"王静","creater_imgurl":"http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/57abdd640cf26d8718dea2f0","lesson_count":39,"courseware_count":11,"myLesson_count":16,"meetRecord_count":9,"researchActivity_count":4,"studyNotes_count":6}]
         */

        private int total;
        private int page;
        private int pageSize;
        private int records;
        private List<RowsBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            /**
             * id : 577f4ec26303834778758275
             * realName : 张国会
             * creater_imgurl : null
             * lesson_count : 0
             * courseware_count : 0
             * myLesson_count : 0
             * meetRecord_count : 0
             * researchActivity_count : 0
             * studyNotes_count : 0
             */

            private String id;
            private String realName;
            private String creater_imgurl;
            private int lesson_count;
            private int courseware_count;
            private int myLesson_count;
            private int meetRecord_count;
            private int researchActivity_count;
            private int studyNotes_count;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getCreater_imgurl() {
                return creater_imgurl;
            }

            public void setCreater_imgurl(String creater_imgurl) {
                this.creater_imgurl = creater_imgurl;
            }

            public int getLesson_count() {
                return lesson_count;
            }

            public void setLesson_count(int lesson_count) {
                this.lesson_count = lesson_count;
            }

            public int getCourseware_count() {
                return courseware_count;
            }

            public void setCourseware_count(int courseware_count) {
                this.courseware_count = courseware_count;
            }

            public int getMyLesson_count() {
                return myLesson_count;
            }

            public void setMyLesson_count(int myLesson_count) {
                this.myLesson_count = myLesson_count;
            }

            public int getMeetRecord_count() {
                return meetRecord_count;
            }

            public void setMeetRecord_count(int meetRecord_count) {
                this.meetRecord_count = meetRecord_count;
            }

            public int getResearchActivity_count() {
                return researchActivity_count;
            }

            public void setResearchActivity_count(int researchActivity_count) {
                this.researchActivity_count = researchActivity_count;
            }

            public int getStudyNotes_count() {
                return studyNotes_count;
            }

            public void setStudyNotes_count(int studyNotes_count) {
                this.studyNotes_count = studyNotes_count;
            }
        }
    }
}
