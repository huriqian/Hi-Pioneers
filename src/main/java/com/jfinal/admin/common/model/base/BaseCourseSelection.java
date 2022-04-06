package com.jfinal.admin.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseCourseSelection<M extends BaseCourseSelection<M>> extends Model<M> implements IBean {

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
	
	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	public java.lang.String getName() {
		return getStr("name");
	}
	
	public void setCno(java.lang.String Cno) {
		set("Cno", Cno);
	}
	
	public java.lang.String getCno() {
		return getStr("Cno");
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
	
	public void setFinalExam(java.lang.Integer finalExam) {
		set("finalExam", finalExam);
	}
	
	public java.lang.Integer getFinalExam() {
		return getInt("finalExam");
	}
	
	public void setFinalWeight(java.lang.Integer finalWeight) {
		set("finalWeight", finalWeight);
	}
	
	public java.lang.Integer getFinalWeight() {
		return getInt("finalWeight");
	}
	
	public void setMidsemester(java.lang.Integer midsemester) {
		set("midsemester", midsemester);
	}
	
	public java.lang.Integer getMidsemester() {
		return getInt("midsemester");
	}
	
	public void setMidWeight(java.lang.Integer midWeight) {
		set("midWeight", midWeight);
	}
	
	public java.lang.Integer getMidWeight() {
		return getInt("midWeight");
	}
	
	public void setUsualScore(java.lang.Integer usualScore) {
		set("usualScore", usualScore);
	}
	
	public java.lang.Integer getUsualScore() {
		return getInt("usualScore");
	}
	
	public void setUsualWeight(java.lang.Integer usualWeight) {
		set("usualWeight", usualWeight);
	}
	
	public java.lang.Integer getUsualWeight() {
		return getInt("usualWeight");
	}
	
}

