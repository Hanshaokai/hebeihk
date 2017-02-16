package cn.huischool.huixiao.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.common.widget.widgetofbindexpandablerecylerview.ExpandableListItem;
import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/10/11.
 */

public class SchoolContactsListBean extends BaseResponse {


    private ResultsBean results;

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public static class ResultsBean implements Serializable {
        /**
         * id : 56430cbc60c1de3b17083c8e
         * name : 一年级
         * clsssTeacherList : [{"id":"56430cc460c1de3b17083c94","teacherList":[{"imgUrl":null,"id":"577f4f34630383477875832d","phone":"15027894311","duty":"一年级1班(体育),一年级2班(体育),一年级3班(体育),二年级4班(体育)","email":"779648196@.com","realName":"刘雪梅"}],"name":"1班"},{"id":"56430cc460c1de3b17083c95","teacherList":[{"imgUrl":null,"id":"577f4f34630383477875832d","phone":"15027894311","duty":"一年级1班(体育),一年级2班(体育),一年级3班(体育),二年级4班(体育)","email":"779648196@.com","realName":"刘雪梅"},{"imgUrl":null,"id":"577f4f34630383477875832d","phone":"18348911757","duty":"一年级2班(语文)","email":"779648198@.com","realName":"李静"}],"name":"2班"}]
         */

        private List<GradeClsssListBean> gradeClsssList;
        /**
         * id : 56430cda60c1de3b17083cb8
         * teacherList : [{"imgUrl":null,"id":"577f4f34630383477875832d","phone":"15830205866","duty":"一年级6班(语文),一年级10班(数学),三年级6班(数学)","email":"e","realName":"贾敏"},{"imgUrl":null,"id":"577f4f34630383477875832d","phone":"15733220532","duty":"一年级5班(语文)","email":"779648233@.com","realName":"高畅"}]
         * name : 语文
         */

        private List<SubjectListBean> subjectList;
        /**
         * teacherList : [{"imgUrl":"http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue/57a29bd93ca96419dc331134","id":"577f4f34630383477875832d","phone":"18931880689","email":"786409963@qq.com","realName":"王占龙"}]
         * name : 校长
         */

        private List<LeaderListBean> leaderList;

        public List<GradeClsssListBean> getGradeClsssList() {
            return gradeClsssList;
        }

        public void setGradeClsssList(List<GradeClsssListBean> gradeClsssList) {
            this.gradeClsssList = gradeClsssList;
        }

        public List<SubjectListBean> getSubjectList() {
            return subjectList;
        }

        public void setSubjectList(List<SubjectListBean> subjectList) {
            this.subjectList = subjectList;
        }

        public List<LeaderListBean> getLeaderList() {
            return leaderList;
        }

        public void setLeaderList(List<LeaderListBean> leaderList) {
            this.leaderList = leaderList;
        }

        //年级是可展开的项故继承ExpandableListItem
        public static class GradeClsssListBean implements ExpandableListItem, Serializable {
            private String id;
            private String name;
            public boolean gradeExpanded = false;
            /**
             * id : 56430cc460c1de3b17083c94
             * teacherList : [{"imgUrl":null,"id":"577f4f34630383477875832d","phone":"15027894311","duty":"一年级1班(体育),一年级2班(体育),一年级3班(体育),二年级4班(体育)","email":"779648196@.com","realName":"刘雪梅"}]
             * name : 1班
             */

            private List<ClsssTeacherListBean> clsssTeacherList;

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

            public List<ClsssTeacherListBean> getClsssTeacherList() {
                return clsssTeacherList;
            }

            public void setClsssTeacherList(List<ClsssTeacherListBean> clsssTeacherList) {
                this.clsssTeacherList = clsssTeacherList;
            }

            @Override
            public List<?> getChildItemList() {
                return clsssTeacherList;
            }

            @Override
            public boolean isExpanded() {
                return gradeExpanded;
            }

            @Override
            public void setExpanded(boolean isExpanded) {
                gradeExpanded = isExpanded;
            }

            //班级是可展开的项故继承 ExpandableListItem
            public static class ClsssTeacherListBean implements ExpandableListItem {
                private String id;
                private String name;
                private boolean classExpanded = false;
                /**
                 * imgUrl : null
                 * id : 577f4f34630383477875832d
                 * phone : 15027894311
                 * duty : 一年级1班(体育),一年级2班(体育),一年级3班(体育),二年级4班(体育)
                 * email : 779648196@.com
                 * realName : 刘雪梅
                 */

                private List<TeacherListBean> teacherList;

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

                public List<TeacherListBean> getTeacherList() {
                    return teacherList;
                }

                public void setTeacherList(List<TeacherListBean> teacherList) {
                    this.teacherList = teacherList;
                }

                @Override
                public List<?> getChildItemList() {
                    return teacherList;
                }

                @Override
                public boolean isExpanded() {
                    return classExpanded;
                }

                @Override
                public void setExpanded(boolean isExpanded) {
                    classExpanded = isExpanded;
                }

                public static class TeacherListBean implements ExpandableListItem {
                    private String imgUrl;
                    private String id;
                    private String phone;
                    private String duty;
                    private String email;
                    private String realName;

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

                    public String getPhone() {
                        return phone;
                    }

                    public void setPhone(String phone) {
                        this.phone = phone;
                    }

                    public String getDuty() {
                        return duty;
                    }

                    public void setDuty(String duty) {
                        this.duty = duty;
                    }

                    public String getEmail() {
                        return email;
                    }

                    public void setEmail(String email) {
                        this.email = email;
                    }

                    public String getRealName() {
                        return realName;
                    }

                    public void setRealName(String realName) {
                        this.realName = realName;
                    }

                    @Override
                    public List<?> getChildItemList() {
                        return new ArrayList<>();
                    }

                    @Override
                    public boolean isExpanded() {
                        return false;
                    }

                    @Override
                    public void setExpanded(boolean isExpanded) {

                    }
                }
            }
        }

        public static class SubjectListBean implements ExpandableListItem {
            private String id;
            private String name;
            private Boolean mexpand = false;
            /**
             * imgUrl : null
             * id : 577f4f34630383477875832d
             * phone : 15830205866
             * duty : 一年级6班(语文),一年级10班(数学),三年级6班(数学)
             * email : e
             * realName : 贾敏
             */

            private List<TeacherListBean> teacherList;

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

            public List<TeacherListBean> getTeacherList() {
                return teacherList;
            }

            public void setTeacherList(List<TeacherListBean> teacherList) {
                this.teacherList = teacherList;
            }

            @Override
            public List<?> getChildItemList() {
                return teacherList;
            }

            @Override
            public boolean isExpanded() {
                return mexpand;
            }

            @Override
            public void setExpanded(boolean isExpanded) {
                mexpand = isExpanded;
            }

            public static class TeacherListBean implements ExpandableListItem {
                private String imgUrl;
                private String id;
                private String phone;
                private String duty;
                private String email;
                private String realName;
                private boolean mexpand = false;

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

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getDuty() {
                    return duty;
                }

                public void setDuty(String duty) {
                    this.duty = duty;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public String getRealName() {
                    return realName;
                }

                public void setRealName(String realName) {
                    this.realName = realName;
                }

                @Override
                public List<?> getChildItemList() {
                    return new ArrayList<>();
                }

                @Override
                public boolean isExpanded() {
                    return mexpand;
                }

                @Override
                public void setExpanded(boolean isExpanded) {
                    mexpand = isExpanded;
                }
            }
        }

        public static class LeaderListBean implements ExpandableListItem {
            private String name;
            private boolean mexpand = false;
            /**
             * imgUrl : http://file-userimg.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue/57a29bd93ca96419dc331134
             * id : 577f4f34630383477875832d
             * phone : 18931880689
             * email : 786409963@qq.com
             * realName : 王占龙
             */

            private List<TeacherListBean> teacherList;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<TeacherListBean> getTeacherList() {
                return teacherList;
            }

            public void setTeacherList(List<TeacherListBean> teacherList) {
                this.teacherList = teacherList;
            }

            @Override
            public List<?> getChildItemList() {
                return teacherList;
            }

            @Override
            public boolean isExpanded() {
                return mexpand;
            }

            @Override
            public void setExpanded(boolean isExpanded) {
                mexpand = isExpanded;
            }

            public static class TeacherListBean implements ExpandableListItem {
                private String imgUrl;
                private String id;
                private String phone;
                private String email;
                private String realName;
                private boolean mexpand = false;
                private String duty;

                public String getDuty() {
                    return duty;
                }

                public void setDuty(String duty) {
                    this.duty = duty;
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

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public String getRealName() {
                    return realName;
                }

                public void setRealName(String realName) {
                    this.realName = realName;
                }

                @Override
                public List<?> getChildItemList() {
                    return new ArrayList<>();
                }

                @Override
                public boolean isExpanded() {
                    return mexpand;
                }

                @Override
                public void setExpanded(boolean isExpanded) {
                    mexpand = isExpanded;
                }
            }
        }
    }
}
