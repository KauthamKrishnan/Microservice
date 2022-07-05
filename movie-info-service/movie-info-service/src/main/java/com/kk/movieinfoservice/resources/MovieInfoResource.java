package com.kk.movieinfoservice.resources;

import com.kk.movieinfoservice.models.MovieInfoItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieinfo")
public class MovieInfoResource {

	@RequestMapping("/{movieId}")
	public MovieInfoItem getMovieInfo(@PathVariable("movieId") String movieId) {
		return new MovieInfoItem(movieId, "Test Name");
	}
}