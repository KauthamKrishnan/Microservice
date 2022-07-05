package com.kk.moviecatalogservice.resources;

import com.kk.moviecatalogservice.models.CatalogItem;
import com.kk.moviecatalogservice.models.MovieInfoItem;
import com.kk.moviecatalogservice.models.Rating;
import com.kk.moviecatalogservice.models.UserRating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);
		// TODO For each movie ID, call movie info service and get details
		return ratings.getUserRatings().stream().map(rating -> {
			MovieInfoItem movie = restTemplate.getForObject("http://movie-info-service/movieinfo/" + rating.getMovieId(),
					MovieInfoItem.class);
			
			// TODO Put them all together
			return new CatalogItem(movie.getName(), "Desc", rating.getRating());
		})
				.collect(Collectors.toList());
	}
	
	/*
	 * MovieInfoItem movie = webClientBuilder.build()
	 * .get()
	 * .uri("http://localhost:8082/movieinfo/" + rating.getMovieId())
	 * .retrieve()
	 * .bodyToMono(MovieInfoItem.class)
	 * .block();
	 */
}