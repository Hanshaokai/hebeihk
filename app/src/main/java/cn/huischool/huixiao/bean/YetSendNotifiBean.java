package cn.huischool.huixiao.bean;

import java.io.Serializable;
import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/5/20.
 */
public class YetSendNotifiBean extends BaseResponse {

    /**
     * elementsCount : 23
     * startIndex : 0
     * pageSize : 8
     * curPage : 1
     * pageCount : 3
     * elements : [{"id":"5770da4a6303850c07b37afb","title":"测试","content":"测试测试","noticeFileId":"","noticeFileName":"","senderId":"564306c0b26c43a3069cd520","senderName":"管理员1","sendeeType":"oneLeader","sendeeTypeDet":"单个领导","typeIdsDet":null,"sendeeIds":"5646ebf194dfc8dc2728389a","sendeeNames":"王占龙","createTime":"2016-06-27 15:48:26","sendTime":"2016-06-27 15:48:26","schoolId":"564306c0b26c43a3069cd5ac","schoolName":"城厢小学","hasSended":"1","typeIds":"","enable":"0"},{"id":"5763af680cf2e6d43a83bf4d","title":"ddd","content":"ggg","noticeFileId":"","noticeFileName":"","senderId":"564306c0b26c43a3069cd520","senderName":"管理员1","sendeeType":"oneTeacher","sendeeTypeDet":"单个教师","typeIdsDet":"三年级","sendeeIds":"5646ebf894dfc8dc27283900","sendeeNames":"张国会","createTime":"2016-06-17 16:06:00","sendTime":"2016-06-17 16:06:00","schoolId":"564306c0b26c43a3069cd5ac","schoolName":"城厢小学","hasSended":"1","typeIds":"56430cbc60c1de3b17083c90","enable":"0"},{"id":"5763adeb0cf2e6d43a83bf4b","title":"hshs","content":"hshs","noticeFileId":"","noticeFileName":"","senderId":"564306c0b26c43a3069cd520","senderName":"管理员1","sendeeType":"oneTeacher","sendeeTypeDet":"单个教师","typeIdsDet":"二年级","sendeeIds":"5646ebf994dfc8dc27283913","sendeeNames":"刘明玉","createTime":"2016-06-17 15:59:38","sendTime":"2016-06-17 15:59:38","schoolId":"564306c0b26c43a3069cd5ac","schoolName":"城厢小学","hasSended":"1","typeIds":"56430cbc60c1de3b17083c8f","enable":"0"},{"id":"574e49980cf2687466669651","title":"管理员 发送通知","content":"管理员 发送通知","noticeFileId":"","noticeFileName":"","senderId":"564306c0b26c43a3069cd520","senderName":"管理员1","sendeeType":"all","sendeeTypeDet":"所有教职工","typeIdsDet":null,"sendeeIds":"564306c0b26c430126912345,564306c0b26c43a3069cd520,5646ebf194dfc8dc2728389a,5646ebf194dfc8dc2728389b,5646ebf294dfc8dc2728389c,5646ebf294dfc8dc2728389d,5646ebf294dfc8dc2728389e,5646ebf294dfc8dc2728389f,5646ebf294dfc8dc272838a0,5646ebf294dfc8dc272838a1,5646ebf294dfc8dc272838a2,5646ebf294dfc8dc272838a3,5646ebf294dfc8dc272838a4,5646ebf294dfc8dc272838a5,5646ebf294dfc8dc272838a6,5646ebf294dfc8dc272838a7,5646ebf294dfc8dc272838a8,5646ebf294dfc8dc272838a9,5646ebf294dfc8dc272838ab,5646ebf294dfc8dc272838ac,5646ebf394dfc8dc272838ad,5646ebf394dfc8dc272838ae,5646ebf394dfc8dc272838af,5646ebf394dfc8dc272838b0,5646ebf394dfc8dc272838b1,5646ebf394dfc8dc272838b2,5646ebf394dfc8dc272838b3,5646ebf394dfc8dc272838b4,5646ebf394dfc8dc272838b6,5646ebf394dfc8dc272838b7,5646ebf394dfc8dc272838b8,5646ebf394dfc8dc272838b9,5646ebf394dfc8dc272838ba,5646ebf394dfc8dc272838bb,5646ebf394dfc8dc272838bc,5646ebf394dfc8dc272838bd,5646ebf494dfc8dc272838be,5646ebf494dfc8dc272838bf,5646ebf494dfc8dc272838c0,5646ebf494dfc8dc272838c1,5646ebf494dfc8dc272838c3,5646ebf494dfc8dc272838c4,5646ebf494dfc8dc272838c5,5646ebf494dfc8dc272838c6,5646ebf494dfc8dc272838c7,5646ebf494dfc8dc272838c8,5646ebf494dfc8dc272838ca,5646ebf494dfc8dc272838cb,5646ebf494dfc8dc272838cc,5646ebf494dfc8dc272838cd,5646ebf494dfc8dc272838ce,5646ebf594dfc8dc272838cf,5646ebf594dfc8dc272838d0,5646ebf594dfc8dc272838d1,5646ebf594dfc8dc272838d2,5646ebf594dfc8dc272838d3,5646ebf594dfc8dc272838d4,5646ebf594dfc8dc272838d5,5646ebf594dfc8dc272838d6,5646ebf594dfc8dc272838d7,5646ebf594dfc8dc272838d8,5646ebf594dfc8dc272838d9,5646ebf594dfc8dc272838da,5646ebf594dfc8dc272838db,5646ebf594dfc8dc272838dc,5646ebf594dfc8dc272838dd,5646ebf594dfc8dc272838de,5646ebf694dfc8dc272838df,5646ebf694dfc8dc272838e0,5646ebf694dfc8dc272838e1,5646ebf694dfc8dc272838e2,5646ebf694dfc8dc272838e3,5646ebf694dfc8dc272838e4,5646ebf694dfc8dc272838e5,5646ebf694dfc8dc272838e6,5646ebf694dfc8dc272838e7,5646ebf694dfc8dc272838e8,5646ebf694dfc8dc272838e9,5646ebf694dfc8dc272838eb,5646ebf694dfc8dc272838ec,5646ebf694dfc8dc272838ed,5646ebf694dfc8dc272838ee,5646ebf694dfc8dc272838ef,5646ebf794dfc8dc272838f0,5646ebf794dfc8dc272838f1,5646ebf794dfc8dc272838f2,5646ebf794dfc8dc272838f3,5646ebf794dfc8dc272838f4,5646ebf794dfc8dc272838f5,5646ebf794dfc8dc272838f6,5646ebf794dfc8dc272838f8,5646ebf794dfc8dc272838f9,5646ebf794dfc8dc272838fa,5646ebf794dfc8dc272838fb,5646ebf794dfc8dc272838fc,5646ebf794dfc8dc272838fd,5646ebf794dfc8dc272838fe,5646ebf794dfc8dc272838ff,5646ebf894dfc8dc27283900,5646ebf894dfc8dc27283901,5646ebf894dfc8dc27283902,5646ebf894dfc8dc27283903,5646ebf894dfc8dc27283904,5646ebf894dfc8dc27283905,5646ebf894dfc8dc27283906,5646ebf894dfc8dc27283907,5646ebf894dfc8dc27283908,5646ebf894dfc8dc27283909,5646ebf894dfc8dc2728390a,5646ebf894dfc8dc2728390b,5646ebf894dfc8dc2728390c,5646ebf894dfc8dc2728390d,5646ebf894dfc8dc2728390e,5646ebf894dfc8dc2728390f,5646ebf894dfc8dc27283910,5646ebf894dfc8dc27283911,5646ebf994dfc8dc27283912,5646ebf994dfc8dc27283913,5646ebf994dfc8dc27283914,5646ebf994dfc8dc27283915,5646ebf994dfc8dc27283916,5646ebf994dfc8dc27283917,5646ebf994dfc8dc27283918,5646ebf994dfc8dc27283919,5646ebf994dfc8dc2728391a,5646ebf994dfc8dc2728391b,5646ebf994dfc8dc2728391c,5646ebf994dfc8dc2728391d,5646ebf994dfc8dc2728391e,5646ebf994dfc8dc2728391f,5646ebf994dfc8dc27283921,5646ebf994dfc8dc27283922,5646ebfa94dfc8dc27283923,5646ebfa94dfc8dc27283924,5646ebfa94dfc8dc27283925,5646ebfa94dfc8dc27283926,5646ebfa94dfc8dc27283927,5646ebfa94dfc8dc27283928,5646ebfa94dfc8dc27283929,5646ebfa94dfc8dc2728392a,5646ebfa94dfc8dc2728392b,5646ebfa94dfc8dc2728392c,5646ebfa94dfc8dc2728392d,5646ebfa94dfc8dc2728392e,5646ebfa94dfc8dc2728392f,56907a500cf2c3b0d1ecfae8,56907d070cf2c3b0d1ecfaf6,56907e570cf2c3b0d1ecfafb,56971aaf0cf2b0b0e0603f6b,56975db50cf2409a85c236a1,56d67d600cf204f678f7d9a5,56d8e9b90cf2ae53b2d2654a,56d8eb800cf2ae53b2d2654c,56dd19a80cf25883342a4a7d,56e21f2f0cf20714563966bc,56e605780cf20714563969da,56f106cf0cf274e579d0f2ad,56f1072b0cf274e579d0f2af,56f1ee880cf274e579d0f2dc,56f4a2a50cf274e579d0f5da","sendeeNames":"本校所有教职工","createTime":"2016-06-01 10:34:00","sendTime":"2016-06-01 10:34:00","schoolId":"564306c0b26c43a3069cd5ac","schoolName":"城厢小学","hasSended":"1","typeIds":"","enable":"0"},{"id":"574d4c4a0cf2687466668e9b","title":"测试预览文件2","content":"测试预览文件2","noticeFileId":"chengxiangxiaoxue/574d4c490cf2687466668e9a","noticeFileName":"chengxiangxiaoxue_测试专用大文档.doc","senderId":"564306c0b26c43a3069cd520","senderName":"管理员1","sendeeType":"oneLeader","sendeeTypeDet":"单个领导","typeIdsDet":null,"sendeeIds":"5646ebf194dfc8dc2728389a","sendeeNames":"王占龙","createTime":"2016-05-31 16:33:14","sendTime":"2016-05-31 16:33:14","schoolId":"564306c0b26c43a3069cd5ac","schoolName":"城厢小学","hasSended":"1","typeIds":"","enable":"0"},{"id":"574d33b60cf2687466668e98","title":"测试推送2","content":"测试推送2","noticeFileId":"","noticeFileName":"","senderId":"564306c0b26c43a3069cd520","senderName":"管理员1","sendeeType":"oneLeader","sendeeTypeDet":"单个领导","typeIdsDet":null,"sendeeIds":"5646ebf194dfc8dc2728389a","sendeeNames":"王占龙","createTime":"2016-05-31 14:48:22","sendTime":"2016-05-31 14:48:22","schoolId":"564306c0b26c43a3069cd5ac","schoolName":"城厢小学","hasSended":"1","typeIds":"","enable":"0"},{"id":"574d33760cf2687466668e96","title":"测试推送1","content":"测试推送1","noticeFileId":"","noticeFileName":"","senderId":"564306c0b26c43a3069cd520","senderName":"管理员1","sendeeType":"oneLeader","sendeeTypeDet":"单个领导","typeIdsDet":null,"sendeeIds":"5646ebf194dfc8dc2728389a","sendeeNames":"王占龙","createTime":"2016-05-31 14:47:18","sendTime":"2016-05-31 14:47:18","schoolId":"564306c0b26c43a3069cd5ac","schoolName":"城厢小学","hasSended":"1","typeIds":"","enable":"0"},{"id":"574d30ce0cf2687466668e94","title":"测试推送","content":"测试推送","noticeFileId":"","noticeFileName":"","senderId":"564306c0b26c43a3069cd520","senderName":"管理员1","sendeeType":"oneLeader","sendeeTypeDet":"单个领导","typeIdsDet":null,"sendeeIds":"5646ebf194dfc8dc2728389a","sendeeNames":"王占龙","createTime":"2016-05-31 14:35:58","sendTime":"2016-05-31 14:35:58","schoolId":"564306c0b26c43a3069cd5ac","schoolName":"城厢小学","hasSended":"1","typeIds":"","enable":"0"}]
     * sqlQuery : {"criteria":{"params":["1","564306c0b26c43a3069cd520"]},"skip":0,"limit":8,"sort":{"sortFields":[{"field":"sendTime","order":{"orderType":"desc"}}]},"groupBy":null,"criteriaString":"1=1 and hasSended = ? and senderId = ?","sortString":" order by sendTime desc"}
     * entityClass : com.dip.action.bean.view.VwNoticeInfo
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
         * criteria : {"params":["1","564306c0b26c43a3069cd520"]}
         * skip : 0
         * limit : 8
         * sort : {"sortFields":[{"field":"sendTime","order":{"orderType":"desc"}}]}
         * groupBy : null
         * criteriaString : 1=1 and hasSended = ? and senderId = ?
         * sortString :  order by sendTime desc
         */

        private SqlQueryBean sqlQuery;
        private String entityClass;
        /**
         * id : 5770da4a6303850c07b37afb
         * title : 测试
         * content : 测试测试
         * noticeFileId :
         * noticeFileName :
         * senderId : 564306c0b26c43a3069cd520
         * senderName : 管理员1
         * sendeeType : oneLeader
         * sendeeTypeDet : 单个领导
         * typeIdsDet : null
         * sendeeIds : 5646ebf194dfc8dc2728389a
         * sendeeNames : 王占龙
         * createTime : 2016-06-27 15:48:26
         * sendTime : 2016-06-27 15:48:26
         * schoolId : 564306c0b26c43a3069cd5ac
         * schoolName : 城厢小学
         * hasSended : 1
         * typeIds :
         * enable : 0
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
                 * field : sendTime
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

        public static class ElementsBean implements Serializable {
            private String id;
            private String title;
            private String content;
            private String noticeFileId;
            private String noticeFileName;
            private String senderId;
            private String senderName;
            private String sendeeType;
            private String sendeeTypeDet;
            private Object typeIdsDet;
            private String sendeeIds;
            private String sendeeNames;
            private String createTime;
            private String sendTime;
            private String schoolId;
            private String schoolName;
            private String hasSended;
            private String typeIds;
            private String enable;
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

            public String getNoticeFileId() {
                return noticeFileId;
            }

            public void setNoticeFileId(String noticeFileId) {
                this.noticeFileId = noticeFileId;
            }

            public String getNoticeFileName() {
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

            public String getSenderName() {
                return senderName;
            }

            public void setSenderName(String senderName) {
                this.senderName = senderName;
            }

            public String getSendeeType() {
                return sendeeType;
            }

            public void setSendeeType(String sendeeType) {
                this.sendeeType = sendeeType;
            }

            public String getSendeeTypeDet() {
                return sendeeTypeDet;
            }

            public void setSendeeTypeDet(String sendeeTypeDet) {
                this.sendeeTypeDet = sendeeTypeDet;
            }

            public Object getTypeIdsDet() {
                return typeIdsDet;
            }

            public void setTypeIdsDet(Object typeIdsDet) {
                this.typeIdsDet = typeIdsDet;
            }

            public String getSendeeIds() {
                return sendeeIds;
            }

            public void setSendeeIds(String sendeeIds) {
                this.sendeeIds = sendeeIds;
            }

            public String getSendeeNames() {
                return sendeeNames;
            }

            public void setSendeeNames(String sendeeNames) {
                this.sendeeNames = sendeeNames;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getSendTime() {
                return sendTime;
            }

            public void setSendTime(String sendTime) {
                this.sendTime = sendTime;
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

            public String getHasSended() {
                return hasSended;
            }

            public void setHasSended(String hasSended) {
                this.hasSended = hasSended;
            }

            public String getTypeIds() {
                return typeIds;
            }

            public void setTypeIds(String typeIds) {
                this.typeIds = typeIds;
            }

            public String getEnable() {
                return enable;
            }

            public void setEnable(String enable) {
                this.enable = enable;
            }
        }
    }
}
