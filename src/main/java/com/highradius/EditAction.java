package com.highradius;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class EditAction {
    Connection conn = null;

    public EditAction(Connection conn) {
        // TODO Auto-generated constructor stub
        this.conn = conn;
    }

    public String editInDB(HashMap<String, String> data) throws SQLException {
        String sql = "UPDATE film SET title= ?, description= ? , release_year= ? , language_id= ? ,rating= ? , special_features= ? , director= ?   WHERE film_id=?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, data.get("title"));
            st.setString(2, data.get("description"));
            st.setInt(3, Integer.valueOf(data.get("release_year")));
            st.setInt(4, Integer.valueOf(data.get("language")));
            st.setString(5, data.get("rating"));
            st.setString(6, data.get("special_features"));
            st.setString(7, data.get("director_name"));
            st.setInt(8, Integer.valueOf(data.get("film_id")));
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
