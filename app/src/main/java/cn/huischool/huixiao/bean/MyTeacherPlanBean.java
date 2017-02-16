package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/7/13.
 */
public class MyTeacherPlanBean extends BaseResponse {


    /**
     * elementsCount : 2
     * startIndex : 0
     * pageSize : 3
     * curPage : 1
     * pageCount : 1
     * elements : [{"id":"577e33270cf241a7a3dc77c2","schoolId":"564306c0b26c43a3069cd5ac","teacherId":"5646ebf194dfc8dc2728389a","gradeId":"56430cbc60c1de3b17083c93","subjectId":"564475ed94dfbc4629077964","lessonName":"tt","path":"chengxiangxiaoxue_test/577e33250cf241a7a3dc77c0","fileName":"〔2015〕信息系统集成资质等级评定条件(暂行).docx","createTime":"2016-07-07 18:47:03","coursewareAmount":"0","createUser":"wangzhanlong","projectDetId":null,"subjectType":"0","markingAmount":"0","releaseType":"0","lessonType":"0","lessonDet":"六年级,综合实践,上册","difOpinionAmount":"0","htmlFileUrl":"file-teacher-lessons.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/577e33250cf241a7a3dc77c0/577e33260cf241a7a3dc77c1"}]
     * sqlQuery : {"criteria":{"params":["0","564306c0b26c43a3069cd520"]},"skip":0,"limit":3,"sort":{"sortFields":[{"field":"schoolId,createTime","order":{"orderType":"desc"}}]},"groupBy":null,"criteriaString":"1=1 and markingAmount = ? and teacherId = ?","sortString":" order by schoolId,createTime desc"}
     * entityClass : com.dip.action.bean.view.VwLessonInfo
     */

    private ResultsBean results;

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public static class ResultsBean {

        private int elementsCount;
        private int startIndex;
        private int pageSize;
        private int curPage;
        private int pageCount;
        /**
         * criteria : {"params":["0","564306c0b26c43a3069cd520"]}
         * skip : 0
         * limit : 3
         * sort : {"sortFields":[{"field":"schoolId,createTime","order":{"orderType":"desc"}}]}
         * groupBy : null
         * criteriaString : 1=1 and markingAmount = ? and teacherId = ?
         * sortString :  order by schoolId,createTime desc
         */

        private SqlQueryBean sqlQuery;
        private String entityClass;
        /**
         * id : 577e33270cf241a7a3dc77c2
         * schoolId : 564306c0b26c43a3069cd5ac
         * teacherId : 5646ebf194dfc8dc2728389a
         * gradeId : 56430cbc60c1de3b17083c93
         * subjectId : 564475ed94dfbc4629077964
         * lessonName : tt
         * path : chengxiangxiaoxue_test/577e33250cf241a7a3dc77c0
         * fileName : 〔2015〕信息系统集成资质等级评定条件(暂行).docx
         * createTime : 2016-07-07 18:47:03
         * coursewareAmount : 0
         * createUser : wangzhanlong
         * projectDetId : null
         * subjectType : 0
         * markingAmount : 0
         * releaseType : 0
         * lessonType : 0
         * lessonDet : 六年级,综合实践,上册
         * difOpinionAmount : 0
         * htmlFileUrl : file-teacher-lessons.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/577e33250cf241a7a3dc77c0/577e33260cf241a7a3dc77c1
         */

        private List<ElementsBean> elements;

        public int getElementsCount() {
            return elementsCount;
        }

        public void setElementsCount(int elementsCount) {
            this.elementsCount = elementsCount;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public SqlQueryBean getSqlQuery() {
            return sqlQuery;
        }

        public void setSqlQuery(SqlQueryBean sqlQuery) {
            this.sqlQuery = sqlQuery;
        }

        public String getEntityClass() {
            return entityClass;
        }

        public void setEntityClass(String entityClass) {
            this.entityClass = entityClass;
        }

        public List<ElementsBean> getElements() {
            return elements;
        }

        public void setElements(List<ElementsBean> elements) {
            this.elements = elements;
        }

        public static class SqlQueryBean {
            private CriteriaBean criteria;
            private int skip;
            private int limit;
            private SortBean sort;
            private Object groupBy;
            private String criteriaString;
            private String sortString;

            public CriteriaBean getCriteria() {
                return criteria;
            }

            public void setCriteria(CriteriaBean criteria) {
                this.criteria = criteria;
            }

            public int getSkip() {
                return skip;
            }

            public void setSkip(int skip) {
                this.skip = skip;
            }

            public int getLimit() {
                return limit;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public SortBean getSort() {
                return sort;
            }

            public void setSort(SortBean sort) {
                this.sort = sort;
            }

            public Object getGroupBy() {
                return groupBy;
            }

            public void setGroupBy(Object groupBy) {
                this.groupBy = groupBy;
            }

            public String getCriteriaString() {
                return criteriaString;
            }

            public void setCriteriaString(String criteriaString) {
                this.criteriaString = criteriaString;
            }

            public String getSortString() {
                return sortString;
            }

            public void setSortString(String sortString) {
                this.sortString = sortString;
            }

            public static class CriteriaBean {
                private List<String> params;

                public List<String> getParams() {
                    return params;
                }

                public void setParams(List<String> params) {
                    this.params = params;
                }
            }

            public static class SortBean {
                /**
                 * field : schoolId,createTime
                 * order : {"orderType":"desc"}
                 */

                private List<SortFieldsBean> sortFields;

                public List<SortFieldsBean> getSortFields() {
                    return sortFields;
                }

                public void setSortFields(List<SortFieldsBean> sortFields) {
                    this.sortFields = sortFields;
                }

                public static class SortFieldsBean {
                    private String field;
                    /**
                     * orderType : desc
                     */

                    private OrderBean order;

                    public String getField() {
                        return field;
                    }

                    public void setField(String field) {
                        this.field = field;
                    }

                    public OrderBean getOrder() {
                        return order;
                    }

                    public void setOrder(OrderBean order) {
                        this.order = order;
                    }

                    public static class OrderBean {
                        private String orderType;

                        public String getOrderType() {
                            return orderType;
                        }

                        public void setOrderType(String orderType) {
                            this.orderType = orderType;
                        }
                    }
                }
            }
        }

        public static class ElementsBean {
            private String id;
            private String schoolId;
            private String teacherId;
            private String gradeId;
            private String subjectId;
            private String lessonName;
            private String path;
            private String fileName;
            private String createTime;
            private String coursewareAmount;
            private String createUser;
            private Object projectDetId;
            private String subjectType;
            private String markingAmount;
            private String releaseType;
            private String lessonType;
            private String lessonDet;
            private String difOpinionAmount;
            private String htmlFileUrl;

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

            public String getTeacherId() {
                return teacherId;
            }

            public void setTeacherId(String teacherId) {
                this.teacherId = teacherId;
            }

            public String getGradeId() {
                return gradeId;
            }

            public void setGradeId(String gradeId) {
                this.gradeId = gradeId;
            }

            public String getSubjectId() {
                return subjectId;
            }

            public void setSubjectId(String subjectId) {
                this.subjectId = subjectId;
            }

            public String getLessonName() {
                return lessonName;
            }

            public void setLessonName(String lessonName) {
                this.lessonName = lessonName;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCoursewareAmount() {
                return coursewareAmount;
            }

            public void setCoursewareAmount(String coursewareAmount) {
                this.coursewareAmount = coursewareAmount;
            }

            public String getCreateUser() {
                return createUser;
            }

            public void setCreateUser(String createUser) {
                this.createUser = createUser;
            }

            public Object getProjectDetId() {
                return projectDetId;
            }

            public void setProjectDetId(Object projectDetId) {
                this.projectDetId = projectDetId;
            }

            public String getSubjectType() {
                return subjectType;
            }

            public void setSubjectType(String subjectType) {
                this.subjectType = subjectType;
            }

            public String getMarkingAmount() {
                return markingAmount;
            }

            public void setMarkingAmount(String markingAmount) {
                this.markingAmount = markingAmount;
            }

            public String getReleaseType() {
                return releaseType;
            }

            public void setReleaseType(String releaseType) {
                this.releaseType = releaseType;
            }

            public String getLessonType() {
                return lessonType;
            }

            public void setLessonType(String lessonType) {
                this.lessonType = lessonType;
            }

            public String getLessonDet() {
                return lessonDet;
            }

            public void setLessonDet(String lessonDet) {
                this.lessonDet = lessonDet;
            }

            public String getDifOpinionAmount() {
                return difOpinionAmount;
            }

            public void setDifOpinionAmount(String difOpinionAmount) {
                this.difOpinionAmount = difOpinionAmount;
            }

            public String getHtmlFileUrl() {
                return htmlFileUrl;
            }

            public void setHtmlFileUrl(String htmlFileUrl) {
                this.htmlFileUrl = htmlFileUrl;
            }
        }
    }
}
