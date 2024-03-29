package com.jfinal.admin.exam;

import com.jfinal.admin.common.BaseController;
import com.jfinal.admin.common.model.Exam;
import com.jfinal.admin.common.model.Paper;
import com.jfinal.admin.common.model.Question;
import com.jfinal.aop.Inject;
import com.jfinal.core.Path;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;

/**
 * 考试管理控制层
 */
@Path(value = "/admin/exam", viewPath = "/admin/exam")
public class ExamAdminController extends BaseController {

    @Inject
    ExamAdminService srv;

    /**
     * 首页
     */
    public void index() {
        int pn = getInt("pn", 1);
        String keyword = get("keyword");

        Page<Exam> page = StrKit.isBlank(keyword)
                ? srv.paginate(pn)
                : srv.search(keyword, pn);
        keepPara("keyword");
        set("page", page);
        render("index.html");
    }

    /**
     * 保存
     */
    public void save() {
        int paper_id = getInt("paper_id");
        Ret ret = srv.save(paper_id, getLoginAccountId(), getBean(Exam.class));
        renderJson(ret);
    }

    /**
     * 删除
     */
    public void delete() {
        renderJson(srv.deleteById(getInt("id")));
    }

    /**
     * 选择需要发布的考试模块，会跳出数据库 Paper 中的试卷以供选择
     */
    public void choosePaper() {
        int pn = getInt("pn", 1);

        // 可以添加一些筛选模块在这里

        Page<Paper> page = srv.Ppaginate(pn);

        set("page", page);
        render("choose_paper.html");
    }

    public void setPaperPara() {
        int pn = getInt("pn", 1);
        Paper paper = srv.PgetById(getInt("id"));
        String[] questionId = paper.getContent().split("~~~");
        Page<Question> page = srv.Qpaginate(questionId);
        set("paper", paper).set("page", page);
        render("edit_exam_paper.html");
    }

}
