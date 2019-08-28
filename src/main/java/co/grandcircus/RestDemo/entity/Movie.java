package co.grandcircus.RestDemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String director;
	private String category;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(String title, String director, String category) {
		super();
		this.title = title;
		this.director = director;
		this.category = category;
	}
	public Movie(long id, String title, String director, String category) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.category = category;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", Director=" + director + ", category=" + category + "]";
	}
	
	
}