package com.bmdb.business;

import javax.persistence.*;

@Entity
public class Cast {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//annotation
	@ManyToOne
	@JoinColumn(name="MovieID")
	private Movie movie;
	//annotation
	@ManyToOne
	@JoinColumn(name="ActorID")
	private Actor actor;
	private String role;
	
	public Cast() {
		super();
	}

	public Cast(int id, Movie movie, Actor actor, String role) {
		super();
		this.id = id;
		this.movie = movie;
		this.actor = actor;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Cast ID: " + id + ", Movie: " + movie + ", Actor: " + actor + ", Role: " + role;
	}
	
	

}
