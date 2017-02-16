package cn.huischool.huixiao.framework.network;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.SchoolContactsListParser;
import cn.huischool.huixiao.framework.base.CustomApplication;
import cn.huischool.huixiao.parser.AcceNotifiParser;
import cn.huischool.huixiao.parser.AfficheschParser;
import cn.huischool.huixiao.parser.AllGradeParser;
import cn.huischool.huixiao.parser.AllLeaderParser;
import cn.huischool.huixiao.parser.AllSubjectParser;
import cn.huischool.huixiao.parser.ApprovalDetailParser;
import cn.huischool.huixiao.parser.ApprovalReceiversOfTheRoleParser;
import cn.huischool.huixiao.parser.ApprovalSelectRoleListParser;
import cn.huischool.huixiao.parser.ChangeImageParser;
import cn.huischool.huixiao.parser.CheckCourseWareListParser;
import cn.huischool.huixiao.parser.CheckGrammarListParser;
import cn.huischool.huixiao.parser.CommitNumberListParser;
import cn.huischool.huixiao.parser.CountOfScheduleParser;
import cn.huischool.huixiao.parser.LoginParser;
import cn.huischool.huixiao.parser.MyActivitiesOfTeachAndResearchDetailParser;
import cn.huischool.huixiao.parser.MyActivitiesOfTeachAndResearchParser;
import cn.huischool.huixiao.parser.MyCountInforParser;
import cn.huischool.huixiao.parser.MyCourseWareDetailParser;
import cn.huischool.huixiao.parser.MyCourseWareParser;
import cn.huischool.huixiao.parser.MyLessonNotesListParser;
import cn.huischool.huixiao.parser.MyLesssonNotesDeatilParser;
import cn.huischool.huixiao.parser.MyMeetingRecordNotesDetailParser;
import cn.huischool.huixiao.parser.MyMyMeetingRecordListParser;
import cn.huischool.huixiao.parser.MyStudyNotesDetailParser;
import cn.huischool.huixiao.parser.MyStudyNotesListParser;
import cn.huischool.huixiao.parser.MyTeacherPlanDetailParser;
import cn.huischool.huixiao.parser.MyTeacherPlanParser;
import cn.huischool.huixiao.parser.OfOneGradeAllClassParser;
import cn.huischool.huixiao.parser.OfOneGradeTeacherParser;
import cn.huischool.huixiao.parser.ReceivApprovalParser;
import cn.huischool.huixiao.parser.ReceivedAfficheDetailParser;
import cn.huischool.huixiao.parser.ReceivedNoticeDetailParser;
import cn.huischool.huixiao.parser.RelatedGrammarListParser;
import cn.huischool.huixiao.parser.SchoolShareCourseWareParser;
import cn.huischool.huixiao.parser.SchoolShareLessonPlansParser;
import cn.huischool.huixiao.parser.ToSendCompleteParser;
import cn.huischool.huixiao.parser.YetSendAfficheParser;
import cn.huischool.huixiao.parser.YetSendApprovalListParser;
import cn.huischool.huixiao.parser.YetSendNotifiParser;

/**
 * 构造Request 类 全部请求的 requst构造 都 写这里
 *
 * @author han
 *         <p>
 *         2016-4-15
 */
public class RequestMaker {
    private CustomApplication customApplication;
    private RequestMaker() {
        customApplication = CustomApplication.customApplication;
    }
    private static RequestMaker requestMaker = null;
    /**
     * 单例
     *
     * @return
     */
    public static RequestMaker getInstance() {
        if (requestMaker == null) {
            requestMaker = new RequestMaker();
            return requestMaker;
        } else {
            return requestMaker;
        }
    }
    /**
     * 返回相应的Request实例
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    public Request getLoginRequest(String userName, String password
    ) {
        Request request = null;
        try {

            Map<String, String> paramsMap = new HashMap<String, String>();
            paramsMap.put("userName", userName);
            paramsMap.put("password", password);
            request = new Request(ServerInterfaceDefinition.OPT_LOGIN,
                    paramsMap, new LoginParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;
    }

    //已接受通知列表
    public Request getAcceNotifiRequest(String createTime, String orderType, String page,
                                        String pageSize, String schoolId, String teacherId, String title
    ) {
        Request request = null;
        try {

            Map<String, String> paramsMap = new HashMap<String, String>();
            paramsMap.put("createTime", createTime);
            paramsMap.put("orderType", orderType);
            paramsMap.put("page", page);
            paramsMap.put("pageSize", pageSize);
            paramsMap.put("schoolId", schoolId);
            paramsMap.put("teacherId", teacherId);
            paramsMap.put("title", title);


            request = new Request(ServerInterfaceDefinition.OPT_ACCENOTIFI,
                    paramsMap, new AcceNotifiParser());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;
    }

    //已接受公告列表
    public Request getAfficheRequest(String createTime, String orderType, String page,
                                     String pageSize, String schoolId, String teacherId) {
        Request request = null;
        try {
            Map<String, String> paramsMap = new HashMap<String, String>();
            paramsMap.put("createTime", createTime);
            paramsMap.put("orderType", orderType);
            paramsMap.put("page", page);
            paramsMap.put("pageSize", pageSize);
            paramsMap.put("schoolId", schoolId);
            paramsMap.put("teacherId", teacherId);
    /*paramsMap.put("title", title);*/
            request = new Request(ServerInterfaceDefinition.OPT_RECEIAFFICH,
                    paramsMap, new AfficheschParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    //已发送通知列表
    public Request getYetSendNoticeRequest(String createTime, String orderType, String page,
                                           String pageSize, String schoolId, String teacherId, String
                                                   title) {
        Request request = null;
        try {
            Map<String, String> paramsMap = new HashMap<String, String>();
            paramsMap.put("createTime", createTime);
            paramsMap.put("orderType", orderType);
            paramsMap.put("page", page);
            paramsMap.put("pageSize", pageSize);
            paramsMap.put("schoolId", schoolId);
            paramsMap.put("teacherId", teacherId);
            paramsMap.put("title", title);
            request = new Request(ServerInterfaceDefinition.OPT_YETSENDNOTIFI,
                    paramsMap, new YetSendNotifiParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    //已发送公告列表
    public Request getYetSendAfficheRequest(String createTime, String orderType, String page,
                                            String pageSize, String schoolId, String teacherId, String
                                                    title) {
        Request request = null;
        try {
            Map<String, String> paramsMap = new HashMap<String, String>();
            paramsMap.put("createTime", createTime);
            paramsMap.put("orderType", orderType);
            paramsMap.put("page", page);
            paramsMap.put("pageSize", pageSize);
            paramsMap.put("schoolId", schoolId);
            paramsMap.put("teacherId", teacherId);
            paramsMap.put("title", title);
            request = new Request(ServerInterfaceDefinition.OPT_YETSENDAFFICHE,
                    paramsMap, new YetSendAfficheParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    //发送公告
    public Request getToSendAfficheRequest(String title, String content, String schoolId, String
            senderId, String hasSended) {
        Request request = null;
        try {
            JSONObject jsonObjectParams = new JSONObject();
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("title", title);
            jsonParam.put("content", content);
            jsonParam.put("schoolId", schoolId);
            jsonParam.put("senderId", senderId);
            jsonParam.put("hasSended", hasSended);
            jsonObjectParams.put("affiche", jsonParam);


            request = new Request(ServerInterfaceDefinition.OPT_APPLYAFFICHE,
                    jsonObjectParams, new ToSendCompleteParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;
    }
    //获取图片

    public Request getChangeImageRequest(String schoolId) {

        Request request = null;
        Map<String, String> paramsMap = new HashMap<String, String>();
        try {
            paramsMap.put("schoolId", schoolId);
            request = new Request(ServerInterfaceDefinition.OPT_CHANGEIMAGLIST, paramsMap, new
                    ChangeImageParser());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return request;
    }

    //我的资料
    public Request getMyCountInforRequest(String schoolId, String teacherId) {

        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();
        try {
            paramsMap.put("schoolId", schoolId);
            paramsMap.put("teacherId", teacherId);
            request = new Request(ServerInterfaceDefinition.OPT_MYCOUNTINFOR, paramsMap, new

                    MyCountInforParser());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return request;
    }

    //修改密码
    public Request getUpdatePasswordRequest(String teacherId, String password, String newPassword) {

        Request request = null;

        JSONObject jsonObjectParams = new JSONObject();
        try {
            jsonObjectParams.put("teacherId", teacherId);
            jsonObjectParams.put("password", password);
            jsonObjectParams.put("newPassword", newPassword);
            request = new Request(ServerInterfaceDefinition.OPT_UPDATEPASSWORD, jsonObjectParams, new
                    ToSendCompleteParser());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return request;
    }

    //修改资料
    public Request getMyCouUpdateRequest(String teacherId, String realName, String
            phone, String qq, String mail) {

        Request request = null;

        JSONObject jsonObjectParams = new JSONObject();
        try {
            jsonObjectParams.put("teacherId", teacherId);
            jsonObjectParams.put("realName", realName);

            jsonObjectParams.put("phone", phone);
            jsonObjectParams.put("qq", qq);
            jsonObjectParams.put("mail", mail);
            request = new Request(ServerInterfaceDefinition.OPT_MYCOUUPDATE, jsonObjectParams, new
                    ToSendCompleteParser());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return request;
    }

    //本校所有领导
    public Request getAllLeaderRequest(String userId, String schoolId) {

        Request request = null;
        JSONObject jsonObjectParams = new JSONObject();

        try {
            jsonObjectParams.put("userId", userId);
            jsonObjectParams.put("schoolId", schoolId);

            request = new Request(ServerInterfaceDefinition.OPT_ALL_LEADER, jsonObjectParams, new
                    AllLeaderParser());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return request;

    }

    //本校所有年级


    public Request getAllGradeRequest(String schoolId) {

        Request request = null;
        JSONObject jsonObjectParams = new JSONObject();

        try {

            jsonObjectParams.put("schoolId", schoolId);

            request = new Request(ServerInterfaceDefinition.OPT_GRADE_LIST, jsonObjectParams, new
                    AllGradeParser());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return request;

    }
    //指定年级所有班级

    public Request getOfOneGradeAllClassRequest(String gradeId) {
        Request request = null;

        JSONObject jsonObjectParams = new JSONObject();

        try {
            jsonObjectParams.put("gradeId", gradeId);

            request = new Request(ServerInterfaceDefinition.OPT_CLASS_LIST, jsonObjectParams, new
                    OfOneGradeAllClassParser());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return request;
    }

    //本校所有学科
    public Request getAllSubjectRequest(String schoolId) {

        Request request = null;

        JSONObject jsonObjectParams = new JSONObject();

        try {

            jsonObjectParams.put("schoolId", schoolId);

            request = new Request(ServerInterfaceDefinition.OPT_SUBJECT_LIST, jsonObjectParams, new
                    AllSubjectParser());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return request;
    }

    //指定年级所有教师
    public Request getOfOneGradeTeacherRequest(String gradeId) {
        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();

        try {
            paramsMap.put("gradeId", gradeId);

            request = new Request(ServerInterfaceDefinition.OPT_GRADE_TEACHER, paramsMap, new
                    OfOneGradeTeacherParser());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;
    }

    //发送通知
    public Request getToSendNotifiRequest(String userId, String schoolId,
                                          String title, String content, String sendeeType, String sendeeIds,
                                          String gradeId1,
                                          String gradeId2, String classId1,
                                          String gradeId3, String subjectId2,
                                          String subjectId1,
                                          String gradeId4,
                                          String hasSend) {
        Request request = null;

        JSONObject jsonObjectParams = new JSONObject();
        JSONObject userContext = new JSONObject();
        JSONObject notice = new JSONObject();

        try {
            userContext.put("userId", userId);
            userContext.put("schoolId", schoolId);
            jsonObjectParams.put("userContext", userContext);

            notice.put("title", title);
            notice.put("content", content);
            notice.put("sendeeType", sendeeType);
            notice.put("sendeeIds", sendeeIds);
            jsonObjectParams.put("notice", notice);

            jsonObjectParams.put("gradeId1", gradeId1);
            jsonObjectParams.put("gradeId2", gradeId2);
            jsonObjectParams.put("classId1", classId1);
            jsonObjectParams.put("gradeId3", gradeId3);
            jsonObjectParams.put("subjectId2", subjectId2);

            jsonObjectParams.put("subjectId1", subjectId1);
            jsonObjectParams.put("gradeId4", gradeId4);
            jsonObjectParams.put("hasSend", hasSend);

            request = new Request(ServerInterfaceDefinition.OPT_SENDNOTICE, jsonObjectParams, new
                    ToSendCompleteParser());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return request;
    }

    public Request getYetSendApprovalListRequest(String teacherId, String page, String pageSize, String title, String ischecked) {


        Request request = null;

        JSONObject jsonObjectParams = new JSONObject();


        try {
            jsonObjectParams.put("teacherId", teacherId);
            jsonObjectParams.put("page", page);
            jsonObjectParams.put("pageSize", pageSize);
            jsonObjectParams.put("title", title);
            jsonObjectParams.put("ischecked", ischecked);

            request = new Request(ServerInterfaceDefinition.OPT_APPROVALLIST, jsonObjectParams, new
                    YetSendApprovalListParser());

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return request;
    }
    //在线接受的审批列表

    public Request getReceivApprovalListRequest(String page, String pageSize, String teacherId,
                                                String title, String queryType) {

        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();

        try {
            paramsMap.put("page", page);
            paramsMap.put("pageSize", pageSize);
            paramsMap.put("teacherId", teacherId);
            paramsMap.put("queryType", queryType);

            paramsMap.put("title", title);

            request = new Request(ServerInterfaceDefinition.OPT_LINEAPPROVALLIST, paramsMap, new
                    ReceivApprovalParser());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;

    }

    public Request gettoDecideApprovalRequest(String id, String opinion, String comment, String
            teacherId, String schoolId, String approvalTime) {


        Request request = null;

        JSONObject jsonObjectParams = new JSONObject();


        try {

            jsonObjectParams.put("id", id);
            if (jsonObjectParams.length() == 0) {
                LogUtil.d("没加审批id");

            } else {
                LogUtil.d(id);
            }

            jsonObjectParams.put("opinion", opinion);
            jsonObjectParams.put("comment", comment);
            jsonObjectParams.put("teacherId", teacherId);
            jsonObjectParams.put("schoolId", schoolId);
            jsonObjectParams.put("approvalTime", approvalTime);

            request = new Request(ServerInterfaceDefinition.OPT_LINEAPPROVAL, jsonObjectParams, new
                    ToSendCompleteParser());

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return request;


    }

    public Request getSchoolShareLessonPlansListRequest(String page, String pageSize, String
            schoolId) {

        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();

        try {
            paramsMap.put("page", page);
            paramsMap.put("pageSize", pageSize);
            paramsMap.put("schoolId", schoolId);


            request = new Request(ServerInterfaceDefinition.OPT_SHARELESSONLIST, paramsMap, new
                    SchoolShareLessonPlansParser
                    ());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request getSchoolShareCourseWareListRequest(String page, String pageSize, String schoolId) {

        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();

        try {
            paramsMap.put("page", page);
            paramsMap.put("pageSize", pageSize);
            paramsMap.put("schoolId", schoolId);


            request = new Request(ServerInterfaceDefinition.OPT_SHARECOURSEWARELIST, paramsMap, new
                    SchoolShareCourseWareParser
                    ());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;

    }

    public Request getApprovalSelectRoleListRequest(String schoolId, String remarkId, String
            roleIds) {


        Request request = null;

        JSONObject jsonObjectParams = new JSONObject();
        JSONObject userContext = new JSONObject();


        try {

            userContext.put("schoolId", schoolId);
            userContext.put("remarkId", remarkId);

            jsonObjectParams.put("userContext", userContext);

            jsonObjectParams.put("roleIds", roleIds);
            request = new Request(ServerInterfaceDefinition.OPT_APPROVAL_SELECTE_ROLELIST, jsonObjectParams, new
                    ApprovalSelectRoleListParser());

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return request;


    }

    public Request getApprovalReceiversOfTheRoleRequest(String userId, String roleId) {


        Request request = null;

        JSONObject jsonObjectParams = new JSONObject();


        try {

            jsonObjectParams.put("userId", userId);
            jsonObjectParams.put("roleId", roleId);


            request = new Request(ServerInterfaceDefinition.OPT_APPROVAL_RECEIVERSOF_ROLELIST, jsonObjectParams, new
                    ApprovalReceiversOfTheRoleParser());

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return request;


    }

    public Request getToCreateApprovalRequest(String userId, String schoolId,
                                              String content,
                                              String approversIds1, String approversIds2, String approversIds3,
                                              String approverAmount,
                                              String recipientIds, String recipientNames,
                                              String approvalType) {


        Request request = null;

        JSONObject jsonObjectParams = new JSONObject();
        JSONObject userContext = new JSONObject();
        JSONObject approval = new JSONObject();


        try {

            userContext.put("userId", userId);
            userContext.put("schoolId", schoolId);
            jsonObjectParams.put("userContext", userContext);

            approval.put("content", content);
            approval.put("title", "");
            approval.put("approversIds1", approversIds1);
            approval.put("approversIds2", approversIds2);
            approval.put("approversIds3", approversIds3);
            approval.put("approverAmount", approverAmount);
            approval.put("recipientIds", recipientIds);
            approval.put("recipientNames", recipientNames);
            approval.put("approvalType", approvalType);

            jsonObjectParams.put("approval", approval);

            request = new Request(ServerInterfaceDefinition.OPT_APPLYAPPROVAL, jsonObjectParams, new
                    ToSendCompleteParser());

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return request;


    }

    public Request getMyTeacherPlanListRequest(String page, String pageSize, String teacherId,
                                               String lessonName, String ischecked, String lessonType) {


        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();

        try {
            paramsMap.put("page", page);
            paramsMap.put("pageSize", pageSize);
            paramsMap.put("teacherId", teacherId);
            paramsMap.put("lessonName", lessonName);
            paramsMap.put("ischecked", ischecked);
            paramsMap.put("lessonType", lessonType);


            request = new Request(ServerInterfaceDefinition.OPT_MYLESSONLIST, paramsMap, new
                    MyTeacherPlanParser());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request getMyTeacherPlanDetailRequest(String lessonId, String realName, String remarkId) {

        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();

        try {
            paramsMap.put("lessonId", lessonId);
            paramsMap.put("realName", realName);
            paramsMap.put("remarkId", remarkId);


            request = new Request(ServerInterfaceDefinition.OPT_MYLESSONINFO, paramsMap, new
                    MyTeacherPlanDetailParser());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request getSubmitFeedbackRequest(String userId, String schoolId, String suggestionType, String content, String createTime, String creater) {

        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();

        try {
            paramsMap.put("userId", userId);
            paramsMap.put("schoolId", schoolId);
            paramsMap.put("suggestionType", suggestionType);
            paramsMap.put("content", content);
            paramsMap.put("createTime", createTime);
            paramsMap.put("creater", creater);


            request = new Request(ServerInterfaceDefinition.OPT_SUGGESTIONSUB, paramsMap, new
                    ToSendCompleteParser());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }


    public Request getMyCourseWareListRequest(String page, String pageSize, String teacherId,
                                              String coursewareName, String
                                                      coursewareType,String ischecked) {


        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();

        try {
            paramsMap.put("page", page);
            paramsMap.put("pageSize", pageSize);
            paramsMap.put("teacherId", teacherId);
            paramsMap.put("coursewareName", coursewareName);
            paramsMap.put("coursewareType", coursewareType);
            paramsMap.put("ischecked", ischecked);
            request = new Request(ServerInterfaceDefinition.OPT_MYCOURSEWARELIST, paramsMap, new
                    MyCourseWareParser());


        } catch (Exception e) {
            e.printStackTrace();
        }


        return request;


    }

    public Request getMyCourseWareDetailRequest(String coursewareId, String realName, String remarkId) {

        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();

        try {
            paramsMap.put("coursewareId", coursewareId);
            paramsMap.put("realName", realName);
            paramsMap.put("remarkId", remarkId);


            request = new Request(ServerInterfaceDefinition.OPT_MyCOURSEWAREINFO, paramsMap, new
                    MyCourseWareDetailParser());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request getCheckGrammarListRequest(String remarkId, String schoolId,
                                              String subjectName, String gradeName,
                                              String searchName,
                                              String page, String pageSize) {
        Request request = null;
        Map<String, String> paramsMap = new HashMap<String, String>();


        try {
            paramsMap.put("remarkId", remarkId);
            paramsMap.put("schoolId", schoolId);
            paramsMap.put("subjectName", subjectName);
            paramsMap.put("gradeName", gradeName);
            paramsMap.put("searchName", searchName);

            paramsMap.put("page", page);
            paramsMap.put("pageSize", pageSize);

            request = new Request(ServerInterfaceDefinition.OPT_CHECKGRAMMARLIST, paramsMap, new
                    CheckGrammarListParser());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request getCheckCourseWareListRequest(String remarkId, String schoolId, String subjectName, String gradeName, String searchName, String page, String pageSize) {

        Request request = null;
        Map<String, String> paramsMap = new HashMap<String, String>();


        try {
            paramsMap.put("remarkId", remarkId);
            paramsMap.put("schoolId", schoolId);
            paramsMap.put("subjectName", subjectName);
            paramsMap.put("gradeName", gradeName);
            paramsMap.put("searchName", searchName);
            paramsMap.put("page", page);
            paramsMap.put("pageSize", pageSize);

            request = new Request(ServerInterfaceDefinition.OPT_CHECKCOURSEWAELIST, paramsMap, new
                    CheckCourseWareListParser());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;

    }

    public Request getToCommentCurrentGrammarRequest(String lessonId, String comment, String
            userId, String schoolId, String realName) {

        Request request = null;
        JSONObject jsonObjectParams = new JSONObject();
        JSONObject userContext = new JSONObject();
        JSONObject lessonReadOver = new JSONObject();


        try {

            userContext.put("userId", userId);
            userContext.put("schoolId", schoolId);
            userContext.put("realName", realName);
            jsonObjectParams.put("userContext", userContext);

            lessonReadOver.put("lessonId", lessonId);
            lessonReadOver.put("comment", comment);


            jsonObjectParams.put("lessonReadOver", lessonReadOver);

            request = new Request(ServerInterfaceDefinition.OPT_TOCOMMENTCURRENTGRAMMAR, jsonObjectParams, new
                    ToSendCompleteParser());

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return request;


    }

    public Request getToCommentCurrentCourseWareRequest(String coursewareId, String comment,
                                                        String userId, String schoolId, String realName) {

        Request request = null;
        JSONObject jsonObjectParams = new JSONObject();
        JSONObject userContext = new JSONObject();
        JSONObject coursewareReadOver = new JSONObject();


        try {

            userContext.put("userId", userId);
            userContext.put("schoolId", schoolId);
            userContext.put("realName", realName);
            jsonObjectParams.put("userContext", userContext);

            coursewareReadOver.put("coursewareId", coursewareId);
            coursewareReadOver.put("comment", comment);
            jsonObjectParams.put("coursewareReadOver", coursewareReadOver);

            request = new Request(ServerInterfaceDefinition.OPT_TOCOMMENTCURRENTCOURSEWARE, jsonObjectParams, new
                    ToSendCompleteParser());

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return request;


    }

    public Request getMyLesssonNotesListRequest(String page, String pageSize, String teacherId, String lessonTitle) {


        Request request = null;
        Map<String, String> paramsMap = new HashMap<String, String>();


        try {

            paramsMap.put("lessonTitle", lessonTitle);
            paramsMap.put("teacherId", teacherId);
            paramsMap.put("page", page);
            paramsMap.put("pageSize", pageSize);

            request = new Request(ServerInterfaceDefinition.OPT_GETMYLESSONNOTESLIST, paramsMap, new
                    MyLessonNotesListParser());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request getMyLesssonNotesDeatilRequest(String myLessonId, String realName, String
            remarkId) {


        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();

        try {
            paramsMap.put("id", myLessonId);
            paramsMap.put("realName", realName);
            paramsMap.put("remarkId", remarkId);


            request = new Request(ServerInterfaceDefinition.OPT_GETMYLESSONNOTESDETAIL, paramsMap, new
                    MyLesssonNotesDeatilParser());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request getToCommitLessonNotesRequest(String submitStatus, String id, String subjectId,
                                                 String
                                                         subjectName, String lessonTitle, String lessonType, String gradeId, String gradeName,
                                                 String classId, String className, String
                                                         lessonContext, String lessonAdvice,
                                                 String month, String day, String num,
                                                 String lessonTeacher, String schoolId, String
                                                         userId) {


        Request request = null;
        JSONObject jsonObjectParams = new JSONObject();
        JSONObject myLesson = new JSONObject();


        try {

            myLesson.put("submitStatus", submitStatus);
            myLesson.put("id", id);
            myLesson.put("subjectId", subjectId);
            myLesson.put("subjectName", subjectName);
            myLesson.put("lessonTitle", lessonTitle);
            myLesson.put("lessonType", lessonType);
            myLesson.put("gradeId", gradeId);
            myLesson.put("gradeName", gradeName);
            myLesson.put("classId", classId);
            myLesson.put("className", className);
            myLesson.put("lessonContext", lessonContext);
            myLesson.put("lessonAdvice", lessonAdvice);
            myLesson.put("month", month);
            myLesson.put("day", day);
            myLesson.put("num", num);
            myLesson.put("lessonTeacher", lessonTeacher);
            myLesson.put("schoolId", schoolId);
            jsonObjectParams.put("schoolId", schoolId);
            jsonObjectParams.put("userId", userId);
            jsonObjectParams.put("myLesson", myLesson);
            request = new Request(ServerInterfaceDefinition.OPT_TOCOMMITLESSONNOTES, jsonObjectParams, new
                    ToSendCompleteParser());

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return request;


    }

    public Request getMyStudyNotesListRequest(String page, String pageSize, String teacherId, String studyTitle) {

        Request request = null;
        Map<String, String> paramsMap = new HashMap<String, String>();


        try {

            paramsMap.put("studyTitle", studyTitle);
            paramsMap.put("teacherId", teacherId);
            paramsMap.put("page", page);
            paramsMap.put("pageSize", pageSize);

            request = new Request(ServerInterfaceDefinition.OPT_GETMYSTUDYNOTESLIST, paramsMap, new
                    MyStudyNotesListParser());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request getMyMeetingRecordNotesListRequest(String page, String pageSize, String teacherId, String meetTitle) {
        Request request = null;
        Map<String, String> paramsMap = new HashMap<String, String>();


        try {

            paramsMap.put("meetTitle", meetTitle);
            paramsMap.put("teacherId", teacherId);
            paramsMap.put("page", page);
            paramsMap.put("pageSize", pageSize);

            request = new Request(ServerInterfaceDefinition.OPT_GETMYMEETINGRECORDNOTESLIST,
                    paramsMap, new
                    MyMyMeetingRecordListParser());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request getMyMeetingRecordNotesDetailRequest(String id, String realName, String remarkId) {


        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();

        try {
            paramsMap.put("id", id);
            paramsMap.put("realName", realName);
            paramsMap.put("remarkId", remarkId);


            request = new Request(ServerInterfaceDefinition.OPT_GETMYMETTINGRECORDNOTESDETAIL, paramsMap, new
                    MyMeetingRecordNotesDetailParser());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request gettoCommitMeetingRecordRequest(String submitStatus, String id, String meetTitle,
                                                   String meetTime, String meetAddress,
                                                   String meetHost, String speaker, String
                                                           spokesMan,
                                                   String allPerson, String meetContext, String
                                                           userId, String schoolId) {


        Request request = null;
        JSONObject jsonObjectParams = new JSONObject();
        JSONObject meetRecord = new JSONObject();
        JSONObject userContext = new JSONObject();


        try {

            meetRecord.put("submitStatus", submitStatus);
            meetRecord.put("id", id);
            meetRecord.put("meetTitle", meetTitle);
            meetRecord.put("meetTime", meetTime);
            meetRecord.put("meetAddress", meetAddress);
            meetRecord.put("meetHost", meetHost);
            meetRecord.put("speaker", speaker);
            meetRecord.put("spokesMan", spokesMan);
            meetRecord.put("allPerson", allPerson);
            meetRecord.put("meetContext", meetContext);


            userContext.put("userId", userId);
            userContext.put("schoolId", schoolId);


            jsonObjectParams.put("meetRecord", meetRecord);
            jsonObjectParams.put("userContext", userContext);

            request = new Request(ServerInterfaceDefinition.OPT_TOCOMMITMEETINGRECORD, jsonObjectParams, new
                    ToSendCompleteParser());

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return request;


    }

    public Request getStudyNotesDetailRequest(String id, String realName, String remarkId) {


        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();

        try {
            paramsMap.put("id", id);
            paramsMap.put("realName", realName);
            paramsMap.put("remarkId", remarkId);


            request = new Request(ServerInterfaceDefinition.OPT_GETMYSTUDYNOTESDETAIL, paramsMap,
                    new
                            MyStudyNotesDetailParser());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request gettoCommitStudyNotesRequest(String submitStatus, String id, String studyTitle,
                                                String teacherId,
                                                String studyTime, String studyAddress, String studySource,
                                                String learnNotes, String learnLesson, String schoolId,
                                                String schoolName, String teacherName) {


        Request request = null;
        JSONObject jsonObjectParams = new JSONObject();
        JSONObject studyNotes = new JSONObject();


        try {

            studyNotes.put("submitStatus", submitStatus);
            studyNotes.put("id", id);
            studyNotes.put("studyTitle", studyTitle);
            studyNotes.put("teacherId", teacherId);
            studyNotes.put("studyTime", studyTime);
            studyNotes.put("studyAddress", studyAddress);
            studyNotes.put("studySource", studySource);
            studyNotes.put("learnNotes", learnNotes);

            studyNotes.put("learnLesson", learnLesson);
            studyNotes.put("schoolId", schoolId);
            studyNotes.put("schoolName", schoolName);
            studyNotes.put("teacherName", teacherName);
            jsonObjectParams.put("studyNotes", studyNotes);
            request = new Request(ServerInterfaceDefinition.OPT_TOCOMMITTUDYNOTES, jsonObjectParams,
                    new ToSendCompleteParser());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return request;


    }

    public Request getMyActivitiesOfTeachAndResearchRequest(String page, String pageSize, String teacherId, String centerTitle) {


        Request request = null;
        Map<String, String> paramsMap = new HashMap<String, String>();


        try {

            paramsMap.put("meetTitle", centerTitle);
            paramsMap.put("teacherId", teacherId);
            paramsMap.put("page", page);
            paramsMap.put("pageSize", pageSize);

            request = new Request(ServerInterfaceDefinition.OPT_GETACTIVITIESOFTEACHANDRESEARCHLIST,
                    paramsMap, new
                    MyActivitiesOfTeachAndResearchParser());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request getMyActivitiesOfTeachAndResearchDetailRequest(String id, String realName, String remarkId) {

        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();

        try {
            paramsMap.put("id", id);
            paramsMap.put("realName", realName);
            paramsMap.put("remarkId", remarkId);


            request = new Request(ServerInterfaceDefinition.OPT_GETACTIVITIESOFTEACHANDRESEARCHDETAIl, paramsMap, new
                    MyActivitiesOfTeachAndResearchDetailParser());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request getoCommitActivitiesofTeachAndResearchRequest(String submitStatus, String id,
                                                                 String teacherId, String rgroup, String rtime,
                                                                 String address, String allPerson, String centerTitle, String activityContent,
                                                                 String simpleReview, String schoolId, String schoolName, String teacherName) {


        Request request = null;
        JSONObject jsonObjectParams = new JSONObject();
        JSONObject researchActivity = new JSONObject();


        try {

            researchActivity.put("submitStatus", submitStatus);
            researchActivity.put("id", id);
            researchActivity.put("teacherId", teacherId);
            researchActivity.put("rgroup", rgroup);
            researchActivity.put("submitStatus", submitStatus);
            researchActivity.put("rtime", rtime);
            researchActivity.put("address", address);
            researchActivity.put("allPerson", allPerson);
            researchActivity.put("centerTitle", centerTitle);
            researchActivity.put("activityContent", activityContent);
            researchActivity.put("simpleReview", simpleReview);
            researchActivity.put("schoolId", schoolId);
            researchActivity.put("schoolName", schoolName);
            researchActivity.put("teacherName", teacherName);


            jsonObjectParams.put("researchActivity", researchActivity);

            request = new Request(ServerInterfaceDefinition.OPT_TOCOMMITACTIVITIESOFTEACHANDRESEARCH, jsonObjectParams,
                    new ToSendCompleteParser());

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return request;


    }

    public Request getToMarkReadOrNORequest(String id, String type) {

        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();

        try {
            paramsMap.put("id", id);
            paramsMap.put("type", type);


            request = new Request(ServerInterfaceDefinition.OPT_TOMARKREADORNO, paramsMap, new
                    ToSendCompleteParser());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request getCountOfScheduleRequest(String userId) {

        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();
        try {

            paramsMap.put("userId", userId);

            request = new Request(ServerInterfaceDefinition.OPT_COUNTOFSCHEDULE, paramsMap, new
                    CountOfScheduleParser());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request getReceivedAfficheDetailRequest(String id) {

        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();


        try {
            paramsMap.put("id", id);

            request = new Request(ServerInterfaceDefinition.OPT_RECEIVEDAFFICHEDETAIL, paramsMap, new
                    ReceivedAfficheDetailParser());


        } catch (Exception e) {


            e.printStackTrace();
        }


        return request;
    }

    public Request getReceivedNoticeDetailRequest(String noticeId) {
        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();


        try {
            paramsMap.put("noticeId", noticeId);

            request = new Request(ServerInterfaceDefinition.OPT_RECEIVEDNOTICEDETAIL, paramsMap, new
                    ReceivedNoticeDetailParser());


        } catch (Exception e) {


            e.printStackTrace();
        }


        return request;
    }

    public Request getApprovalDetailRequest(String teacherId, String id) {

        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();


        try {
            paramsMap.put("id", id);
            paramsMap.put("teacherId", teacherId);

            request = new Request(ServerInterfaceDefinition.APPROVALDETAIL, paramsMap, new
                    ApprovalDetailParser());


        } catch (Exception e) {


            e.printStackTrace();
        }


        return request;


    }

    public Request getRelatedGrammarListRequest(String userId, String gradeId, String subjectId,
                                                String
                                                        subjectType) {

        Request request = null;

        Map<String, String> paramsMap = new HashMap<String, String>();


        try {
            paramsMap.put("userId", userId);
            paramsMap.put("gradeId", gradeId);
            paramsMap.put("subjectId", subjectId);
            paramsMap.put("subjectType", subjectType);

            request = new Request(ServerInterfaceDefinition.OTP_RELATEDGRAMMARLIST, paramsMap, new
                    RelatedGrammarListParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;


    }

    public Request getSchoolContactsListRequest(String schoolId) {
        Request request = null;
        Map<String, String> paramMap = new HashMap<>();
        try {
            paramMap.put("schoolId", schoolId);
            request = new Request(ServerInterfaceDefinition.OPT_SCHOOLCONTACTSLIST, paramMap, new
                    SchoolContactsListParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;
    }

    public Request getCommitNumberListRequest(String page, String pageSize, String teacherName,
                                              String userId, String schoolName, String gradeName,
                                              String subjectId1) {
        Request request = null;
        JSONObject jsonObject = new JSONObject();
        JSONObject userContext = new JSONObject();
        try {
            userContext.put("userId", userId);
            userContext.put("schoolId", schoolName);
            jsonObject.put("page", page);
            jsonObject.put("pageSize", pageSize);
            jsonObject.put("gradeName", gradeName);
            jsonObject.put("subjectName", subjectId1);
            jsonObject.put("userContext", userContext);
            jsonObject.put("teacherName", teacherName);
            request = new Request(ServerInterfaceDefinition.OPT_LOOKUPNUMLIST, jsonObject, new
                    CommitNumberListParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;
    }
}
