package com.jfinal.admin.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAccount<M extends BaseAccount<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}
	
	public void setNickName(java.lang.String nickName) {
		set("nickName", nickName);
	}
	
	public java.lang.String getNickName() {
		return getStr("nickName");
	}
	
	public void setUserName(java.lang.String userName) {
		set("userName", userName);
	}
	
	public java.lang.String getUserName() {
		return getStr("userName");
	}
	
	public void setPassword(java.lang.String password) {
		set("password", password);
	}
	
	public java.lang.String getPassword() {
		return getStr("password");
	}
	
	public void setSalt(java.lang.String salt) {
		set("salt", salt);
	}
	
	public java.lang.String getSalt() {
		return getStr("salt");
	}
	
	public void setState(java.lang.Integer state) {
		set("state", state);
	}
	
	public java.lang.Integer getState() {
		return getInt("state");
	}
	
	/**
	 * 头像
	 */
	public void setAvatar(java.lang.String avatar) {
		set("avatar", avatar);
	}
	
	/**
	 * 头像
	 */
	public java.lang.String getAvatar() {
		return getStr("avatar");
	}
	
	/**
	 * 创建时间
	 */
	public void setCreated(java.util.Date created) {
		set("created", created);
	}
	
	/**
	 * 创建时间
	 */
	public java.util.Date getCreated() {
		return getDate("created");
	}
	
	/**
	 * 最后更新时间
	 */
	public void setUpdated(java.util.Date updated) {
		set("updated", updated);
	}
	
	/**
	 * 最后更新时间
	 */
	public java.util.Date getUpdated() {
		return getDate("updated");
	}
	
}

