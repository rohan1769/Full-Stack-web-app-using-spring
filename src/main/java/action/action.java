//demo.java is the action class, if it returns success  

package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.highradius.AddAction;
import com.highradius.DeleteAction;
import com.highradius.EditAction;
import com.highradius.FetchAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import templates.serv_template;

public class action {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement st = null;

	private ArrayList<serv_template> films = new ArrayList<serv_template>();

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/sakila";

	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String LOGIN = "login";
	public static final String INPUT = "input";
	public static final String NONE = "none";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	// Getting the connection
	static String mysqlUrl = DB_URL;

	private Integer start;
	private Integer limit;
	private Integer total = 1000;

	private Integer film_id;
	private String title;
	private String special_features;
	private String rating;
	private String description;
	private Integer release_year;
	private String director_name;
	private String language;
	private ArrayList<Integer> film_ids;

	public String execute() throws SQLException, ClassNotFoundException {
		Class.forName(JDBC_DRIVER);
		String log = "";
		String actionName = ActionContext.getContext().getName();
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			switch (actionName) {
			case "fetch":
				FetchAction a1 = new FetchAction(conn);
				setFilms(a1.fetchFromDB(getStart(), getLimit()));
				log = getFilms().size() != 0 ? Action.SUCCESS : Action.ERROR;
				break;

			case "add":
				HashMap<String, String> addParams = new HashMap<String, String>();
				addParams.put("title", getTitle());
				addParams.put("special_features", getSpecial_features());
				addParams.put("rating", getRating());
				addParams.put("description", getDescription());
				addParams.put("release_year", String.valueOf(getRelease_year()));
				// setDirector_name(getDirector_name());
				addParams.put("director_name", getDirector_name());
				addParams.put("language", String.valueOf(getLanguage()));
				AddAction a2 = new AddAction(conn);
				log = a2.addInDB(addParams);
				// System.out.println(addParams);
				break;

			case "edit":
				HashMap<String, String> editParams = new HashMap<String, String>();
				editParams.put("film_id", String.valueOf(getFilm_id()));
				editParams.put("title", getTitle());
				editParams.put("special_features", getSpecial_features());
				editParams.put("rating", getRating());
				editParams.put("description", getDescription());
				editParams.put("release_year", String.valueOf(getRelease_year()));
				editParams.put("director_name", getDirector_name());
				editParams.put("language", String.valueOf(getLanguage()));
				EditAction a3 = new EditAction(conn);
				log = a3.editInDB(editParams);
				// System.out.println(editParams);
				break;

			case "delete":
				DeleteAction a4 = new DeleteAction(conn);
				log = a4.deleteFromDB(getFilm_ids());
				// System.out.println(getFilm_ids());
				break;
			default:
				log = Action.ERROR;
			}

			// System.out.println(actionName);
			// System.out.println(getFilms());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		System.out.println(log);
		return log;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public ArrayList<serv_template> getFilms() {
		return films;
	}

	public void setFilms(ArrayList<serv_template> films) {
		this.films = films;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getFilm_id() {
		return film_id;
	}

	public void setFilm_id(Integer film_id) {
		this.film_id = film_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecial_features() {
		return special_features;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDirector_name() {
		return director_name;
	}

	public void setDirector_name(String director_name) {
		// String d_name = getDirector_name() != null ? director_name : "null";
		this.director_name = director_name;
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

	public ArrayList<Integer> getFilm_ids() {
		return film_ids;
	}

	public void setFilm_ids(ArrayList<Integer> film_ids) {
		this.film_ids = film_ids;
	}

}
