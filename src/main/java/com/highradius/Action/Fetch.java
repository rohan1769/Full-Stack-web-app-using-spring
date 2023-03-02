package com.highradius.Action;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.highradius.Manager.ManagerInterface;
import com.highradius.Model.Model;

public class Fetch {
	private int start, limit, total;

	private ManagerInterface mg;
	private ArrayList<Model> films;

	public String execute() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		setMg((ManagerInterface) context.getBean("manager"));
		System.out.println(getMg());
		setFilms(mg.fetchFilms(start, limit));
		setTotal(1000);
		context.close();
		return "success";
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public ManagerInterface getMg() {
		return mg;
	}

	public void setMg(ManagerInterface mg) {
		this.mg = mg;
	}

	public ArrayList<Model> getFilms() {
		return films;
	}

	public void setFilms(ArrayList<Model> films) {
		this.films = films;
	}
}
