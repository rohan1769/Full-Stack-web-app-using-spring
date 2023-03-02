package com.highradius.Manager;

import java.util.ArrayList;
import java.util.HashMap;

import com.highradius.DAO.FilmsDAOinterface;
import com.highradius.Model.Model;

public class Manager implements ManagerInterface {
	private FilmsDAOinterface ob;

	@Override
	public ArrayList<Model> fetchFilms(int start, int limit) {
		return ob.fetchFilmsFromDB(start, limit);

	}

	@Override
	public Model addFilms(Model data) {
		// TODO Auto-generated method stub
		return ob.addFilmsIntoDB(data);
	}

	
	
	@Override
	public HashMap<String , String> editFilms(HashMap<String , String> data) {
		// TODO Auto-generated method stub
		return ob.editFilmsIntoDB(data);
	}
	
	@Override
	public ArrayList<Integer> deleteFilms(ArrayList<Integer> film_ids) {
		return ob.deleteFilmsFromDB(film_ids);
	}
	
	

	public FilmsDAOinterface getOb() {
		return ob;
	}

	public void setOb(FilmsDAOinterface ob) {
		this.ob = ob;
	}

	

}
