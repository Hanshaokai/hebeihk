package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/8/10.
 */
public class MyLesssonNotesDeatilBean extends BaseResponse {
    /**
     * markingAmount : 0
     * createTime : 2016-07-11 15:49:38
     * difOpinionAmount : 0
     * browseNames : çå é¾,cxschool,
     * teacherName : 王占龙
     * lessonAdvice : 0711听课啦0711听课啦0711听课啦0711听课啦0711听课啦0711听课啦0711听课啦0711听课啦
     * submitStatus : 1
     * lessonContext : 0711听课啦0711听课啦0711听课啦
     * num : 1
     * gradeName : 二年级
     * subjectName : 数学
     * lessonType : 第一单元
     * lessonTeacher : 张老师
     * month : 07
     * className : 3班
     * day : 11
     * lessonTitle : 0711听课啦
     * ReadOverList : []
     * myLessonId : 57834f926303246073294ac5
     */

    private ResultsBean results;

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String markingAmount;
        private String createTime;
        private String difOpinionAmount;
        private String browseNames;
        private String teacherName;
        private String lessonAdvice;
        private String submitStatus;
        private String lessonContext;
        private String num;
        private String gradeName;
        private String subjectName;
        private String lessonType;
        private String lessonTeacher;
        private String month;
        private String className;
        private String day;
        private String lessonTitle;
        private String myLessonId;
        private List<ReadOverListBean> ReadOverList;
        private String fileId;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public String getMarkingAmount() {
            return markingAmount;
        }

        public void setMarkingAmount(String markingAmount) {
            this.markingAmount = markingAmount;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDifOpinionAmount() {
            return difOpinionAmount;
        }

        public void setDifOpinionAmount(String difOpinionAmount) {
            this.difOpinionAmount = difOpinionAmount;
        }

        public String getBrowseNames() {
            return browseNames;
        }

        public void setBrowseNames(String browseNames) {
            this.browseNames = browseNames;
        }

        public String getTeacherName() {
            return teacherName;
        }

        public void setTeacherName(String teacherName) {
            this.teacherName = teacherName;
        }

        public String getLessonAdvice() {
            return lessonAdvice;
        }

        public void setLessonAdvice(String lessonAdvice) {
            this.lessonAdvice = lessonAdvice;
        }

        public String getSubmitStatus() {
            return submitStatus;
        }

        public void setSubmitStatus(String submitStatus) {
            this.submitStatus = submitStatus;
        }

        public String getLessonContext() {
            return lessonContext;
        }

        public void setLessonContext(String lessonContext) {
            this.lessonContext = lessonContext;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getGradeName() {
            return gradeName;
        }

        public void setGradeName(String gradeName) {
            this.gradeName = gradeName;
        }

        public String getSubjectName() {
            return subjectName;
        }

        public void setSubjectName(String subjectName) {
            this.subjectName = subjectName;
        }

        public String getLessonType() {
            return lessonType;
        }

        public void setLessonType(String lessonType) {
            this.lessonType = lessonType;
        }

        public String getLessonTeacher() {
            return lessonTeacher;
        }

        public void setLessonTeacher(String lessonTeacher) {
            this.lessonTeacher = lessonTeacher;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getLessonTitle() {
            return lessonTitle;
        }

        public void setLessonTitle(String lessonTitle) {
            this.lessonTitle = lessonTitle;
        }

        public String getMyLessonId() {
            return myLessonId;
        }

        public void setMyLessonId(String myLessonId) {
            this.myLessonId = myLessonId;
        }

        public List<ReadOverListBean> getReadOverList() {
            return ReadOverList;
        }

        public void setReadOverList(List<ReadOverListBean> ReadOverList) {
            this.ReadOverList = ReadOverList;
        }
        public static class ReadOverListBean {
            private String id;
            private String myLessonId;
            private String myLessonName;
            private String markingType;
            private String comment;
            private String readerId;
            private String readerName;
            private String readTime;
            private String imgUrl;

            public String getReadTime() {
                return readTime;
            }

            public void setReadTime(String readTime) {
                this.readTime = readTime;
            }

            public String getReaderName() {
                return readerName;
            }

            public void setReaderName(String readerName) {
                this.readerName = readerName;
            }

            public String getReaderId() {
                return readerId;
            }

            public void setReaderId(String readerId) {
                this.readerId = readerId;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getMarkingType() {
                return markingType;
            }

            public void setMarkingType(String markingType) {
                this.markingType = markingType;
            }

            public String getMyLessonName() {
                return myLessonName;
            }

            public void setMyLessonName(String myLessonName) {
                this.myLessonName = myLessonName;
            }

            public String getMyLessonId() {
                return myLessonId;
            }

            public void setMyLessonId(String myLessonId) {
                this.myLessonId = myLessonId;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }


}
