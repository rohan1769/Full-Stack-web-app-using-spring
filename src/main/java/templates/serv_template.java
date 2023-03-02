package templates;

public class serv_template {
	private Integer film_id;
	private String title;
	private String director;
	private Integer release_year;
	private String language;
	private Integer language_id;
	private String rating;
	private String special_features;
	private String description;

	public void setFilm_id(Integer film_id) {
		this.film_id = film_id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDirector(String director) {
		if (director.length() != 0)
			this.director = director;
		else
			this.director = "null";

	}

	public void setRelease_year(Integer release_year) {
		this.release_year = release_year;
	}

	public void setLanguage(Integer language_id) {
		switch (language_id) {
			case 1:
				this.language = "English";
				break;
			case 2:
				this.language = "Italian";
				break;
			case 3:
				this.language = "Japanese";
				break;
			case 4:
				this.language = "Mandarin";
				break;
			case 5:
				this.language = "French";
				break;
			case 6:
				this.language = "German";
				break;
			case 7:
				this.language = "Mangolian";
				break;

		}
	}

	public Integer getLanguage_id() {
		return this.language_id;
	}

	public String getLanguage() {
		return this.language;
	}

	public String getDescription() {
		return this.description;
	}

	public Integer getFilm_id() {
		return this.film_id;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}

	public Integer getRelease_year() {
		// TODO Auto-generated method stub
		return this.release_year;
	}

	public String getRating() {
		// TODO Auto-generated method stub
		return this.rating;
	}

	public String getSpecial_features() {
		// TODO Auto-generated method stub
		return this.special_features;
	}

	public String getDirector() {
		// TODO Auto-generated method stub
		return this.director;
	}

	public int setLanguageFromUI(String language) {
		int lang_id = 0;
		switch (language) {
			case "English":
				lang_id = 0;
				break;
			case "Italian":
				lang_id = 1;
				break;
			case "Japanese":
				lang_id = 2;
				break;
			case "Mandarin":
				lang_id = 3;
				break;
			case "French":
				lang_id = 4;
				break;
			case "German":
				lang_id = 5;
				break;
			case "Mangolian":
				lang_id = 6;
				break;
		}
		return lang_id;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
