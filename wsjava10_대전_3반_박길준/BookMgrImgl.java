package com.ssafy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BookMgrImgl implements IBookManager {
	private static BookMgrImgl bookManager;

	private BookMgrImgl() {
	}

	public static BookMgrImgl getInstance() {
		if (bookManager == null) {
			bookManager = new BookMgrImgl();
		}
		return bookManager;
	}

	// 최대 100개 저장할 수 있다.
	private ArrayList<Book> books = new ArrayList<>();

	@Override
	public void add(Book b) {
		books.add(b);
	}

	@Override
	public ArrayList<Book> search() {
		return books;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		int temp = 0;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				temp = books.get(i).getQuantity();
				if (temp - quantity < 0) {
					throw new QuantityException();
				} else {
					books.get(i).setQuantity(temp - quantity);
				}
				break;
			} else {
				throw new ISBNNotFoundException();
			}
		}

	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		// TODO Auto-generated method stub
		int temp = 0;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				temp = books.get(i).getQuantity();
				books.get(i).setQuantity(temp + quantity);
				break;
			} else {
				throw new ISBNNotFoundException();
			}
		}
	}

	@Override
	public int getTotalAmount() {
		int sum = 0;
		for (int i = 0; i < books.size(); i++) {
			sum += books.get(i).getQuantity() * books.get(i).getPrice();
		}
		return sum;
	}

	@Override
	public void open() {
		String fname = "book.txt";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fname));
			String msg = "";
			while ((msg = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(msg, "|");
				int kind = Integer.parseInt(st.nextToken().trim());
				if (kind == 1) {
					books.add(new Book(st.nextToken().trim(), st.nextToken().trim(),
							Integer.parseInt(st.nextToken().trim()), Integer.parseInt(st.nextToken().trim())));
				} else {
					books.add(new Magazine(st.nextToken().trim(), st.nextToken().trim(),
							Integer.parseInt(st.nextToken().trim()), Integer.parseInt(st.nextToken().trim()),
							Integer.parseInt(st.nextToken().trim())));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("파일을 읽는 도중에 예외가 발생하였습니다.");
		}

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		PrintWriter pw = null;

		try {
			pw = new PrintWriter(new FileWriter("book.txt", false), true);
			for (int i = 0; i < books.size(); i++) {
				String msg = "";
				Book b = books.get(i);
				if (b instanceof Magazine) {
					Magazine m = (Magazine)b;
					msg = String.format("2|%s|%s|%d|%d|%d", m.getIsbn(), m.getTitle(), m.getPrice(), m.getQuantity(), m.getMonth());
				} else {
					msg = String.format("1|%s|%s|%d|%d", b.getIsbn(), b.getTitle(), b.getPrice(), b.getQuantity());
				}
				pw.println(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
		System.out.println("책 저장 완료");
	}

	public void print() {
		for (Book b : books) {
			System.out.println(b);
		}
	}
	// --------------------------------------------------

}
