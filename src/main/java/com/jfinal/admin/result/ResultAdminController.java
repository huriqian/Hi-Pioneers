package com.jfinal.admin.result;

import com.jfinal.admin.common.BaseController;
import com.jfinal.admin.common.model.Exam;
import com.jfinal.admin.common.model.Score;
import com.jfinal.admin.test.TestAdminService;
import com.jfinal.aop.Inject;
import com.jfinal.core.Path;
import com.jfinal.plugin.activerecord.Page;

@Path(value = "/admin/result", viewPath = "/admin/result")
public class ResultAdminController extends BaseController {
    @Inject
    ResultAdminService srv;

    public void index() {
        int accountId = getLoginAccountId();
        int roleId = srv.getRoleId(accountId);
        if (roleId == 4) { // 仅对于学生
            String StudentNo = srv.getAccNo(accountId);
            String[] course_name = srv.getStuCourse(StudentNo);
            Page<Score> page = srv.studentPaginate(getInt("pn", 1), StudentNo);
            set("page", page);
            render("student_index.html");
        }
        if (roleId==5){
            String TeacherNo = srv.getAccNo(accountId);
            String[] course_name = srv.getTeacherCourse(TeacherNo);
            Page<Score> page = srv.teacherPaginate(getInt("pn", 1),course_name);
            set("page", page);
            render("teacher_index.html");
        }
        if (roleId==6){
            String headNo = srv.getAccNo(accountId);
            String name = srv.getHeaderCourse(headNo);
            Page<Score> page = srv.headerPaginate(getInt("pn", 1),name);
            set("page", page);
            render("header_index.html");
        }
    }

//    public void showScore() {
//        int accountId = getLoginAccountId();
//        int roleId = srv.getRoleId(accountId);
//        if (roleId == 4) { // 学生
//            String StudentNo = srv.getAccNo(accountId);
//            String[] course_name = srv.getStuCourse(StudentNo);
//            Page<Score> page = srv.studentPaginate(getInt("pn", 1), course_name);
//            set("page", page);
//            render("index.html");
//        } else if (roleId == 5) { // 老师
//
//        } else if (roleId == 6) { // 学科主任
//
//        }
//    }
}
