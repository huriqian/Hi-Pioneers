package com.jfinal.admin.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseScore<M extends BaseScore<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}
	
	public void setSno(java.lang.String Sno) {
		set("Sno", Sno);
	}
	
	public java.lang.String getSno() {
		return getStr("Sno");
	}
	
	public void setPno(java.lang.Integer Pno) {
		set("Pno", Pno);
	}
	
	public java.lang.Integer getPno() {
		return getInt("Pno");
	}
	
	public void setScore(java.lang.Integer score) {
		set("score", score);
	}
	
	public java.lang.Integer getScore() {
		return getInt("score");
	}
	
	public void setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
	}
	
	public java.util.Date getUpdateTime() {
		return getDate("update_time");
	}
	
}
