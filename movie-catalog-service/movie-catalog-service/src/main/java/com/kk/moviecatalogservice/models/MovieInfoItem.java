package com.kk.moviecatalogservice.models;

public class MovieInfoItem {
	private String movieId;
	private String name;

	public MovieInfoItem() {

	}

	public MovieInfoItem(String movieId, String name) {
		this.movieId = movieId;
		this.name = name;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}