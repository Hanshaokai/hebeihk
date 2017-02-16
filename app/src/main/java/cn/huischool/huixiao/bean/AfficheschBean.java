package cn.huischool.huixiao.bean;

import java.io.Serializable;
import java.util.ArrayList;

import cn.huischool.huixiao.framework.BaseResponse;

public class AfficheschBean  extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6589640550612256640L;
	
	private Results results;
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
		private String id;
		private String afficheId;
		private String schoolId;
		private String schoolName;
		private String title;
		private String content;
		private Object afficheFileId;
		private Object afficheFileName;
		private String senderId;
		private String senderName;
		private String receiverId;
		private String receiverName;
		private String sendTime;
		private String hasRead;
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

		public String getAfficheId() {
			return afficheId;
		}

		public void setAfficheId(String afficheId) {
			this.afficheId = afficheId;
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

		public Object getAfficheFileId() {
			return afficheFileId;
		}

		public void setAfficheFileId(Object afficheFileId) {
			this.afficheFileId = afficheFileId;
		}

		public Object getAfficheFileName() {
			if (afficheFileName==null) {
				afficheFileName="";
			}
			return afficheFileName;
		}

		public void setAfficheFileName(Object afficheFileName) {
			this.afficheFileName = afficheFileName;
		}

		public String getSenderId() {
			return senderId;
		}

		public void setSenderId(String senderId) {
			this.senderId = senderId;
		}

		public String getSenderName() {
			return senderName;
		}

		public void setSenderName(String senderName) {
			this.senderName = senderName;
		}

		public String getReceiverId() {
			return receiverId;
		}

		public void setReceiverId(String receiverId) {
			this.receiverId = receiverId;
		}

		public String getReceiverName() {
			return receiverName;
		}

		public void setReceiverName(String receiverName) {
			this.receiverName = receiverName;
		}

		public String getSendTime() {
			return sendTime;
		}

		public void setSendTime(String sendTime) {
			this.sendTime = sendTime;
		}

		public String getHasRead() {
			return hasRead;
		}

		public void setHasRead(String hasRead) {
			this.hasRead = hasRead;
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
