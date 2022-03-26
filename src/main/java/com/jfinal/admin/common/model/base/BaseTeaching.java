package com.jfinal.admin.common.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseTeaching<M extends BaseTeaching<M>> extends Model<M> implements IBean {

    public void setId(java.lang.Integer id) {
        set("id", id);
    }

    public java.lang.Integer getId() {
        return getInt("id");
    }

    public void setCno(java.lang.String Cno) {
        set("Cno", Cno);
    }

    public java.lang.String getCno() {
        return getStr("Cno");
    }

    public void setTno(java.lang.String Tno) {
        set("Tno", Tno);
    }

    public java.lang.String getTno() {
        return getStr("Tno");
    }

    public void setUpdateTime(java.util.Date updateTime) {
        set("update_time", updateTime);
    }

    public java.util.Date getUpdateTime() {
        return getDate("update_time");
    }

}

