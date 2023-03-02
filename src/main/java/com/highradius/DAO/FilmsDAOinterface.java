package com.highradius.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import com.highradius.Model.Model;

public interface FilmsDAOinterface {
	public ArrayList<Model> fetchFilmsFromDB(int start, int limit);

    public ArrayList<Integer> deleteFilmsFromDB(ArrayList<Integer> film_ids);

	public Model addFilmsIntoDB(Model data);


	public HashMap<String, String> editFilmsIntoDB(HashMap<String, String> data);
}
