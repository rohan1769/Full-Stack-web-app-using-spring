package com.highradius;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteAction {
    Connection conn = null;

    public DeleteAction(Connection conn) {
        // TODO Auto-generated constructor stub
        this.conn = conn;
    }

    public String deleteFromDB(ArrayList<Integer> film_ids) throws SQLException {
        String sql = "UPDATE film SET isDeleted= 1 WHERE film_id= ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            for (Integer i : film_ids) {
                st.setInt(1, i);
                st.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        } finally {
            conn.close();
        }
        return "success";
    }
}
