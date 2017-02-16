package cn.huischool.huixiao.bean;

import java.io.Serializable;
import java.util.ArrayList;

import cn.huischool.huixiao.framework.BaseResponse;

public class AcceNotifiBean extends BaseResponse {

    /**
     *
     */
    private static final long serialVersionUID = -5891004185131166497L;
    /*private int code;
    private String message;*/
    private Results results;
    /*private Object errors;*/

    public static class Results {
        private int elementsCount;
        private int startIndex;
        private int pageSize;
        private int curPage;
        private int pageCount;
        private ArrayList<Elements> elements;
        private SqlQuery sqlQuery;
        private String entityClass;

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

        public ArrayList<Elements> getElements() {
            return elements;
        }

        public void setElements(ArrayList<Elements> elements) {
            this.elements = elements;
        }

        public SqlQuery getSqlQuery() {
            return sqlQuery;
        }

        public void setSqlQuery(SqlQuery sqlQuery) {
            this.sqlQuery = sqlQuery;
        }

        public String getEntityClass() {
            return entityClass;
        }

        public void setEntityClass(String entityClass) {
            this.entityClass = entityClass;
        }
    }

    public static class Elements implements Serializable {
        private static final long serialVersionUID = -1L;
        private String id;
        private String noticeId;
        private String schoolId;
        private String title;
        private String content;
        private String hasSended;
        private String noticeFileId;
        private String noticeFileName = "";
        private String senderId;
        private String sendeeId;
        private String senderName;
        private String hasRead;
        private String sendeeName;
        private String sendTime;
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

        public String getNoticeId() {
            return noticeId;
        }

        public void setNoticeId(String noticeId) {
            this.noticeId = noticeId;
        }

        public String getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(String schoolId) {
            this.schoolId = schoolId;
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

        public String getHasSended() {
            return hasSended;
        }

        public void setHasSended(String hasSended) {
            this.hasSended = hasSended;
        }

        public String getNoticeFileId() {
            return noticeFileId;
        }

        public void setNoticeFileId(String noticeFileId) {
            this.noticeFileId = noticeFileId;
        }

        public String getNoticeFileName() {
            if (noticeFileName == null) {
                noticeFileName = "";
            }
            return noticeFileName;
        }

        public void setNoticeFileName(String noticeFileName) {
            this.noticeFileName = noticeFileName;
        }

        public String getSenderId() {
            return senderId;
        }

        public void setSenderId(String senderId) {
            this.senderId = senderId;
        }

        public String getSendeeId() {
            return sendeeId;
        }

        public void setSendeeId(String sendeeId) {
            this.sendeeId = sendeeId;
        }

        public String getSenderName() {
            return senderName;
        }

        public void setSenderName(String senderName) {
            this.senderName = senderName;
        }

        public String getHasRead() {
            return hasRead;
        }

        public void setHasRead(String hasRead) {
            this.hasRead = hasRead;
        }

        public String getSendeeName() {
            return sendeeName;
        }

        public void setSendeeName(String sendeeName) {
            this.sendeeName = sendeeName;
        }

        public String getSendTime() {
            return sendTime;
        }

        public void setSendTime(String sendTime) {
            this.sendTime = sendTime;
        }
    }

    public static class SqlQuery {
        private Criteria criteria;
        private int skip;
        private int limit;
        private Sort sort;
        private Object groupBy;
        private String criteriaString;
        private String sortString;

        public Criteria getCriteria() {
            return criteria;
        }

        public void setCriteria(Criteria criteria) {
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

        public Sort getSort() {
            return sort;
        }

        public void setSort(Sort sort) {
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
    }

    public static class Criteria {
        private ArrayList<String> params;

        public ArrayList<String> getParams() {
            return params;
        }

        public void setParams(ArrayList<String> params) {
            this.params = params;
        }
    }

    public static class Sort {
        private ArrayList<SortFields> sortFields;

        public ArrayList<SortFields> getSortFields() {
            return sortFields;
        }

        public void setSortFields(ArrayList<SortFields> sortFields) {
            this.sortFields = sortFields;
        }
    }

    public static class Order {
        private String orderType;

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }
    }

    public static class SortFields {
        private String field;
        private Order order;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }
    }


    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }


}
