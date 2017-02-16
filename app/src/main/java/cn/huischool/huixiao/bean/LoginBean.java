package cn.huischool.huixiao.bean;

import java.io.Serializable;
import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * 定义javaBean 类
 *
 * @author han
 *         <p/>
 *         2016-4-15
 */
public class LoginBean extends BaseResponse implements Serializable {


    /**
     * userId : 577f4f2963038347787582ad
     * name : wangjing
     * schoolId : 564306c0b26c43a3069cd5ad
     * schoolName : 城厢小学
     * remarkId : 3
     * userType : 1
     * realName : 王静
     * purviews : [{"id":"A00010","name":"工作浏览"},{"id":"B00002","name":"查看通知"},{"id":"B00001","name":"发送通知"},{"id":"A00005","name":"教师听课"},{"id":"B00006","name":"发送公告"},{"id":"A00006","name":"会议记录"},{"id":"A00008","name":"学习笔记"},{"id":"A00007","name":"教研活动"},{"id":"A00001","name":"教案管理"},{"id":"A00002","name":"课件管理"},{"id":"B00003","name":"审批申请"},{"id":"B00005","name":"校内公告"}]
     * yunUrl : chengxiangxiaoxue_test/
     * endpoint : oss-cn-beijing.aliyuncs.com
     * role : {"id":"5646ec9194dfc8dc27283938","schoolId":"564306c0b26c43a3069cd5ad","name":"教师","description":"教师","createTime":"2015-11-14 16:10:57","remarkId":"3","enabled":null,"linkUrl":null,"isLeader":"0"}
     * ossClient : {"endpoint":"http://oss-cn-beijing.aliyuncs.com","credentialsProvider":{"credentials":{"accessKeyId":"BXDIvjwfLwXZ6ywB","secretAccessKey":"FXDpxibhRuTEwnvWqkk42GORv1xonA"}}}
     * is_zongxiao : 0
     * imgUrl : http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/57abdd640cf26d8718dea2f0
     * dutyList : [{"gradeName":"一年级","gradeId":"56430cbc60c1de3b17083c8e","subList":[{"subName":"英语","subjectId":"56430ce760c1de3b17083cba"}]}]
     */

    private ResultsBean results;

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String userId;
        private String name;
        private String schoolId;
        private String schoolName;
        private String remarkId;
        private String userType;
        private String realName;
        private String yunUrl;
        private String endpoint;
        /**
         * id : 5646ec9194dfc8dc27283938
         * schoolId : 564306c0b26c43a3069cd5ad
         * name : 教师
         * description : 教师
         * createTime : 2015-11-14 16:10:57
         * remarkId : 3
         * enabled : null
         * linkUrl : null
         * isLeader : 0
         */

        private RoleBean role;
        /**
         * endpoint : http://oss-cn-beijing.aliyuncs.com
         * credentialsProvider : {"credentials":{"accessKeyId":"BXDIvjwfLwXZ6ywB","secretAccessKey":"FXDpxibhRuTEwnvWqkk42GORv1xonA"}}
         */

        private OssClientBean ossClient;
        private String is_zongxiao;
        private String imgUrl;
        /**
         * id : A00010
         * name : 工作浏览
         */

        private List<PurviewsBean> purviews;
        /**
         * gradeName : 一年级
         * gradeId : 56430cbc60c1de3b17083c8e
         * subList : [{"subName":"英语","subjectId":"56430ce760c1de3b17083cba"}]
         */

        private List<DutyListBean> dutyList;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public String getRemarkId() {
            return remarkId;
        }

        public void setRemarkId(String remarkId) {
            this.remarkId = remarkId;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getYunUrl() {
            return yunUrl;
        }

        public void setYunUrl(String yunUrl) {
            this.yunUrl = yunUrl;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public void setEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }

        public RoleBean getRole() {
            return role;
        }

        public void setRole(RoleBean role) {
            this.role = role;
        }

        public OssClientBean getOssClient() {
            return ossClient;
        }

        public void setOssClient(OssClientBean ossClient) {
            this.ossClient = ossClient;
        }

        public String getIs_zongxiao() {
            return is_zongxiao;
        }

        public void setIs_zongxiao(String is_zongxiao) {
            this.is_zongxiao = is_zongxiao;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public List<PurviewsBean> getPurviews() {
            return purviews;
        }

        public void setPurviews(List<PurviewsBean> purviews) {
            this.purviews = purviews;
        }

        public List<DutyListBean> getDutyList() {
            return dutyList;
        }

        public void setDutyList(List<DutyListBean> dutyList) {
            this.dutyList = dutyList;
        }

        public static class RoleBean {
            private String id;
            private String schoolId;
            private String name;
            private String description;
            private String createTime;
            private String remarkId;
            private Object enabled;
            private Object linkUrl;
            private String isLeader;

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getRemarkId() {
                return remarkId;
            }

            public void setRemarkId(String remarkId) {
                this.remarkId = remarkId;
            }

            public Object getEnabled() {
                return enabled;
            }

            public void setEnabled(Object enabled) {
                this.enabled = enabled;
            }

            public Object getLinkUrl() {
                return linkUrl;
            }

            public void setLinkUrl(Object linkUrl) {
                this.linkUrl = linkUrl;
            }

            public String getIsLeader() {
                return isLeader;
            }

            public void setIsLeader(String isLeader) {
                this.isLeader = isLeader;
            }
        }

        public static class OssClientBean {
            private String endpoint;
            /**
             * credentials : {"accessKeyId":"BXDIvjwfLwXZ6ywB","secretAccessKey":"FXDpxibhRuTEwnvWqkk42GORv1xonA"}
             */

            private CredentialsProviderBean credentialsProvider;

            public String getEndpoint() {
                return endpoint;
            }

            public void setEndpoint(String endpoint) {
                this.endpoint = endpoint;
            }

            public CredentialsProviderBean getCredentialsProvider() {
                return credentialsProvider;
            }

            public void setCredentialsProvider(CredentialsProviderBean credentialsProvider) {
                this.credentialsProvider = credentialsProvider;
            }

            public static class CredentialsProviderBean {
                /**
                 * accessKeyId : BXDIvjwfLwXZ6ywB
                 * secretAccessKey : FXDpxibhRuTEwnvWqkk42GORv1xonA
                 */

                private CredentialsBean credentials;

                public CredentialsBean getCredentials() {
                    return credentials;
                }

                public void setCredentials(CredentialsBean credentials) {
                    this.credentials = credentials;
                }

                public static class CredentialsBean {
                    private String accessKeyId;
                    private String secretAccessKey;

                    public String getAccessKeyId() {
                        return accessKeyId;
                    }

                    public void setAccessKeyId(String accessKeyId) {
                        this.accessKeyId = accessKeyId;
                    }

                    public String getSecretAccessKey() {
                        return secretAccessKey;
                    }

                    public void setSecretAccessKey(String secretAccessKey) {
                        this.secretAccessKey = secretAccessKey;
                    }
                }
            }
        }

        public static class PurviewsBean {
            private String id;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class DutyListBean {
            private String gradeName;
            private String gradeId;
            /**
             * subName : 英语
             * subjectId : 56430ce760c1de3b17083cba
             */

            private List<SubListBean> subList;

            public String getGradeName() {
                return gradeName;
            }

            public void setGradeName(String gradeName) {
                this.gradeName = gradeName;
            }

            public String getGradeId() {
                return gradeId;
            }

            public void setGradeId(String gradeId) {
                this.gradeId = gradeId;
            }

            public List<SubListBean> getSubList() {
                return subList;
            }

            public void setSubList(List<SubListBean> subList) {
                this.subList = subList;
            }

            public static class SubListBean {
                private String subName;
                private String subjectId;

                public String getSubName() {
                    return subName;
                }

                public void setSubName(String subName) {
                    this.subName = subName;
                }

                public String getSubjectId() {
                    return subjectId;
                }

                public void setSubjectId(String subjectId) {
                    this.subjectId = subjectId;
                }
            }
        }
    }
}

	
	


