package co.grandcircus.RestDemo.Repo;

import java.util.List;
import java.util.TreeSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.grandcircus.RestDemo.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Long> {

	// any special queries can go in the Repo
	// but must follow proper naming conventions
	Movie findByTitle(String t);

	List<Movie> findByDirector(String d);

	@Query("select distinct category from Movie")
	TreeSet<String> findByDistinctCategory();

	List<Movie> findByCategory(String c);

//	@Query("select Distinct category from Movie order by Rand() limit 1")
//	Movie showRandomCategoryMovie();
//	@Query("select from Movie order by Rand() limit 1")
//	Movie showRandomMovie();

	List<Movie> findByTitleContains(String a);
	
	@Query(value="Select * from Movie order by Rand() limit ?", nativeQuery=true)
	List<Movie> findByRandomList(int x);

}
