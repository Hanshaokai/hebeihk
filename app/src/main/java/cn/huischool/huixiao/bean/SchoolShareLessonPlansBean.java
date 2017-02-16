package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/6/21.
 */
public class SchoolShareLessonPlansBean extends BaseResponse {


    /**
     * elementsCount : 91
     * startIndex : 0
     * pageSize : 2
     * curPage : 1
     * pageCount : 46
     * elements : [{"id":"571eb4840cf2f5d636ebb280","schoolId":"564306c0b26c43a3069cd5ac","schoolName":"城厢小学","teacherId":"5646ebf994dfc8dc27283914","teacherName":"于波","gradeId":"56430cbc60c1de3b17083c92","gradeName":"五年级","coursewareAmount":"0","subjectId":"5644762e94dfbc462907796b","subjectName":"体育","lessonName":"第四周","path":"chengxiangxiaoxue/571eb4830cf2f5d636ebb27f","fileName":"体育教案.doc","createTime":"2016-04-26 18:39:48","createUser":"yubo","projectDetId":null,"markingAmount":"0","subjectType":"下册","releaseType":"发布到校内","lessonType":"已提交","lessonDet":"五年级,体育,下册","difOpinionAmount":"0"},{"id":"56de8cd30cf24d82e6159503","schoolId":"564306c0b26c43a3069cd5ac","schoolName":"城厢小学","teacherId":"564306c0b26c43a3069cd520","teacherName":"管理员","gradeId":"56430cbc60c1de3b17083c90","gradeName":"三年级","coursewareAmount":"0","subjectId":"56430ce760c1de3b17083cba","subjectName":"英语","lessonName":"测试","path":"chengxiangxiaoxue/56de8cd20cf24d82e6159502","fileName":"足记APP项目接口文档.docx","createTime":"2016-04-26 11:21:16","createUser":"cxschool","projectDetId":null,"markingAmount":"0","subjectType":"上册","releaseType":"发布到校内","lessonType":"未提交","lessonDet":"三年级,英语,上册","difOpinionAmount":"0"}]
     * sqlQuery : {"criteria":{"params":["564306c0b26c43a3069cd5ac","发布到校内"]},"skip":0,"limit":2,"sort":{"sortFields":[{"field":"schoolId,createTime","order":{"orderType":"desc"}}]},"groupBy":null,"criteriaString":"1=1 and schoolId = ? and ReleaseType = ?","sortString":" order by schoolId,createTime desc"}
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
         * criteria : {"params":["564306c0b26c43a3069cd5ac","发布到校内"]}
         * skip : 0
         * limit : 2
         * sort : {"sortFields":[{"field":"schoolId,createTime","order":{"orderType":"desc"}}]}
         * groupBy : null
         * criteriaString : 1=1 and schoolId = ? and ReleaseType = ?
         * sortString :  order by schoolId,createTime desc
         */

        private SqlQueryBean sqlQuery;
        private String entityClass;
        /**
         * id : 571eb4840cf2f5d636ebb280
         * schoolId : 564306c0b26c43a3069cd5ac
         * schoolName : 城厢小学
         * teacherId : 5646ebf994dfc8dc27283914
         * teacherName : 于波
         * gradeId : 56430cbc60c1de3b17083c92
         * gradeName : 五年级
         * coursewareAmount : 0
         * subjectId : 5644762e94dfbc462907796b
         * subjectName : 体育
         * lessonName : 第四周
         * path : chengxiangxiaoxue/571eb4830cf2f5d636ebb27f
         * fileName : 体育教案.doc
         * createTime : 2016-04-26 18:39:48
         * createUser : yubo
         * projectDetId : null
         * markingAmount : 0
         * subjectType : 下册
         * releaseType : 发布到校内
         * lessonType : 已提交
         * lessonDet : 五年级,体育,下册
         * difOpinionAmount : 0
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
            private String gradeId;
            private String gradeName;
            private String coursewareAmount;
            private String subjectId;
            private String subjectName;
            private String lessonName;
            private String path;
            private String fileName;
            private String createTime;
            private String createUser;
            private Object projectDetId;
            private String markingAmount;
            private String subjectType;
            private String releaseType;
            private String lessonType;
            private String lessonDet;
            private String difOpinionAmount;

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

            public String getCoursewareAmount() {
                return coursewareAmount;
            }

            public void setCoursewareAmount(String coursewareAmount) {
                this.coursewareAmount = coursewareAmount;
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
        }
    }
}
