package com.mattaldrete.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "actual_comment")
	private String actualComment;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "trail_id")
	private Trail trail;

	@Column(name = "date_posted")
	private LocalDate datePosted;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Trail getTrail() {
		return trail;
	}

	public void setTrail(Trail trail) {
		this.trail = trail;
	}

	public LocalDate getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(LocalDate datePosted) {
		this.datePosted = datePosted;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", actualComment=" + actualComment + ", user=" + user + ", trail=" + trail
				+ ", datePosted=" + datePosted + "]";
	}

	public Comment(Integer id, String actualComment, User user, Trail trail, LocalDate datePosted) {
		super();
		this.id = id;
		this.actualComment = actualComment;
		this.user = user;
		this.trail = trail;
		this.datePosted = datePosted;
	}

	public Comment() {

	}

}
