package com.highradius;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class AddAction {
	Connection conn = null;

	public AddAction(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	public String addInDB(HashMap<String, String> data) throws SQLException {
		String sql = "INSERT INTO film (title, description, release_year, language_id, director, special_features, rating) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, data.get("title"));
			st.setString(2, data.get("description"));
			st.setInt(3, Integer.valueOf(data.get("release_year")));
			st.setInt(4, Integer.valueOf(data.get("language")));
			st.setString(5, data.get("director_name"));
			st.setString(6, data.get("special_features"));
			st.setString(7, data.get("rating"));
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		} finally {
			conn.close();
		}
		return "success";
	}
}
