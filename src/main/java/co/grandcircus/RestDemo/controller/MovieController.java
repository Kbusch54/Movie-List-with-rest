package co.grandcircus.RestDemo.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.grandcircus.RestDemo.Repo.MovieRepo;
import co.grandcircus.RestDemo.entity.Movie;

@RestController
public class MovieController {

	@Autowired
	MovieRepo mr;

	@GetMapping("/")
	public List<Movie> listMovies() {
		List<Movie> movieList = mr.findAll();

		return movieList;
	}

	// list all movies
	@GetMapping("find-movie-id/{id}")
	public Optional<Movie> findBook(@PathVariable("id") Long id) {
		Optional<Movie> movie = mr.findById((long) id);
		return movie;
	}

	// finds a single movie by title
	@GetMapping("find-movie-title/{title}")
	public Movie findMovieTitle(@PathVariable("title") String title) {
		Movie movie = mr.findByTitle(title);
		return movie;
	}

	// shows all the category types
	@GetMapping("category-types")
	public TreeSet<String> findyDistinctCategory() {
		return mr.findByDistinctCategory();

	}

	// lists the movies done by specific director
	@GetMapping("find-movie-director/{director}")
	public List<Movie> findMovieDirector(@PathVariable("director") String director) {
		List<Movie> movie = mr.findByDirector(director);
		return movie;
	}

	// list of all movies in specified category
	@GetMapping("find-movie-category/{category}")
	public List<Movie> findMovieCategory(@PathVariable("category") String category) {
		List<Movie> movie = mr.findByCategory(category);
		return movie;
	}

	// allows for keyword searches
	@GetMapping("find-by-keyword/{word}")
	public List<Movie> findByTitleContain(@PathVariable("word") String word) {
		List<Movie> movie = mr.findByTitleContains(word);
		return movie;
	}

	// random movie from specific category
	@GetMapping("rand-by-cat/{category}")
	public Movie findRandoMovieCategory(@PathVariable("category") String category) {
		List<Movie> movie = mr.findByCategory(category);
		int x = movie.size();
		Random r = new Random();
		int y = 0;
		y = r.nextInt(x);
		return movie.get(y);
	}

	// random movie from table
	@GetMapping("rando-single-movie")
	public Movie findrandoMovie() {
		List<Movie> movie = mr.findAll();
		Random r = new Random();
		return movie.get(r.nextInt(movie.size()));
	}

	// random list of movies with # specified by user
	@GetMapping("rando-list-movie/{x}")
	public List<Movie> findQRandoMovie(@PathVariable("x") int x) {
		List<Movie> movie = mr.findByRandomList(x);
		return movie;
	}

}
