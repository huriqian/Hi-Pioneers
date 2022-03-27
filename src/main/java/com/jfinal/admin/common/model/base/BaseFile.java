package com.jfinal.admin.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseFile<M extends BaseFile<M>> extends Model<M> implements IBean {

	public void setID(java.lang.Integer ID) {
		set("ID", ID);
	}
	
	public java.lang.Integer getID() {
		return getInt("ID");
	}
	
	public void setAccountID(java.lang.Integer AccountID) {
		set("AccountID", AccountID);
	}
	
	public java.lang.Integer getAccountID() {
		return getInt("AccountID");
	}
	
	public void setPath(java.lang.String Path) {
		set("Path", Path);
	}
	
	public java.lang.String getPath() {
		return getStr("Path");
	}
	
	public void setFileName(java.lang.String FileName) {
		set("FileName", FileName);
	}
	
	public java.lang.String getFileName() {
		return getStr("FileName");
	}
	
	public void setShowName(java.lang.String ShowName) {
		set("ShowName", ShowName);
	}
	
	public java.lang.String getShowName() {
		return getStr("ShowName");
	}
	
	public void setLength(java.lang.Integer Length) {
		set("Length", Length);
	}
	
	public java.lang.Integer getLength() {
		return getInt("Length");
	}
	
	public void setCreated(java.util.Date Created) {
		set("Created", Created);
	}
	
	public java.util.Date getCreated() {
		return getDate("Created");
	}
	
}

