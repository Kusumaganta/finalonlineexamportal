package com.exam.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quiz
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long qId;

private String title;
 
private String descriptionString;

private String maxMarks;

private String numberOfQuestions;
private boolean active =false;

@ManyToOne(fetch = FetchType.EAGER)
private Category category;

@OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY , cascade = CascadeType.ALL)// lazy means when getter will call then then it will call

@JsonIgnore
private Set<Question> quetsions = new HashSet<>();

public Quiz() {
	super();
}
public Quiz(long qId, String title, String descriptionString, String maxMarks, String numberOfQuestions,
		boolean active) {
	super();
	this.qId = qId;
	this.title = title;
	this.descriptionString = descriptionString;
	this.maxMarks = maxMarks;
	this.numberOfQuestions = numberOfQuestions;
	this.active = active;
}
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

}









