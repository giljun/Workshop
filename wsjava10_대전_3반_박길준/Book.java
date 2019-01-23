package com.ssafy;

public class Book {
	protected String isbn;
	protected String title;
	protected int price;
	protected int quantity;

	public Book() {
		super();
	}

	public Book(String isbn, String title, int price, int quantity) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return isbn + "|" + title + "|" + price + "|" + quantity;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
