package com.endorsement.endorse.model;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "ENDORSED")
public class Endorsement {
    @Id
    @GeneratedValue
    @org.springframework.data.annotation.Id
    private Long id;

    @StartNode
    private User reviewer;

    @EndNode
    private User reviewee;

    @StartNode
    private Skill skill;

    private int score;
    private String reason;

	public User getReviewer() {
		return reviewer;
	}
	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}
	public User getReviewee() {
		return reviewee;
	}
	public void setReviewee(User reviewee) {
		this.reviewee = reviewee;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

    // Getters and setters


}
