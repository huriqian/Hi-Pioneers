package com.jfinal.admin.exam;

import com.jfinal.admin.common.model.Exam;
import com.jfinal.admin.common.model.Paper;
import com.jfinal.admin.common.model.Question;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ExamAdminService {

    private static int pageSize = 15;

    private Exam dao = new Exam().dao();
    private Paper Pdao = new Paper().dao(); // 在 Exam 模块中引入 Paper 的数据库查询功能
    private Question Qdao = new Question().dao(); // 在 Exam 模块中引入 Question 的数据库查询功能

    /**
     * 分页
     */
    public Page<Exam> paginate(int pageNumber) {
        return dao.paginate(pageNumber, pageSize, "select *", "from exam order by update_time desc");
    }
    public Page<Paper> Ppaginate(int pageNumber) {
        return Pdao.paginate(pageNumber, pageSize, "select *", "from Paper order by update_time desc");
    }
    public Page<Question> Qpaginate(String[] id) {
        String sql = "select * from question where ";
        for (int i = 1; i < id.length ; i++) {
            if(i == 1){
                sql = sql + "id = " + id[i];
            } else {
                sql = sql + " or id = " + id[i];
            }
        }
        return Qdao.templateByString(sql, id[0]).paginate(1, pageSize);
    }

    /**
     * 获取所选试卷中的题目序号
     */
    public Paper getPaperContent(String id){
        String sql = "select * from Paper where id = " + id + " limit 1";
        return Pdao.findFirst(sql);
    }

    /**
     * 把试卷中涉及的题目数组传入，生成查询 sql 的语句
     */
    public Page<Question> showQuestion(String[] id) {
        String sql = "select * from question where " ;
        for (int i = 1; i < id.length ; i++) {
            if(i == 1){
                sql = sql + "id = " + id[i];
            } else {
                sql = sql + " or id = " + id[i];
            }
        }
        return Qdao.templateByString(sql, id[0]).paginate(1, pageSize);
    }

    /**
     * 删除
     */
    public Ret deleteById(int id) {
        try {
            Exam exam = dao.findById(id);
            exam.delete();
            return Ret.ok("msg", "删除成功");
        } catch (Exception e) {
            return Ret.fail("msg", "删除失败: " + e.getMessage());
        }
    }

    /**
     * 获取 id
     */
    public Exam getById(int id) {
        return dao.findById(id);
    }
    public Paper PgetById(int id) {
        return Pdao.findById(id);
    }

    /**
     * 将试卷信息储存到数据库
     */
    public Ret save(String exam_name, int paper_id, int account_id, Timestamp start_time, Time last_time, Exam exam) {
        exam.setExamName(exam_name);
        exam.setPaperId(paper_id);
        exam.setAccountId(account_id);
        exam.setStartTime(start_time);
        exam.setLastTime(last_time);
        exam.setState(exam.STATE_UNPUBLISHED); // 默认未发布
        exam.setUpdateTime(new Date());

        exam.save();
        return Ret.ok("msg", "创建成功");
    }
}