package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/8/12.
 */
public class MyStudyNotesBean extends BaseResponse {


    /**
     * elementsCount : 1
     * startIndex : 0
     * pageSize : 2
     * curPage : 1
     * pageCount : 1
     * elements : [{"id":"57a198bb3ca974c72228b42b","schoolId":"564306c0b26c43a3069cd5ad","schoolName":"城厢小学","teacherId":"577f4f2963038347787582ad","teacherName":"王静","studyTime":"2016-08-03","studyAddress":"阜平","studyTitle":"学习啊哈哈","studySource":"河北","learnNotes":"教学内容ddh","learnLesson":"教学内容dd教学内容dd教学内容dd教学内容dd教学内容dd教学内容dd教学内","createTime":"2016-08-03 15:09:47","markingAmount":"2","submitStatus":"1","browseNames":"王静,王占龙,王者书,","difOpinionAmount":"0"}]
     * sqlQuery : {"criteria":{"params":["564306c0b26c43a3069cd520"]},"skip":0,"limit":2,"sort":{"sortFields":[{"field":"schoolId,createTime","order":{"orderType":"desc"}}]},"groupBy":null,"criteriaString":"1=1 and teacherId = ?","sortString":" order by schoolId,createTime desc"}
     * entityClass : com.dip.action.bean.sys.StudyNotes
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
         * criteria : {"params":["564306c0b26c43a3069cd520"]}
         * skip : 0
         * limit : 2
         * sort : {"sortFields":[{"field":"schoolId,createTime","order":{"orderType":"desc"}}]}
         * groupBy : null
         * criteriaString : 1=1 and teacherId = ?
         * sortString :  order by schoolId,createTime desc
         */

        private SqlQueryBean sqlQuery;
        private String entityClass;
        /**
         * id : 57a198bb3ca974c72228b42b
         * schoolId : 564306c0b26c43a3069cd5ad
         * schoolName : 城厢小学
         * teacherId : 577f4f2963038347787582ad
         * teacherName : 王静
         * studyTime : 2016-08-03
         * studyAddress : 阜平
         * studyTitle : 学习啊哈哈
         * studySource : 河北
         * learnNotes : 教学内容ddh
         * learnLesson : 教学内容dd教学内容dd教学内容dd教学内容dd教学内容dd教学内容dd教学内
         * createTime : 2016-08-03 15:09:47
         * markingAmount : 2
         * submitStatus : 1
         * browseNames : 王静,王占龙,王者书,
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
            private String studyTime;
            private String studyAddress;
            private String studyTitle;
            private String studySource;
            private String learnNotes;
            private String learnLesson;
            private String createTime;
            private String markingAmount;
            private String submitStatus;
            private String browseNames;
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

            public String getStudyTime() {
                return studyTime;
            }

            public void setStudyTime(String studyTime) {
                this.studyTime = studyTime;
            }

            public String getStudyAddress() {
                return studyAddress;
            }

            public void setStudyAddress(String studyAddress) {
                this.studyAddress = studyAddress;
            }

            public String getStudyTitle() {
                return studyTitle;
            }

            public void setStudyTitle(String studyTitle) {
                this.studyTitle = studyTitle;
            }

            public String getStudySource() {
                return studySource;
            }

            public void setStudySource(String studySource) {
                this.studySource = studySource;
            }

            public String getLearnNotes() {
                return learnNotes;
            }

            public void setLearnNotes(String learnNotes) {
                this.learnNotes = learnNotes;
            }

            public String getLearnLesson() {
                return learnLesson;
            }

            public void setLearnLesson(String learnLesson) {
                this.learnLesson = learnLesson;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getMarkingAmount() {
                return markingAmount;
            }

            public void setMarkingAmount(String markingAmount) {
                this.markingAmount = markingAmount;
            }

            public String getSubmitStatus() {
                return submitStatus;
            }

            public void setSubmitStatus(String submitStatus) {
                this.submitStatus = submitStatus;
            }

            public String getBrowseNames() {
                return browseNames;
            }

            public void setBrowseNames(String browseNames) {
                this.browseNames = browseNames;
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
