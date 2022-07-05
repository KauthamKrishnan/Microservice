package com.kk.moviecatalogservice.models;

import java.util.List;

public class UserRating {
	private List<Rating> userRating;

	public List<Rating> getUserRatings() {
		return userRating;
	}

	public void setUserRatings(List<Rating> userRating) {
		this.userRating = userRating;
	}
}