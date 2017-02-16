package cn.huischool.huixiao.db;

import com.hyphenate.easeui.controller.EaseUI;
import com.hyphenate.easeui.domain.EaseUser;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

import cn.huischool.huixiao.bean.SchoolContactsListBean;
import cn.huischool.huixiao.common.utils.CollectionUtils;
import cn.huischool.huixiao.db.dbbean.ContactPerson;

/**
 * Created by ${han} on 2016/12/14.
 */

public class DbHelper {
    private static DbHelper instance;

    public static DbHelper getInstance() {

        if (instance == null) {
            Connector.getDatabase();//创建数据库 建立联系人表
            return new DbHelper();

        }
        return instance;
    }


    public static void saveContatcsData(SchoolContactsListBean.ResultsBean list) {
        int gradeCount = list.getGradeClsssList().size();

        for (int i = 0; i < gradeCount; i++) {
            int classCount =
                    list.getGradeClsssList()
                            .get(i)
                            .getClsssTeacherList()
                            .size();
            for (int j = 0; j < classCount; j++) {
                int teacherCount =
                        list.getGradeClsssList()
                                .get(i)
                                .getClsssTeacherList().get(j).getTeacherList().size();

                for (int k = 0; k < teacherCount; k++) {
                    SchoolContactsListBean.ResultsBean.GradeClsssListBean.ClsssTeacherListBean
                            .TeacherListBean teacherListBean =
                            list.getGradeClsssList()
                                    .get(i)
                                    .getClsssTeacherList().get(j).getTeacherList().get(k);


                    //先查询有无此userId
                    List<ContactPerson> queryList = DataSupport.where("userId=?", teacherListBean
                            .getId()).find(ContactPerson.class);
                    if (CollectionUtils.isListNull(queryList)) {
                        //若没有 则插入此对象
                        ContactPerson contactPerson = new ContactPerson();
                        contactPerson.setDuty(teacherListBean.getDuty());
                        contactPerson.setEmail(teacherListBean.getEmail());
                        contactPerson.setUserId(teacherListBean.getId());
                        contactPerson.setRealName(teacherListBean.getRealName());
                        contactPerson.setImgUrl(teacherListBean.getImgUrl());
                        contactPerson.setPhone(teacherListBean.getPhone());
                        contactPerson.save();
                    }

                }
            }
        }


        int subjubtCount = list.getSubjectList().size();

        for (int i = 0; i < subjubtCount; i++) {

            int teacherCount = list.getSubjectList().get(i).getTeacherList().size();

            for (int j = 0; j < teacherCount; j++) {

                SchoolContactsListBean.ResultsBean.SubjectListBean.TeacherListBean teacherListBean = list
                        .getSubjectList().get(i)
                        .getTeacherList()
                        .get(j);

                //先查询有无此userId
                List<ContactPerson> queryList = DataSupport.where("userId=?", teacherListBean
                        .getId()).find(ContactPerson.class);
                if (CollectionUtils.isListNull(queryList)) {
                    //若没有 则插入此对象
                    ContactPerson contactPerson = new ContactPerson();
                    contactPerson.setDuty(teacherListBean.getDuty());
                    contactPerson.setEmail(teacherListBean.getEmail());
                    contactPerson.setUserId(teacherListBean.getId());
                    contactPerson.setRealName(teacherListBean.getRealName());
                    contactPerson.setImgUrl(teacherListBean.getImgUrl());
                    contactPerson.setPhone(teacherListBean.getPhone());
                    contactPerson.save();
                }


            }


        }

        int leaderCount = list.getLeaderList().size();

        for (int i = 0; i < leaderCount; i++) {

            int teacherCount = list.getLeaderList().get(i).getTeacherList().size();

            for (int j = 0; j < teacherCount; j++) {

                SchoolContactsListBean.ResultsBean.LeaderListBean.TeacherListBean teacherListBean = list
                        .getLeaderList().get(i)
                        .getTeacherList()
                        .get(j);

                //先查询有无此userId
                List<ContactPerson> queryList = DataSupport.where("userId=?", teacherListBean
                        .getId()).find(ContactPerson.class);
                if (CollectionUtils.isListNull(queryList)) {
                    //若没有 则插入此对象
                    ContactPerson contactPerson = new ContactPerson();
                    contactPerson.setDuty(teacherListBean.getDuty());
                    contactPerson.setEmail(teacherListBean.getEmail());
                    contactPerson.setUserId(teacherListBean.getId());
                    contactPerson.setRealName(teacherListBean.getRealName());
                    contactPerson.setImgUrl(teacherListBean.getImgUrl());
                    contactPerson.setPhone(teacherListBean.getPhone());
                    contactPerson.save();
                }


            }


        }

        EaseUI.getInstance().setUserProfileProvider(new EaseUI.EaseUserProfileProvider() {
            @Override
            public EaseUser getUser(String username) {
                //从数据库中返回 联系人信息

                List<ContactPerson> queryList = DataSupport.where("userId=?", username).find
                        (ContactPerson.class);
                EaseUser easeUser = new EaseUser(queryList.get(0).getRealName());
                easeUser.setAvatar(queryList.get(0).getImgUrl());
                return easeUser;
            }
        });


    }


}
