package com.highradius.Manager;

import java.util.ArrayList;
import java.util.HashMap;

import com.highradius.Model.Model;

public interface ManagerInterface {
	public ArrayList<Model> fetchFilms(int start, int limit);
    
	public Model addFilms(Model data);

	
	
	

	public ArrayList<Integer> deleteFilms(ArrayList<Integer> film_ids);

	public HashMap<String, String> editFilms(HashMap<String, String> data);

}
