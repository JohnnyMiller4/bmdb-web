package com.bmdb.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int year;
	private String rating;
	private String director;
	
	public Movie() {
		super();
	}

	public Movie(int id, String name, String rating, int year, String director) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.rating = rating;
		this.director = director;
	}

	public Movie(String name, String rating, int year, String director) {
		this.name = name;
		this.year = year;
		this.rating = rating;
		this.director = director;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Movie ID: " + id + ", Title: " + name + ", Release Year: " + year + ", Rating: " + rating + ", Director: " + director
				+ "]";
	}
}
