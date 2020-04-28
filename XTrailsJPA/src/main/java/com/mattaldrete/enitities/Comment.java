package com.mattaldrete.enitities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String actualComment;

	@JoinColumn(name = "User_id")
	private Integer userId;

	@JoinColumn(name = "Trail_id")
	private Integer trailId;

	private Date datePosted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActualComment() {
		return actualComment;
	}

	public void setActualComment(String actualComment) {
		this.actualComment = actualComment;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTrailId() {
		return trailId;
	}

	public void setTrailId(Integer trailId) {
		this.trailId = trailId;
	}

	public Date getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

	public Comment() {

	}

	public Comment(Integer id, String actualComment, Integer userId, Integer trailId, Date datePosted) {
		super();
		this.id = id;
		this.actualComment = actualComment;
		this.userId = userId;
		this.trailId = trailId;
		this.datePosted = datePosted;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", actualComment=" + actualComment + ", userId=" + userId + ", trailId=" + trailId
				+ ", datePosted=" + datePosted + "]";
	}

}
