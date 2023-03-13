package com.exam.dto;

import java.util.HashSet;
import java.util.Set;

import com.exam.entity.Category;
import com.exam.entity.Question;

public class QuizDTO {
	private long qId;

	private String title;
	 
	private String descriptionString;

	private String maxMarks;

	private String numberOfQuestions;
	private boolean active =false;

	private Category category;

	
	private Set<Question> quetsions = new HashSet<>();

	public long getqId() {
		return qId;
	}
	public void setqId(long qId) {
		this.qId = qId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescriptionString() {
		return descriptionString;
	}
	public void setDescriptionString(String descriptionString) {
		this.descriptionString = descriptionString;
	}
	public String getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}
	public String getNumberOfQuestions() {
		return numberOfQuestions;
	}
	public void setNumberOfQuestions(String numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Question> getQuetsions() {
		return quetsions;
	}
	public void setQuetsions(Set<Question> quetsions) {
		this.quetsions = quetsions;
	}
	@Override
	public String toString() {
		return "QuizDTO [qId=" + qId + ", title=" + title + ", descriptionString=" + descriptionString + ", maxMarks="
				+ maxMarks + ", numberOfQuestions=" + numberOfQuestions + ", active=" + active + ", category="
				+ category + ", quetsions=" + quetsions + "]";
	}


}
