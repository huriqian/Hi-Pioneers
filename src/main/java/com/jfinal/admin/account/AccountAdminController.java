/**
 * 本项目采用《JFinal 俱乐部授权协议》，保护知识产权，就是在保护我们自己身处的行业。
 * <p>
 * Copyright (c) 2011-2021, jfinal.com
 */

package com.jfinal.admin.account;

import com.jfinal.admin.common.BaseController;
import com.jfinal.admin.common.model.Account;
import com.jfinal.admin.common.model.Role;
import com.jfinal.admin.role.RoleAdminService;
import com.jfinal.aop.Inject;
import com.jfinal.core.Path;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * 账户管理控制层
 */
@Path("/admin/account")
public class AccountAdminController extends BaseController {

    @Inject
    AccountAdminService srv;

    @Inject
    RoleAdminService roleAdminSrv;

    /**
     * 列表与搜索
     */
    public void index() {
        // pn 为分页号 pageNumber
        int pn = getInt("pn", 1);
        String keyword = get("keyword");

        Page<Account> page = StrKit.isBlank(keyword)
                ? srv.paginate(pn)
                : srv.search(keyword, pn);

        // 保持住 keyword 变量，便于输出到搜索框的 value 中
        keepPara("keyword");
        set("page", page);
        render("index.html");
    }

    /**
     * 支持 switch 开关的 state 切换功能
     */
    public void switchState() {
        Ret ret = srv.switchState(getLoginAccountId(), getInt("id"), getBoolean("checked"));
        renderJson(ret);
    }

    /**
     * 进入创建页面
     */
    public void add() {
        render("add_edit.html");
    }

    /**
     * 保存
     */
    public void save() {
        Ret ret = srv.save(getBean(Account.class));
        renderJson(ret);
    }

    /**
     * 通过输入的届数、学院号、班级、和班级人数，生成这个班级同学的学号数组，用来批量传入数据库
     * 批量保存
     */
    public void batchSave() {
        Ret ret = null;

        String no = get("session");
        int college = Integer.parseInt(get("college"));
        no += (college < 10) ? ("0" + college) : (college);
        int classes = Integer.parseInt(get("class"));
        no += (classes < 10) ? ("0" + classes) : (classes);

        int number = Integer.parseInt(get("number"));
        for (int i = 1; i <= number; i++) {
            String studentId = "";
            studentId = (i < 10) ? (no + "0" + i) : (no + i);
            ret = srv.batchSave(getBean(Account.class), studentId);
            int accountId = srv.getAccountId(studentId);
            srv.addRole(accountId, 4);
        }
        renderJson(ret);
    }

    /**
     * 进入修改页面
     */
    public void edit() {
        keepPara("pn");    // 保持住分页的页号，便于在 ajax 提交后跳转到当前数据所在的页
        set("account", srv.edit(getInt("id")));
        render("add_edit.html");
    }

    /**
     * 更新
     */
    public void update() {
        Ret ret = srv.update(getLoginAccountId(), getBean(Account.class));
        renderJson(ret);
    }

    /**
     * 删除
     */
    public void delete() {
        Ret ret = srv.deleteById(getLoginAccountId(), getInt("id"));
        renderJson(ret);
    }

    /**
     * account 表内容导出到 excel 文件，用于备份
     */
    public void exportExcel() {
        renderJson(Ret.ok("msg", "后续版本添加导出 Excel 的功能 ^_^"));
    }


    // 角色相关业务 ------------------------------------------------------------

    /**
     * 分配角色
     */
    public void assignRoles() {
        Account account = srv.findById(getInt("id"));
        List<Role> roleList = roleAdminSrv.getAllRoles();
        srv.markAssignedRoles(account, roleList);

        set("account", account);
        set("roleList", roleList);
        render("assign_roles.html");
    }

    /**
     * switch 开关分配角色。约定参数 checked 在选中时为 true，否则为 false
     */
    public void assignRole() {
        if (getBoolean("checked")) {
            renderJson(srv.addRole(getInt("accountId"), getInt("roleId")));
        } else {
            renderJson(srv.deleteRole(getInt("accountId"), getInt("roleId")));
        }
    }

    /**
     * 显示 "后台账户/管理员" 列表，在 account_role 表中存在的账户(被分配过角色的账户)
     * 被定义为 "后台账户/管理员"
     * <p>
     * 该功能便于查看后台都有哪些账户被分配了角色，在对账户误操作分配了角色时，也便于取消角色分配
     */
    public void showAdminList() {
        List<Record> adminList = srv.getAdminList();
        set("adminList", adminList);
        render("admin_list.html");
    }

    /**
     * 批量导入学号功能
     */
    public void batchImport() {
        render("batch_import.html");
    }
}



