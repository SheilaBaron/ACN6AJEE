package entities;

import java.text.SimpleDateFormat;

public class Post {
	/*
	 * ID - Numerico Unico User Date - Dia y hora Content - Texo
	 * 
	 */
	private int id;
	private User user;
	private long date;
	private String cotext;

	public Post(int id, User user, long date, String cotext) {
		super();
		this.id = id;
		this.user = user;
		this.date = date;
		this.cotext = cotext;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getDate() {
		return date;
	}

	public String getNiceDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(getDate());
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getCotext() {
		return cotext;
	}

	public void setCotext(String cotext) {
		this.cotext = cotext;
	}

}
