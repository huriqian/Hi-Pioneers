/**
 * 本项目采用《JFinal 俱乐部授权协议》，保护知识产权，就是在保护我们自己身处的行业。
 * 
 * Copyright (c) 2011-2021, jfinal.com
 */

package com.jfinal.admin.question;

import com.jfinal.admin.common.BaseController;
import com.jfinal.admin.common.LayoutInterceptor;
import com.jfinal.admin.common.model.Question;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.core.Path;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;

/**
 * 博客管理控制层
 */
@Path("/admin/question")
public class QuestionAdminController extends BaseController {

	@Inject
	QuestionAdminService srv;

	/**
	 * 列表与搜索
	 */
	public void index() {
		// pn 为分页号 pageNumber
		int pn = getInt("pn", 1);
		String keyword = get("keyword");

		Page<Question> page = StrKit.isBlank(keyword)
								? srv.paginate(pn)
								: srv.search(keyword, pn);

		// 保持住 keyword 变量，便于输出到搜索框的 value 中
		keepPara("keyword");
		set("page", page);
		render("index.html");
	}

	/**
	 * 支持 switch 开关的发布功能
	 */
	public void publish() {
		Ret ret = srv.publish(getInt("id"), getBoolean("checked"));
		renderJson(ret);
	}

	/**
	 * 进入选择提醒页面
	 *
	 * 注意：使用独立于后台 layout 的页面 add_edit_full.html 时，需要清除掉 LayoutInterceptor 拦截器
	 */
	@Clear(LayoutInterceptor.class)
	public void add() {
		// render("add_edit.html");
		// 改用独立于后台 layout 的页面
		render("select_type.html");
	}

	public void add_edit_full_choice() {
		render("add_edit_full_choice.html");
	}
	/**
	 * 保存
	 */
	public void save() {
		Ret ret = srv.save(getLoginAccountId(), getBean(Question.class));
		renderJson(ret);
	}

	/**
	 * 进入修改页面
	 *
	 * 注意：使用独立于后台 layout 的页面 add_edit_full.html 时，需要清除掉 LayoutInterceptor 拦截器
	 */
	@Clear(LayoutInterceptor.class)
	public void edit() {
		set("question", srv.getById(getInt("id")));
		// render("add_edit.html");
		// 改用独立于后台 layout 的页面
		keepPara("pn");					// 将页号参数 pn 传递到页面使用
		render("select_type.html");
	}



	/**
	 * 更新
	 */
	public void update() {
		Ret ret = srv.update(getBean(Question.class));
		renderJson(ret);
	}

	/**
	 * 删除
	 */
	public void delete() {
		Ret ret = srv.deleteById(getInt("id"));
		renderJson(ret);
	}

	/**
	 * 预览文章
	 */
	@Clear(LayoutInterceptor.class)
	public void preview() {
		set("article", srv.getById(getInt("id")));
		render("preview.html");
	}

}



