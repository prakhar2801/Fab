package com.endorsement.endorse.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Skill {
    @Id
    @GeneratedValue
    @org.springframework.data.annotation.Id
    private Long id;
    private String name;
    @Relationship(type = "HAS_SKILL", direction = Relationship.INCOMING)
    private Set<User> users = new HashSet<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}

    // Getters and setters
}