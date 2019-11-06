package com.bmdb.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cast {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int movieId;
	private int actorId;
	private String role;
	
	public Cast() {
		super();
	}

	public Cast(int id, int movieId, int actorId, String role) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.actorId = actorId;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Cast ID: " + id + ", Movie ID: " + movieId + ", Actor ID: " + actorId + ", Role: " + role;
	}
	
	

}
