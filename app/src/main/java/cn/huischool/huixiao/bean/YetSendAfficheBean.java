package cn.huischool.huixiao.bean;

import java.io.Serializable;
import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/6/6.
 */
public class YetSendAfficheBean extends BaseResponse {
    /**
     * elementsCount : 55
     * startIndex : 0
     * pageSize : 3
     * curPage : 1
     * pageCount : 19
     * elements : [{"id":"575166e90cf298fc9721861d","schoolId":"564306c0b26c43a3069cd5ac","schoolName":"城厢小学","title":"城厢小学督查通报","content":"城厢小学督查通报6月3","senderId":"564306c0b26c43a3069cd520","sender":"管理员","createTime":"2016-06-03 19:15:53","hasSended":"是","afficheFileId":"chengxiangxiaoxue/575166e90cf298fc9721861c","afficheFileName":"城厢小学督查通报6月3.doc"},{"id":"574fff630cf298fc972184d6","schoolId":"564306c0b26c43a3069cd5ac","schoolName":"城厢小学","title":"城厢小学督查通报","content":"城厢小学督查通报6月2","senderId":"564306c0b26c43a3069cd520","sender":"管理员","createTime":"2016-06-02 17:41:55","hasSended":"是","afficheFileId":"chengxiangxiaoxue/574fff630cf298fc972184d5","afficheFileName":"城厢小学督查通报6月2.doc"},{"id":"574d5af60cf298fc97218432","schoolId":"564306c0b26c43a3069cd5ac","schoolName":"城厢小学","title":"城厢小学督查通报","content":"城厢小学督查通报5月30","senderId":"564306c0b26c43a3069cd520","sender":"管理员","createTime":"2016-05-31 17:35:50","hasSended":"是","afficheFileId":"chengxiangxiaoxue/574d5af50cf298fc97218431","afficheFileName":"城厢小学督查通报5月30.doc"}]
     * sqlQuery : {"criteria":{"params":["564306c0b26c43a3069cd520"]},"skip":0,"limit":3,"sort":{"sortFields":[{"field":"schoolId,createTime","order":{"orderType":"desc"}}]},"groupBy":null,"criteriaString":"1=1 and senderId = ?","sortString":" order by schoolId,createTime desc"}
     * entityClass : com.dip.action.bean.sys.Affiche
     */
private static final long serialVersionUID = -1L;
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
         * limit : 3
         * sort : {"sortFields":[{"field":"schoolId,createTime","order":{"orderType":"desc"}}]}
         * groupBy : null
         * criteriaString : 1=1 and senderId = ?
         * sortString :  order by schoolId,createTime desc
         */

        private SqlQueryBean sqlQuery;
        private String entityClass;
        /**
         * id : 575166e90cf298fc9721861d
         * schoolId : 564306c0b26c43a3069cd5ac
         * schoolName : 城厢小学
         * title : 城厢小学督查通报
         * content : 城厢小学督查通报6月3
         * senderId : 564306c0b26c43a3069cd520
         * sender : 管理员
         * createTime : 2016-06-03 19:15:53
         * hasSended : 是
         * afficheFileId : chengxiangxiaoxue/575166e90cf298fc9721861c
         * afficheFileName : 城厢小学督查通报6月3.doc
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

        public static class ElementsBean implements Serializable{
            private String id;
            private String schoolId;
            private String schoolName;
            private String title;
            private String content;
            private String senderId;
            private String sender;
            private String createTime;
            private String hasSended;
            private String afficheFileId;
            private String afficheFileName;
            private String htmlFileUrl;

            public String getHtmlFileUrl() {
                return htmlFileUrl;
            }

            public void setHtmlFileUrl(String htmlFileUrl) {
                this.htmlFileUrl = htmlFileUrl;
            }

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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getSenderId() {
                return senderId;
            }

            public void setSenderId(String senderId) {
                this.senderId = senderId;
            }

            public String getSender() {
                return sender;
            }

            public void setSender(String sender) {
                this.sender = sender;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getHasSended() {
                return hasSended;
            }

            public void setHasSended(String hasSended) {
                this.hasSended = hasSended;
            }

            public String getAfficheFileId() {
                return afficheFileId;
            }

            public void setAfficheFileId(String afficheFileId) {
                this.afficheFileId = afficheFileId;
            }

            public String getAfficheFileName() {
                return afficheFileName;
            }

            public void setAfficheFileName(String afficheFileName) {
                this.afficheFileName = afficheFileName;
            }
        }
    }





}
