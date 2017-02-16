package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/7/15.
 */
public class MyCourseWareBean extends BaseResponse {


    /**
     * elementsCount : 3
     * startIndex : 0
     * pageSize : 3
     * curPage : 1
     * pageCount : 1
     * elements : [{"id":"56ac7ee60cf240e6a51a2c7b","schoolId":"564306c0b26c43a3069cd5ac","schoolName":"城厢小学","teacherId":"564306c0b26c43a3069cd520","teacherName":"城厢管理员","lessonId":"56a9c8a95877fc75acc92ca8","lessonName":"新建教案测试","gradeId":"56430cbc60c1de3b17083c90","gradeName":"三年级","subjectId":"564475ed94dfbc4629077964","subjectName":"综合实践","coursewareName":"测试关联课件","coursewareFileId":"chengxiangxiaoxue/56ac7ee60cf240e6a51a2c7a","coursewareFileName":"测试.doc","createTime":"2016-01-31 18:01:21","createUser":"管理员","projectDetId":null,"markingAmount":"20","subjectType":"下册","releaseType":"发布到校内","coursewareType":"未提交","coursewareDet":"三年级,综合实践,下册","difOpinionAmount":"6","htmlFileUrl":null}]
     * sqlQuery : {"criteria":{"params":["577f537c6303834778758391"]},"skip":0,"limit":8,"sort":{"sortFields":[{"field":"schoolId,createTime","order":{"orderType":"desc"}}]},"groupBy":null,"criteriaString":"1=1 and teacherId = ?","sortString":" order by schoolId,createTime desc"}
     * entityClass : com.dip.action.bean.view.VwCoursewareInfo
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
         * criteria : {"params":["577f537c6303834778758391"]}
         * skip : 0
         * limit : 8
         * sort : {"sortFields":[{"field":"schoolId,createTime","order":{"orderType":"desc"}}]}
         * groupBy : null
         * criteriaString : 1=1 and teacherId = ?
         * sortString :  order by schoolId,createTime desc
         */

        private SqlQueryBean sqlQuery;
        private String entityClass;
        /**
         * id : 56ac7ee60cf240e6a51a2c7b
         * schoolId : 564306c0b26c43a3069cd5ac
         * schoolName : 城厢小学
         * teacherId : 564306c0b26c43a3069cd520
         * teacherName : 城厢管理员
         * lessonId : 56a9c8a95877fc75acc92ca8
         * lessonName : 新建教案测试
         * gradeId : 56430cbc60c1de3b17083c90
         * gradeName : 三年级
         * subjectId : 564475ed94dfbc4629077964
         * subjectName : 综合实践
         * coursewareName : 测试关联课件
         * coursewareFileId : chengxiangxiaoxue/56ac7ee60cf240e6a51a2c7a
         * coursewareFileName : 测试.doc
         * createTime : 2016-01-31 18:01:21
         * createUser : 管理员
         * projectDetId : null
         * markingAmount : 20
         * subjectType : 下册
         * releaseType : 发布到校内
         * coursewareType : 未提交
         * coursewareDet : 三年级,综合实践,下册
         * difOpinionAmount : 6
         * htmlFileUrl : null
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
            private String schoolName;
            private String teacherId;
            private String teacherName;
            private String lessonId;
            private String lessonName;
            private String gradeId;
            private String gradeName;
            private String subjectId;
            private String subjectName;
            private String coursewareName;
            private String coursewareFileId;
            private String coursewareFileName;
            private String createTime;
            private String createUser;
            private Object projectDetId;
            private String markingAmount;
            private String subjectType;
            private String releaseType;
            private String coursewareType;
            private String coursewareDet;
            private String difOpinionAmount;
            private Object htmlFileUrl;

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

            public String getSchoolName() {
                return schoolName;
            }

            public void setSchoolName(String schoolName) {
                this.schoolName = schoolName;
            }

            public String getTeacherId() {
                return teacherId;
            }

            public void setTeacherId(String teacherId) {
                this.teacherId = teacherId;
            }

            public String getTeacherName() {
                return teacherName;
            }

            public void setTeacherName(String teacherName) {
                this.teacherName = teacherName;
            }

            public String getLessonId() {
                return lessonId;
            }

            public void setLessonId(String lessonId) {
                this.lessonId = lessonId;
            }

            public String getLessonName() {
                return lessonName;
            }

            public void setLessonName(String lessonName) {
                this.lessonName = lessonName;
            }

            public String getGradeId() {
                return gradeId;
            }

            public void setGradeId(String gradeId) {
                this.gradeId = gradeId;
            }

            public String getGradeName() {
                return gradeName;
            }

            public void setGradeName(String gradeName) {
                this.gradeName = gradeName;
            }

            public String getSubjectId() {
                return subjectId;
            }

            public void setSubjectId(String subjectId) {
                this.subjectId = subjectId;
            }

            public String getSubjectName() {
                return subjectName;
            }

            public void setSubjectName(String subjectName) {
                this.subjectName = subjectName;
            }

            public String getCoursewareName() {
                return coursewareName;
            }

            public void setCoursewareName(String coursewareName) {
                this.coursewareName = coursewareName;
            }

            public String getCoursewareFileId() {
                return coursewareFileId;
            }

            public void setCoursewareFileId(String coursewareFileId) {
                this.coursewareFileId = coursewareFileId;
            }

            public String getCoursewareFileName() {
                return coursewareFileName;
            }

            public void setCoursewareFileName(String coursewareFileName) {
                this.coursewareFileName = coursewareFileName;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
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

            public String getMarkingAmount() {
                return markingAmount;
            }

            public void setMarkingAmount(String markingAmount) {
                this.markingAmount = markingAmount;
            }

            public String getSubjectType() {
                return subjectType;
            }

            public void setSubjectType(String subjectType) {
                this.subjectType = subjectType;
            }

            public String getReleaseType() {
                return releaseType;
            }

            public void setReleaseType(String releaseType) {
                this.releaseType = releaseType;
            }

            public String getCoursewareType() {
                return coursewareType;
            }

            public void setCoursewareType(String coursewareType) {
                this.coursewareType = coursewareType;
            }

            public String getCoursewareDet() {
                return coursewareDet;
            }

            public void setCoursewareDet(String coursewareDet) {
                this.coursewareDet = coursewareDet;
            }

            public String getDifOpinionAmount() {
                return difOpinionAmount;
            }

            public void setDifOpinionAmount(String difOpinionAmount) {
                this.difOpinionAmount = difOpinionAmount;
            }

            public Object getHtmlFileUrl() {
                return htmlFileUrl;
            }

            public void setHtmlFileUrl(Object htmlFileUrl) {
                this.htmlFileUrl = htmlFileUrl;
            }
        }
    }
}
