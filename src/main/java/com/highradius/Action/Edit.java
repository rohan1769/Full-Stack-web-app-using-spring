package com.highradius.Action;

import java.util.HashMap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.highradius.Manager.ManagerInterface;
import com.highradius.Model.Model;

public class Edit {
	private ManagerInterface mg;
	private String title;
	private String description;
	private Integer release_year;
	private Short language;
	private String special_features;
	private String director;
	private String rating;
	private Integer film_id;
	HashMap<String , String> filmData = new HashMap<String , String>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRelease_year() {
		return release_year;
	}

	public void setRelease_year(Integer release_year) {
		this.release_year = release_year;
	}

	public Short getLanguage() {
		return language;
	}

	public void setLanguage(Short language) {
		this.language = language;
	}

	public String getSpecial_features() {
		return special_features;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String execute() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		setMg((ManagerInterface) context.getBean("manager"));
		filmData.put("film_id", String.valueOf(getFilm_id()));
		filmData.put("title", getTitle());
		filmData.put("description", getDescription());
		filmData.put("release_year", String.valueOf(getRelease_year()));
		filmData.put("language", String.valueOf(getLanguage()));
		filmData.put("special_features", getSpecial_features());
		filmData.put("director", getDirector());
		filmData.put("rating", getRating());
		System.out.println(filmData);
		mg.editFilms(filmData);
		return "success";
	}

	public ManagerInterface getMg() {
		return mg;
	}

	public void setMg(ManagerInterface mg) {
		this.mg = mg;
	}

	public Integer getFilm_id() {
		return film_id;
	}

	public void setFilm_id(Integer film_id) {
		this.film_id = film_id;
	}

}
