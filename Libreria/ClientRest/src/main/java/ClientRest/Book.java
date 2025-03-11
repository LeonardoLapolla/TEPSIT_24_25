package ClientRest;

import java.util.List;

public class Book {
	private long id;
	private String title;
	private String language;
	
	public Book(int id, String title, String language, List<Author> authors) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.authors = authors;
    }
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	private List<Author> authors;
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
}
