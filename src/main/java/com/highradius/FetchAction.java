package com.highradius;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import templates.serv_template;

public class FetchAction {
    Connection conn = null;
    Statement stmt = null;

    private ArrayList<serv_template> films = new ArrayList<serv_template>();

    public FetchAction(Connection conn) {
        // TODO Auto-generated constructor stub
        this.conn = conn;
    }

    public ArrayList<serv_template> fetchFromDB(Integer start, Integer limit) throws SQLException {
        String sql = "SELECT film_id, title , director, release_year, language_id,rating, special_features, DESCRIPTION FROM film WHERE isDeleted != 1 LIMIT "
                + start + ", " + limit;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                serv_template data = new serv_template();
                data.setFilm_id(rs.getInt(1));
                data.setTitle(rs.getString(2));
                data.setDirector(rs.getString(3));
                data.setRelease_year(rs.getInt(4));
                data.setLanguage(rs.getInt(5));
                data.setRating(rs.getString(6));
                data.setSpecial_features(rs.getString(7));
                data.setDescription(rs.getString(8));
                films.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return films;// returns empty film json if error
        } finally {
            conn.close();
        }
        return films;
    }
}
