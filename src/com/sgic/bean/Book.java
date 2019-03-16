package com.sgic.bean;

public class Book {
	private int id;
	private String bookId;
	private String title;
	private String author;
	private String mainclassification;
	private String subclassification;
	


	public int getId() {
		return id++;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMainclassification() {
		return mainclassification;
	}

	public void setMainclassification(String mainclassification) {
		this.mainclassification = mainclassification;
	}

	public String getSubclassification() {
		return subclassification;
	}

	public void setSubclassification(String subclassification) {
		this.subclassification = subclassification;
	}

}
