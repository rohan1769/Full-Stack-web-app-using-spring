package com.highradius.Action;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.highradius.Manager.ManagerInterface;
import com.highradius.Model.Model;

public class Delete {
	private ManagerInterface mg;
	private ArrayList<Integer> film_id;
	private ArrayList<Integer> film_ids;
	public ManagerInterface getMg() {
		return mg;
	}
	public void setMg(ManagerInterface mg) {
		this.mg = mg;
	}
	public ArrayList<Integer> getFilm_id() {
		return film_id;
	}
	public void setFilm_id(ArrayList<Integer> film_id) {
		this.film_id = film_id;
	}
	
	public String execute() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		setMg((ManagerInterface) context.getBean("manager"));
		
		setFilm_ids(mg.deleteFilms(film_id));
		System.out.println(film_id);
		mg.deleteFilms(film_ids);
		return "success";
	}
	public ArrayList<Integer> getFilm_ids() {
		return film_ids;
	}
	public void setFilm_ids(ArrayList<Integer> film_ids) {
		this.film_ids = film_ids;
	}

	
	
}
