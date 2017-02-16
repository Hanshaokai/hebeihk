package cn.huischool.huixiao.framework.network;

/**
 * 枚举定义请求地址  全部的 请求地址都写这里
 *
 * @author Administrator
 */
public enum ServerInterfaceDefinition {

    //目前共用54个接口
    //登录
    OPT_LOGIN("/login/login"),


    //教案列表（get）
    OPT_MYLESSONLIST("/lesson/lessonList", RequestMethod.GET),


    //教案详细(post)
    OPT_MYLESSONINFO("/lesson/lessonInfo"),
    //上传教案文件
    OPT_UPLODEGRMMARFILE("/lesson/save_lesson"),


    /**
     * 课件
     */

    //课件列表（get）
    OPT_MYCOURSEWARELIST("/courseware/coursewareList", RequestMethod.GET),

    //课件详情(post)
    OPT_MyCOURSEWAREINFO("/courseware/coursewareInfo"),
    //课件关联的教案列表
    OTP_RELATEDGRAMMARLIST("/lesson/lessonlist_for_courseware"),
    /*待办数量*/
    OPT_COUNTOFSCHEDULE("/notice/unreadCount"),
    //上传课件
    OPT_UPLODECOURSEWAREFILE("/courseware/save_courseware"),


    /*我的听课记录列表*/
    OPT_GETMYLESSONNOTESLIST("/myLesson/myLessonList", RequestMethod.GET),
    /*听课记录详情*/
    OPT_GETMYLESSONNOTESDETAIL("/myLesson/myLessonInfo", RequestMethod.GET),

    //下载文件
    OPTDOWNLOADFILE("/lesson/downFile"),
    /*提交听课记录*/
    OPT_TOCOMMITLESSONNOTES("/myLesson/createMyLesson"),
    /*会议记录列表*/
    OPT_GETMYMEETINGRECORDNOTESLIST("/meetRecord/meetRecordList"),
    /*会议记录详情*/

    OPT_GETMYMETTINGRECORDNOTESDETAIL("/meetRecord/meetRecordInfo", RequestMethod.GET),
    /*提交会议记录*/
    OPT_TOCOMMITMEETINGRECORD("/meetRecord/save_meetRecord"),

    /*教研活动列表*/
    OPT_GETACTIVITIESOFTEACHANDRESEARCHLIST("/researchActivity/researchActivityList", RequestMethod.GET),
    /*教研活动详情*/
    OPT_GETACTIVITIESOFTEACHANDRESEARCHDETAIl("/researchActivity/researchActivityInfo", RequestMethod.GET),
    /*提交教研活动*/
    OPT_TOCOMMITACTIVITIESOFTEACHANDRESEARCH("/researchActivity/createResearchActivity"),
    /*学习笔记列表*/
    OPT_GETMYSTUDYNOTESLIST("/studyNotes/studyNotesList", RequestMethod.GET),
    /*学习笔记详情*/
    OPT_GETMYSTUDYNOTESDETAIL("/studyNotes/studyNotesInfo", RequestMethod.GET),
    /*提交学习笔记*/

    OPT_TOCOMMITTUDYNOTES("/studyNotes/createStudyNotes"),
    /*检查教案*/

    OPT_CHECKGRAMMARLIST("/checkwork/lessonList"),

    /*检查课件*/
    OPT_CHECKCOURSEWAELIST("/checkwork/coursewareList"),

    /*批阅教案*/
    OPT_TOCOMMENTCURRENTGRAMMAR("/work_lookUp/work_lookUpLesson"),

    /*批阅课件*/
    OPT_TOCOMMENTCURRENTCOURSEWARE("/work_lookUp/work_lookUpCoursware"),
    // 查阅提交数量接口
    OPT_LOOKUPNUMLIST("/work_lookUp/lookUpList"),

    /**
     * 通知
     **/
    //已发送通知
    OPT_YETSENDNOTIFI("/notice/noticeList"),

    //接受通知列表
    OPT_ACCENOTIFI("/notice/noticeReceiveList"),

    //发送通知
    OPT_SENDNOTICE("/notice/createNotice"),

    /*标记已读未读*/
    OPT_TOMARKREADORNO("/affiche/readReceive", RequestMethod.GET),


    /**
     * 公告
     **/
    //获取接收公告列表
    OPT_RECEIAFFICH("/affiche/afficheReceiveList", RequestMethod.GET),
    //公告详情

    OPT_RECEIVEDAFFICHEDETAIL("/affiche/AfficheInfo", RequestMethod.GET),
    //获取发送公告列表
    OPT_YETSENDAFFICHE("/affiche/afficheList", RequestMethod.GET),

    //发布公告
    OPT_APPLYAFFICHE("/affiche/createAffiche"),

    //公告详情
    OPT_RECEIVEDNOTICEDETAIL("/notice/noticeInfo", RequestMethod.GET),


    /**
     * 申请
     **/
    //提出申请
    OPT_APPLYAPPROVAL("/approval/createApproval"),

    //发送的申请列表
    OPT_APPROVALLIST("/approval/approval_list"),

    //审批详情
    APPROVALDETAIL("/lineApproval/lineApprovalInfo", RequestMethod.GET),


    /**
     * 审批
     **/
    //在线审批列表
    OPT_LINEAPPROVALLIST("/lineApproval/lineApprovalList", RequestMethod.GET),


    //审批申请批阅
    OPT_LINEAPPROVAL("/lineApproval/lineApprovalMove"),

    /**
     * 共享接口
     **/
    //校内教案共享接口
    OPT_SHARELESSONLIST("/shareLesson_school/shareLessonList", RequestMethod.GET),

    //校内课件共享接口
    OPT_SHARECOURSEWARELIST("/shareLesson_school/courseWareList", RequestMethod.GET),


    //本校所有领导
    OPT_ALL_LEADER("/school/allLeader"),

    //本校所有年级
    OPT_GRADE_LIST("/school/grade_list"),

    //指定年级所有班级
    OPT_CLASS_LIST("/school/class_list"),

    //本校所有学科
    OPT_SUBJECT_LIST("/school/subject_list"),

    //指定年级所有教师接口
    OPT_GRADE_TEACHER("/school/grade_teacher", RequestMethod.GET),


    //当前用户可选角色
    OPT_APPROVAL_SELECTE_ROLELIST("/approval/role_list"),

    //据已选角色查询用户列表接口
    OPT_APPROVAL_RECEIVERSOF_ROLELIST("/approval/find_receivers"),


    /*
    * 轮播图片*/
    OPT_CHANGEIMAGLIST("/app_img/newsList", RequestMethod.GET),

    /*我的资料接口*/
    OPT_MYCOUNTINFOR("/myCou/myCouInfo", RequestMethod.GET),

    /*修改密码*/
    OPT_UPDATEPASSWORD("/myCou/updatePassword"),

    /*修改资料*/
    OPT_MYCOUUPDATE("/myCou/myCouUpdate"),

    /*反馈*/
    OPT_SUGGESTIONSUB("/suggestion/save"),
    /*学校联系人*/
    OPT_SCHOOLCONTACTSLIST("/schoolMail/schoolMailList");

    private String opt;
    private RequestMethod requestMethod = RequestMethod.POST;
    private int retryNumber = 1;

    private ServerInterfaceDefinition(String opt) {
        this.opt = opt;
    }

    private ServerInterfaceDefinition(String opt, RequestMethod requestMethod) {
        this.opt = opt;
        this.requestMethod = requestMethod;
    }

    private ServerInterfaceDefinition(String opt, RequestMethod requestMethod,
                                      int retryNumber) {
        this.opt = opt;
        this.requestMethod = requestMethod;
        this.retryNumber = retryNumber;
    }

    public String getOpt() {
        return opt;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public int getRetryNumber() {
        return retryNumber;
    }

    public enum RequestMethod {
        POST("POST"), GET("GET");
        private String requestMethodName;

        RequestMethod(String requestMethodName) {
            this.requestMethodName = requestMethodName;
        }

        public String getRequestMethodName() {
            return requestMethodName;
        }
    }

}
