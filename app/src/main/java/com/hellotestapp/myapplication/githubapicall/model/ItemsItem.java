package com.hellotestapp.myapplication.githubapicall.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ItemsItem{

	@SerializedName("owner")
	private Owner owner;

	@SerializedName("content_license")
	private String contentLicense;

	@SerializedName("link")
	private String link;

	@SerializedName("last_activity_date")
	private int lastActivityDate;

	@SerializedName("creation_date")
	private int creationDate;

	@SerializedName("answer_count")
	private int answerCount;

	@SerializedName("title")
	private String title;

	@SerializedName("question_id")
	private int questionId;

	@SerializedName("tags")
	private List<String> tags;

	@SerializedName("score")
	private int score;

	@SerializedName("is_answered")
	private boolean isAnswered;

	@SerializedName("view_count")
	private int viewCount;

	@SerializedName("last_edit_date")
	private int lastEditDate;

	@SerializedName("accepted_answer_id")
	private int acceptedAnswerId;

	@SerializedName("protected_date")
	private int protectedDate;

	public void setOwner(Owner owner){
		this.owner = owner;
	}

	public Owner getOwner(){
		return owner;
	}

	public void setContentLicense(String contentLicense){
		this.contentLicense = contentLicense;
	}

	public String getContentLicense(){
		return contentLicense;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setLastActivityDate(int lastActivityDate){
		this.lastActivityDate = lastActivityDate;
	}

	public int getLastActivityDate(){
		return lastActivityDate;
	}

	public void setCreationDate(int creationDate){
		this.creationDate = creationDate;
	}

	public int getCreationDate(){
		return creationDate;
	}

	public void setAnswerCount(int answerCount){
		this.answerCount = answerCount;
	}

	public int getAnswerCount(){
		return answerCount;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setQuestionId(int questionId){
		this.questionId = questionId;
	}

	public int getQuestionId(){
		return questionId;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}

	public void setScore(int score){
		this.score = score;
	}

	public int getScore(){
		return score;
	}

	public void setIsAnswered(boolean isAnswered){
		this.isAnswered = isAnswered;
	}

	public boolean isIsAnswered(){
		return isAnswered;
	}

	public void setViewCount(int viewCount){
		this.viewCount = viewCount;
	}

	public int getViewCount(){
		return viewCount;
	}

	public void setLastEditDate(int lastEditDate){
		this.lastEditDate = lastEditDate;
	}

	public int getLastEditDate(){
		return lastEditDate;
	}

	public void setAcceptedAnswerId(int acceptedAnswerId){
		this.acceptedAnswerId = acceptedAnswerId;
	}

	public int getAcceptedAnswerId(){
		return acceptedAnswerId;
	}

	public void setProtectedDate(int protectedDate){
		this.protectedDate = protectedDate;
	}

	public int getProtectedDate(){
		return protectedDate;
	}
}