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
	
	public void setStudentId(java.lang.String studentId) {
		set("studentId", studentId);
	}
	
	public java.lang.String getStudentId() {
		return getStr("studentId");
	}
	
	public void setPaperId(java.lang.Integer paperId) {
		set("paperId", paperId);
	}
	
	public java.lang.Integer getPaperId() {
		return getInt("paperId");
	}
	
	public void setScoreItems(java.lang.String scoreItems) {
		set("scoreItems", scoreItems);
	}
	
	public java.lang.String getScoreItems() {
		return getStr("scoreItems");
	}
	
	public void setScore(java.lang.Integer score) {
		set("score", score);
	}
	
	public java.lang.Integer getScore() {
		return getInt("score");
	}
	
	public void setObjectiveAnswer(java.lang.String objectiveAnswer) {
		set("objectiveAnswer", objectiveAnswer);
	}
	
	public java.lang.String getObjectiveAnswer() {
		return getStr("objectiveAnswer");
	}
	
	public void setUpdateTime(java.util.Date updateTime) {
		set("updateTime", updateTime);
	}
	
	public java.util.Date getUpdateTime() {
		return getDate("updateTime");
	}
	
	public void setSubjectiveAnswer(java.lang.String subjectiveAnswer) {
		set("subjectiveAnswer", subjectiveAnswer);
	}
	
	public java.lang.String getSubjectiveAnswer() {
		return getStr("subjectiveAnswer");
	}
	
	public void setTeacherId(java.lang.Integer teacherId) {
		set("teacherId", teacherId);
	}
	
	public java.lang.Integer getTeacherId() {
		return getInt("teacherId");
	}
	
}

