package cn.huischool.huixiao.framework.achieve;

import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.AcceNotifiBean;
import cn.huischool.huixiao.bean.AfficheschBean;
import cn.huischool.huixiao.bean.AllGradeBean;
import cn.huischool.huixiao.bean.AllLeaderBean;
import cn.huischool.huixiao.bean.AllSubjectBean;
import cn.huischool.huixiao.bean.ApprovalDetailBean;
import cn.huischool.huixiao.bean.ApprovalReceiversOfTheRoleBean;
import cn.huischool.huixiao.bean.ApprovalSelectRoleListBean;
import cn.huischool.huixiao.bean.ChangeImageBean;
import cn.huischool.huixiao.bean.CheckCourseWareListBean;
import cn.huischool.huixiao.bean.CheckGrammarListBean;
import cn.huischool.huixiao.bean.CommitNumberListBean;
import cn.huischool.huixiao.bean.CountOfScheduleBean;
import cn.huischool.huixiao.bean.MyActivitiesOfTeachAndResearchBean;
import cn.huischool.huixiao.bean.MyActivitiesOfTeachAndResearchDetailBean;
import cn.huischool.huixiao.bean.MyCountInforBean;
import cn.huischool.huixiao.bean.MyCourseWareBean;
import cn.huischool.huixiao.bean.MyCourseWareDetailBean;
import cn.huischool.huixiao.bean.MyLessonNotesBean;
import cn.huischool.huixiao.bean.MyLesssonNotesDeatilBean;
import cn.huischool.huixiao.bean.MyMeetingRecordNotesBean;
import cn.huischool.huixiao.bean.MyMeetingRecordNotesDetailBean;
import cn.huischool.huixiao.bean.MyStudyNotesBean;
import cn.huischool.huixiao.bean.MyStudyNotesDetailBean;
import cn.huischool.huixiao.bean.MyTeacherPlanBean;
import cn.huischool.huixiao.bean.MyTeacherPlanDetailBean;
import cn.huischool.huixiao.bean.OfOneGradeAllClassBean;
import cn.huischool.huixiao.bean.OfOneGradeTeacherBean;
import cn.huischool.huixiao.bean.ReceivApprovalBean;
import cn.huischool.huixiao.bean.ReceivedAfficheDetailBean;
import cn.huischool.huixiao.bean.ReceivedNoticeDetailBean;
import cn.huischool.huixiao.bean.RelatedGrammarListBean;
import cn.huischool.huixiao.bean.SchoolContactsListBean;
import cn.huischool.huixiao.bean.SchoolShareCourseWareBean;
import cn.huischool.huixiao.bean.SchoolShareLessonPlansBean;
import cn.huischool.huixiao.bean.ToSendCompleteBean;
import cn.huischool.huixiao.bean.YetSendAfficheBean;
import cn.huischool.huixiao.bean.YetSendApprovalListBean;
import cn.huischool.huixiao.bean.YetSendNotifiBean;
import cn.huischool.huixiao.constants.Constant;
import cn.huischool.huixiao.framework.BaseResponse;
import cn.huischool.huixiao.framework.base.CustomApplication;
import cn.huischool.huixiao.framework.network.HttpRequestAsyncTask.OnCompleteListener;
import cn.huischool.huixiao.framework.network.Request;
import cn.huischool.huixiao.framework.network.RequestMaker;
import cn.huischool.huixiao.framework.util.NetUtils;

/**
 * 从网络层获得数据处理 所有的的发送网络请求的方法都写到这
 *
 * @author han
 *         <p/>
 *         2016-4-15
 */
public class DataAchieve {
    public static class ResponseNull extends BaseResponse {
    }

    /*1服务器异常返回null
    * 2网络连接不可用 返回code=-1000 提醒网络未连接
    * 3服务器返回 code!=1000*/
    public static <T> void getNetWorkDate(Request request,
                                          OnCompleteListener<T> onCompleteListener) {
        if (NetUtils.isNetDeviceAvailable(CustomApplication.customApplication)) {
            CustomApplication.requestNetWork(request, onCompleteListener);
        } else {
            Toast.makeText(CustomApplication.customApplication,
                    R.string.network_is_not_available, Toast.LENGTH_SHORT).show();
            onCompleteListener.onComplete((T) request.getJsonParser().parse(JSON.toJSONString(new
                    ResponseNull())), "");
        }
    }

    //回调接口往ui界面传递数据
    public interface SuccessCallBack {
        void handle(int code, Object object);
    }

    //判断code
    private static void checkCode(BaseResponse result, final SuccessCallBack successCallBack) {
        if (result != null) {
            if (result.code == 1000) {
                successCallBack.handle(result.code, result);
            } else {
                successCallBack.handle(result.code, null);
            }
        } else {
            successCallBack.handle(-1, null);
            Toast.makeText(CustomApplication.customApplication,
                    Constant.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
        }
    }

    // 登录请求处理
    public static void login(final SuccessCallBack successCallBack,
                             String userName, String password) {
        Request request = RequestMaker.getInstance().getLoginRequest(userName,
                password);
        getNetWorkDate(request, new OnCompleteListener<BaseResponse>() {
            @Override
            public void onComplete(BaseResponse result, String resultString) {
                checkCode(result, successCallBack);
            }
        });

    }

    // 已接受通知列表接口处理
    public static void acceNotifi(final SuccessCallBack successCallBack,
                                  String createTime, String orderType, String page, String pageSize,
                                  String schoolId, String teacherId, String title) {
        Request request = RequestMaker.getInstance().getAcceNotifiRequest(
                createTime, orderType, page, pageSize, schoolId, teacherId,
                title);
        getNetWorkDate(request, new OnCompleteListener<AcceNotifiBean>() {
            @Override
            public void onComplete(AcceNotifiBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }
    //已发送通知列表处理

    public static void yetSendNotfi(final SuccessCallBack successCallBack,
                                    String createTime, String orderType, String page, String pageSize,
                                    String schoolId, String teacherId, String title) {
        Request request = RequestMaker.getInstance().getYetSendNoticeRequest(
                createTime, orderType, page, pageSize, schoolId, teacherId, title);
        getNetWorkDate(request, new OnCompleteListener<YetSendNotifiBean>() {
            @Override
            public void onComplete(YetSendNotifiBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }

    //通知详情
    public static void ReceivedNoticeDetail(final SuccessCallBack successCallBack,
                                            String noticeId) {
        Request request = RequestMaker.getInstance().getReceivedNoticeDetailRequest(noticeId);
        getNetWorkDate(request, new OnCompleteListener<ReceivedNoticeDetailBean>() {
            @Override
            public void onComplete(ReceivedNoticeDetailBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });


    }





/*给通知公告标记已读未读*/

    public static void toMarkReadOrNO(final SuccessCallBack successCallBack, String id, String type) {


        Request request = RequestMaker.getInstance().getToMarkReadOrNORequest(
                id, type);
        getNetWorkDate(request, new OnCompleteListener<ToSendCompleteBean>() {
            @Override
            public void onComplete(ToSendCompleteBean result, String resultString) {

                checkCode(result, successCallBack);
            }
        });


    }


    //发送通知

    public static void toSendNotifi(final SuccessCallBack successCallBack,
                                    String userId, String schoolId,
                                    String title, String content, String sendeeType, String sendeeIds,
                                    String gradeId1,
                                    String gradeId2, String classId1,
                                    String gradeId3, String subjectId2,
                                    String subjectId1,
                                    String gradeId4,
                                    String hasSend

    ) {

        Request request = RequestMaker.getInstance().getToSendNotifiRequest(
                userId, schoolId,
                title, content, sendeeType, sendeeIds,
                gradeId1,
                gradeId2, classId1,
                gradeId3, subjectId2,
                subjectId1,
                gradeId4,
                hasSend);
        getNetWorkDate(request, new OnCompleteListener<ToSendCompleteBean>() {
            @Override
            public void onComplete(ToSendCompleteBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });

    }


    //已接受学校公告列表
    public static void affiche(final SuccessCallBack successCallBack,
                               String createTime, String orderType, String page, String pageSize,
                               String schoolId, String teacherId) {

        Request request = RequestMaker.getInstance().getAfficheRequest(
                createTime, orderType, page, pageSize, schoolId, teacherId);
        getNetWorkDate(request, new OnCompleteListener<AfficheschBean>() {
            @Override
            public void onComplete(AfficheschBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });

    }


    //已发送公告列表

    public static void YetSendaffiche(final SuccessCallBack successCallBack,
                                      String createTime, String orderType, String page, String pageSize,
                                      String schoolId, String teacherId, String title) {

        Request request = RequestMaker.getInstance().getYetSendAfficheRequest(
                createTime, orderType, page, pageSize, schoolId, teacherId, title);
        getNetWorkDate(request, new OnCompleteListener<YetSendAfficheBean>() {
            @Override
            public void onComplete(YetSendAfficheBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });

    }

    //公告详情
    public static void ReceivedAfficheDetail(final SuccessCallBack successCallBack,
                                             String id) {

        Request request = RequestMaker.getInstance().getReceivedAfficheDetailRequest(id);

        getNetWorkDate(request, new OnCompleteListener<ReceivedAfficheDetailBean>() {
            @Override
            public void onComplete(ReceivedAfficheDetailBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });


    }


    //发送公告
    public static void ToSendAffiche(final SuccessCallBack successCallBack,
                                     String title, String content, String schoolId, String
                                             senderId, String hasSended
    ) {

        Request request = RequestMaker.getInstance().getToSendAfficheRequest(
                title, content, schoolId, senderId, hasSended);
        getNetWorkDate(request, new OnCompleteListener<ToSendCompleteBean>() {
            @Override
            public void onComplete(ToSendCompleteBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });

    }

    //首页轮播
    public static void checkImg(final SuccessCallBack successCallBack,
                                String schoolId
    ) {

        final Request request = RequestMaker.getInstance().getChangeImageRequest(
                schoolId);
        getNetWorkDate(request, new OnCompleteListener<ChangeImageBean>() {
            @Override
            public void onComplete(ChangeImageBean result, String resultString) {

                checkCode(result, successCallBack);
            }
        });

    }

    //我的资料

    public static void myCouInfo(final SuccessCallBack successCallBack,
                                 String schoolId, String teacherId
    ) {

        final Request request = RequestMaker.getInstance().getMyCountInforRequest(
                schoolId, teacherId);
        getNetWorkDate(request, new OnCompleteListener<MyCountInforBean>() {
            @Override
            public void onComplete(MyCountInforBean result, String resultString) {

                checkCode(result, successCallBack);
            }
        });

    }

    //修改资料

    public static void updatePassword(final SuccessCallBack successCallBack,
                                      String teacherId, String Password, String newPassword
    ) {

        Request request = RequestMaker.getInstance().getUpdatePasswordRequest(
                teacherId, Password, newPassword);
        getNetWorkDate(request, new OnCompleteListener<ToSendCompleteBean>() {
            @Override
            public void onComplete(ToSendCompleteBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });

    }

    //修改我的资料
    public static void updateMyCountInfor(final SuccessCallBack successCallBack,
                                          String teacherId, String realName,
                                          String phone,
                                          String qq,
                                          String mail
    ) {

        Request request = RequestMaker.getInstance().getMyCouUpdateRequest(teacherId, realName, phone, qq, mail);
        getNetWorkDate(request, new OnCompleteListener<ToSendCompleteBean>() {
            @Override
            public void onComplete(ToSendCompleteBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });

    }


    //本校所有领导

    public static void getAllLeaderList(final SuccessCallBack successCallBack,
                                        String userId,
                                        String schoolId
    ) {

        Request request = RequestMaker.getInstance().getAllLeaderRequest(userId, schoolId
        );
        getNetWorkDate(request, new OnCompleteListener<AllLeaderBean>() {
            @Override
            public void onComplete(AllLeaderBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });

    }

    //本校所有年级

    public static void getAllGradeList(final SuccessCallBack successCallBack,

                                       String schoolId
    ) {

        Request request = RequestMaker.getInstance().getAllGradeRequest(schoolId
        );
        getNetWorkDate(request, new OnCompleteListener<AllGradeBean>() {
            @Override
            public void onComplete(AllGradeBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });

    }


    //指定年级所有班级

    public static void getOfOneGradeClassList(final SuccessCallBack successCallBack,
                                              String gradeId
    ) {
        Request request = RequestMaker.getInstance().getOfOneGradeAllClassRequest(gradeId
        );
        getNetWorkDate(request, new OnCompleteListener<OfOneGradeAllClassBean>() {
            @Override
            public void onComplete(OfOneGradeAllClassBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }


    //本校所有学科
    public static void getAllSubjectList(final SuccessCallBack successCallBack,
                                         String schoolId
    ) {
        Request request = RequestMaker.getInstance().getAllSubjectRequest(schoolId
        );
        getNetWorkDate(request, new OnCompleteListener<AllSubjectBean>() {
            @Override
            public void onComplete(AllSubjectBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });
    }


    //指定年级所有教师

    public static void getOfOneGradeTeacherList(final SuccessCallBack successCallBack,
                                                String gradeId
    ) {
        Request request = RequestMaker.getInstance().getOfOneGradeTeacherRequest(gradeId
        );
        getNetWorkDate(request, new OnCompleteListener<OfOneGradeTeacherBean>() {
            @Override
            public void onComplete(OfOneGradeTeacherBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }

    //获取已发送申请列表

    public static void getYetSendApprovalList(final SuccessCallBack successCallBack, String
            teacherId, String page, String pageSize, String title, String ischecked) {

        Request request = RequestMaker.getInstance().getYetSendApprovalListRequest(
                teacherId, page, pageSize, title, ischecked);
        getNetWorkDate(request, new OnCompleteListener<YetSendApprovalListBean>() {
            @Override
            public void onComplete(YetSendApprovalListBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });


    }

    //获取接受申请列表
    public static void getReceivApprovalList(final SuccessCallBack successCallBack,
                                             String page, String pageSize, String teacherId,
                                             String title, String queryType) {

        Request request = RequestMaker.getInstance().getReceivApprovalListRequest(
                page, pageSize, teacherId, title, queryType);

        getNetWorkDate(request, new OnCompleteListener<ReceivApprovalBean>() {
            @Override
            public void onComplete(ReceivApprovalBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });

    }


    //审批详情
    public static void getApprovalDetail(final SuccessCallBack successCallBack, String teacherId,
                                         String id) {
        Request request = RequestMaker.getInstance().getApprovalDetailRequest(teacherId,
                id);

        getNetWorkDate(request, new OnCompleteListener<ApprovalDetailBean>() {
            @Override
            public void onComplete(ApprovalDetailBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });

    }

    //审批批阅
    public static void toDecideApproval(final SuccessCallBack successCallBack,
                                        String id, String opinion, String comment, String
                                                teacherId, String schoolId, String approvalTime
    ) {

        Request request = RequestMaker.getInstance().gettoDecideApprovalRequest(
                id, opinion, comment, teacherId, schoolId, approvalTime);
        getNetWorkDate(request, new OnCompleteListener<ToSendCompleteBean>() {
            @Override
            public void onComplete(ToSendCompleteBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });

    }

    //校内共享 教案共享列表
    public static void togetSChoolShareLessonPlansList(final SuccessCallBack successCallBack,
                                                       String page, String pageSize, String schoolId) {
        Request request = RequestMaker.getInstance().getSchoolShareLessonPlansListRequest(page,
                pageSize, schoolId
        );
        getNetWorkDate(request, new OnCompleteListener<SchoolShareLessonPlansBean>() {
            @Override
            public void onComplete(SchoolShareLessonPlansBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });
    }

    // 校内共享 课件共享列表

    public static void togetSChoolShareCourseWareList(final SuccessCallBack successCallBack,
                                                      String page, String pageSize, String schoolId) {
        Request request = RequestMaker.getInstance().getSchoolShareCourseWareListRequest(page,
                pageSize, schoolId
        );
        getNetWorkDate(request, new OnCompleteListener<SchoolShareCourseWareBean>() {
            @Override
            public void onComplete(SchoolShareCourseWareBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }

    //审批申请可选角色

    public static void getApprovalSelectRoleList(final SuccessCallBack successCallBack,
                                                 String schoolId, String remarkId, String roleIds) {
        Request request = RequestMaker.getInstance().getApprovalSelectRoleListRequest(schoolId,
                remarkId,
                roleIds
        );
        getNetWorkDate(request, new OnCompleteListener<ApprovalSelectRoleListBean>() {
            @Override
            public void onComplete(ApprovalSelectRoleListBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });
    }

    //根据已选角色查询用户列表
    public static void getApprovalReceiversOfTheRole(final SuccessCallBack successCallBack,
                                                     String userId, String roleId) {
        Request request = RequestMaker.getInstance().getApprovalReceiversOfTheRoleRequest(userId,
                roleId
        );
        getNetWorkDate(request, new OnCompleteListener<ApprovalReceiversOfTheRoleBean>() {
            @Override
            public void onComplete(ApprovalReceiversOfTheRoleBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }

    //创建申请
    public static void toCreateApproval(final SuccessCallBack successCallBack, String userId,
                                        String schoolId, String content, String approversIds1,
                                        String approversIds2, String approversIds3, String
                                                approverAmount, String recipientIds,
                                        String recipientNames, String approvalType) {
        Request request = RequestMaker.getInstance().getToCreateApprovalRequest(userId,
                schoolId, content, approversIds1, approversIds2, approversIds3, approverAmount,
                recipientIds, recipientNames, approvalType
        );
        getNetWorkDate(request, new OnCompleteListener<ToSendCompleteBean>() {
            @Override
            public void onComplete(ToSendCompleteBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }


    // 我的教案列表

    public static void togetMyTeacherPlanList(final SuccessCallBack successCallBack,
                                              String page, String pageSize, String
                                                      teacherId, String lessonName, String
                                                      ischecked,String lessonType) {
        Request request = RequestMaker.getInstance().getMyTeacherPlanListRequest(page,
                pageSize, teacherId, lessonName, ischecked,lessonType
        );
        getNetWorkDate(request, new OnCompleteListener<MyTeacherPlanBean>() {
            @Override
            public void onComplete(MyTeacherPlanBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });
    }


    // 我的教案详情接口
    public static void togetMyTeacherPlanDetail(final SuccessCallBack successCallBack,
                                                String lessonId, String realName, String remarkId) {
        Request request = RequestMaker.getInstance().getMyTeacherPlanDetailRequest(lessonId,
                realName,
                remarkId);
        getNetWorkDate(request, new OnCompleteListener<MyTeacherPlanDetailBean>() {
            @Override
            public void onComplete(MyTeacherPlanDetailBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });
    }

    //批阅当前教案
    public static void toCommentCurrentGrammar(final SuccessCallBack successCallBack,
                                               String lessonId,
                                               String comment,
                                               String userId,
                                               String schoolId,
                                               String realName


    ) {
        Request request = RequestMaker.getInstance().getToCommentCurrentGrammarRequest(lessonId,
                comment, userId, schoolId, realName);

        getNetWorkDate(request, new OnCompleteListener<ToSendCompleteBean>() {
            @Override
            public void onComplete(ToSendCompleteBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }


    //检查教案
    public static void togetCheckGrammarList(final SuccessCallBack successCallBack,
                                             String remarkId, String schoolId,
                                             String subjectName, String gradeName,
                                             String searchName,
                                             String page, String pageSize) {
        Request request = RequestMaker.getInstance().getCheckGrammarListRequest(remarkId, schoolId,
                subjectName, gradeName,
                searchName,
                page, pageSize);


        getNetWorkDate(request, new OnCompleteListener<CheckGrammarListBean>() {
            @Override
            public void onComplete(CheckGrammarListBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });
    }

    //检查课件
    public static void togetCheckCourseWareList(final SuccessCallBack successCallBack,
                                                String remarkId, String schoolId,
                                                String subjectName, String gradeName,
                                                String searchName,
                                                String page, String pageSize) {
        Request request = RequestMaker.getInstance().getCheckCourseWareListRequest(remarkId, schoolId,
                subjectName, gradeName,
                searchName,
                page, pageSize);
        getNetWorkDate(request, new OnCompleteListener<CheckCourseWareListBean>() {
            @Override
            public void onComplete(CheckCourseWareListBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }

    //批阅当前课件
    public static void toCommentCurrentCourseWare(final SuccessCallBack successCallBack,
                                                  String coursewareId,
                                                  String comment,
                                                  String userId,
                                                  String schoolId,
                                                  String realName


    ) {
        Request request = RequestMaker.getInstance().getToCommentCurrentCourseWareRequest(coursewareId,
                comment, userId, schoolId, realName
        );

        getNetWorkDate(request, new OnCompleteListener<ToSendCompleteBean>() {
            @Override
            public void onComplete(ToSendCompleteBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }
    // 我的课件列表

    public static void togetMyCourseWareList(final SuccessCallBack successCallBack,
                                             String page, String pageSize, String
                                                     teacherId, String coursewareName,String
                                                     coursewareType, String
                                                     ischecked) {
        Request request = RequestMaker.getInstance().getMyCourseWareListRequest(page,
                pageSize, teacherId, coursewareName, coursewareType,ischecked
        );
        getNetWorkDate(request, new OnCompleteListener<MyCourseWareBean>() {
            @Override
            public void onComplete(MyCourseWareBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }

    // 我的课件详情接口

    public static void togetMyCourseWareDetail(final SuccessCallBack successCallBack,
                                               String coursewareId, String realName,
                                               String remarkId) {
        Request request = RequestMaker.getInstance().getMyCourseWareDetailRequest(coursewareId,
                realName, remarkId
        );
        getNetWorkDate(request, new OnCompleteListener<MyCourseWareDetailBean>() {
            @Override
            public void onComplete(MyCourseWareDetailBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }

    //我的听课记录
    public static void toGetMyLesssonNotesList(final SuccessCallBack successCallBack,
                                               String page, String pageSize, String teacherId,
                                               String lessonTitle) {
        Request request = RequestMaker.getInstance().getMyLesssonNotesListRequest(page, pageSize,
                teacherId, lessonTitle
        );
        getNetWorkDate(request, new OnCompleteListener<MyLessonNotesBean>() {
            @Override
            public void onComplete(MyLessonNotesBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }

    /*听课详情*/
    public static void toGetMyLesssonNotesDeatil(final SuccessCallBack successCallBack, String
            id,
                                                 String realName, String remarkId
    ) {

        Request request = RequestMaker.getInstance().getMyLesssonNotesDeatilRequest(id,
                realName, remarkId
        );
        getNetWorkDate(request, new OnCompleteListener<MyLesssonNotesDeatilBean>() {
            @Override
            public void onComplete(MyLesssonNotesDeatilBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });
    }

    /*提交听课记录*/
    public static void toCommitLessonNotes(final SuccessCallBack successCallBack,
                                           String submitStatus,
                                           String id,

                                           String subjectId,
                                           String subjectName,
                                           String lessonTitle,
                                           String lessonType,
                                           String gradeId,
                                           String gradeName,
                                           String classId,
                                           String className,
                                           String lessonContext,
                                           String lessonAdvice,
                                           String month,
                                           String day,
                                           String num,
                                           String lessonTeacher,
                                           String schoolId,
                                           String userId
    ) {

        Request request = RequestMaker.getInstance().getToCommitLessonNotesRequest(
                submitStatus,
                id,
                subjectId,
                subjectName,
                lessonTitle,
                lessonType,
                gradeId,
                gradeName,
                classId,
                className,
                lessonContext,
                lessonAdvice,
                month,
                day,
                num,
                lessonTeacher,
                schoolId,
                userId
        );
        getNetWorkDate(request, new OnCompleteListener<ToSendCompleteBean>() {
            @Override
            public void onComplete(ToSendCompleteBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }
/*获得笔记记录*/

    public static void toGetMyStudyNotesList(final SuccessCallBack successCallBack, String page, String pageSize, String teacherId, String studyTitle) {

        Request request = RequestMaker.getInstance().getMyStudyNotesListRequest(page, pageSize,
                teacherId, studyTitle
        );
        getNetWorkDate(request, new OnCompleteListener<MyStudyNotesBean>() {
            @Override
            public void onComplete(MyStudyNotesBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });
    }

    /*获得笔记详情*/
    public static void toGetMyStudyNotesDetail(final SuccessCallBack successCallBack, String
            id,
                                               String realName, String remarkId) {


        Request request = RequestMaker.getInstance().getStudyNotesDetailRequest(id,
                realName, remarkId
        );
        getNetWorkDate(request, new OnCompleteListener<MyStudyNotesDetailBean>() {
            @Override
            public void onComplete(MyStudyNotesDetailBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });
    }
    /*提交笔记*/

    public static void toCommitStudyNotes(final SuccessCallBack successCallBack, String
            submitStatus,
                                          String id,
                                          String studyTitle,
                                          String teacherId,
                                          String studyTime,
                                          String studyAddress,
                                          String studySource,
                                          String learnNotes,
                                          String learnLesson,
                                          String schoolId,
                                          String schoolName, String teacherName) {

        {
            Request request = RequestMaker.getInstance().gettoCommitStudyNotesRequest(

                    submitStatus,
                    id,
                    studyTitle,
                    teacherId,
                    studyTime,
                    studyAddress,
                    studySource,
                    learnNotes,
                    learnLesson,
                    schoolId,
                    schoolName,
                    teacherName
            );
            getNetWorkDate(request, new OnCompleteListener<ToSendCompleteBean>() {
                @Override
                public void onComplete(ToSendCompleteBean result, String resultString) {
                    checkCode(result, successCallBack);

                }
            });


        }
    }

    /*获得教研活动列表*/
    public static void toGetMyActivitiesOfTeachAndResearchList(final SuccessCallBack successCallBack, String page, String pageSize, String teacherId, String centerTitle) {
        Request request = RequestMaker.getInstance().getMyActivitiesOfTeachAndResearchRequest(page, pageSize,
                teacherId, centerTitle

        );
        getNetWorkDate(request, new OnCompleteListener<MyActivitiesOfTeachAndResearchBean>() {
            @Override
            public void onComplete(MyActivitiesOfTeachAndResearchBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });
    }
    /*获得教研活动详情*/

    public static void toGetMyActivitiesOfTeachAndResearchDetail(final SuccessCallBack successCallBack, String id, String realName, String remarkId) {

        Request request = RequestMaker.getInstance().getMyActivitiesOfTeachAndResearchDetailRequest(id,
                realName, remarkId
        );
        getNetWorkDate(request, new OnCompleteListener<MyActivitiesOfTeachAndResearchDetailBean>() {
            @Override
            public void onComplete(MyActivitiesOfTeachAndResearchDetailBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });

    }
    /*提交教研活动*/

    public static void toCommitActivitiesofTeachAndResearch(final SuccessCallBack
                                                                    successCallBack, String id,
                                                            String submitStatus, String teacherId,
                                                            String rgroup, String rtime, String address, String allPerson,
                                                            String centerTitle, String activityContent, String simpleReview,
                                                            String schoolId, String schoolName, String teacherName) {
        {

            Request request = RequestMaker.getInstance().getoCommitActivitiesofTeachAndResearchRequest(
                    id,
                    submitStatus,
                    teacherId,
                    rgroup,
                    rtime,
                    address,
                    allPerson,
                    centerTitle,
                    activityContent,
                    simpleReview,
                    schoolId,
                    schoolName, teacherName


            );
            getNetWorkDate(request, new OnCompleteListener<ToSendCompleteBean>() {
                @Override
                public void onComplete(ToSendCompleteBean result, String resultString) {
                    checkCode(result, successCallBack);
                }
            });
        }
    }
    /*获得会议记录表*/

    public static void toGetMyMeetingRecordNotesList(final SuccessCallBack successCallBack, String page, String pageSize, String teacherId, String meetTitle) {
        Request request = RequestMaker.getInstance().getMyMeetingRecordNotesListRequest(page, pageSize,
                teacherId, meetTitle

        );
        getNetWorkDate(request, new OnCompleteListener<MyMeetingRecordNotesBean>() {
            @Override
            public void onComplete(MyMeetingRecordNotesBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }
/*获得会议记录详情*/

    public static void toGetMyMeetingRecordNotesDetail(final SuccessCallBack successCallBack, String
            id,
                                                       String realName, String remarkId
    ) {
        Request request = RequestMaker.getInstance().getMyMeetingRecordNotesDetailRequest(id,
                realName, remarkId
        );
        getNetWorkDate(request, new OnCompleteListener<MyMeetingRecordNotesDetailBean>() {
            @Override
            public void onComplete(MyMeetingRecordNotesDetailBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }

    /*创建会议记录*/
    public static void toCommitMeetingRecord(final SuccessCallBack successCallBack, String
            submitStatus,
                                             String id,
                                             String meetTitle,
                                             String meetTime,
                                             String meetAddress,
                                             String meetHost,
                                             String speaker,
                                             String spokesMan,
                                             String allPerson,
                                             String meetContext,
                                             String userId, String schoolId) {
        {

            Request request = RequestMaker.getInstance().gettoCommitMeetingRecordRequest(
                    submitStatus,
                    id,
                    meetTitle,
                    meetTime,
                    meetAddress,
                    meetHost,
                    speaker,
                    spokesMan,
                    allPerson,
                    meetContext,
                    userId,
                    schoolId
            );
            getNetWorkDate(request, new OnCompleteListener<ToSendCompleteBean>() {
                @Override
                public void onComplete(ToSendCompleteBean result, String resultString) {
                    checkCode(result, successCallBack);

                }
            });
        }
    }

    // 提交反馈
    public static void toSubmitFeedback(final SuccessCallBack successCallBack,
                                        String userId, String schoolId,
                                        String suggestionType, String content, String createTime,
                                        String creater) {

        Request request = RequestMaker.getInstance().getSubmitFeedbackRequest(userId, schoolId,
                suggestionType, content, createTime, creater);
        getNetWorkDate(request, new OnCompleteListener<ToSendCompleteBean>() {
            @Override
            public void onComplete(ToSendCompleteBean result, String resultString) {
                checkCode(result, successCallBack);

            }
        });
    }

    //获得待办事项数量
    public static void getCountOfSchedule(final SuccessCallBack successCallBack, String userId) {
        Request request = RequestMaker.getInstance().getCountOfScheduleRequest(userId);
        getNetWorkDate(request, new OnCompleteListener<CountOfScheduleBean>() {
            @Override
            public void onComplete(CountOfScheduleBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }

    //课件关联的教案列表

    public static void getRelatedGrammarList(final SuccessCallBack successCallBack, String
            userId, String gradeId, String subjectId, String subjectType) {

        Request request = RequestMaker.getInstance().getRelatedGrammarListRequest(userId,
                gradeId, subjectId, subjectType);
        getNetWorkDate(request, new OnCompleteListener<RelatedGrammarListBean>() {
            @Override
            public void onComplete(RelatedGrammarListBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }

    //通讯录列表
    public static void getSchoolContactsList(final SuccessCallBack successCallBack, String schoolId) {

        Request request = RequestMaker.getInstance().getSchoolContactsListRequest(schoolId
        );
        getNetWorkDate(request, new OnCompleteListener<SchoolContactsListBean>() {
            @Override
            public void onComplete(SchoolContactsListBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });
    }

    //查阅提交的数量
    public static void getCommitNumberList(final SuccessCallBack successCallBack, String page, String
            pageSize, String teacherName, String userId, String schoolId, String gradeName, String
            subjectName
    ) {
        Request request = RequestMaker.getInstance().getCommitNumberListRequest(page,
                pageSize, teacherName, userId, schoolId, gradeName, subjectName);
        getNetWorkDate(request, new OnCompleteListener<CommitNumberListBean>() {
            @Override
            public void onComplete(CommitNumberListBean result, String resultString) {
                checkCode(result, successCallBack);
            }
        });


    }
}
