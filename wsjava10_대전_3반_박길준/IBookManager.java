package com.ssafy;

import java.util.ArrayList;

public interface IBookManager {
	void add(Book b); // 도서 최초 입력 기능

	ArrayList<Book> search(); // 전체 도서 정보 출력 기능

	// 도서가 판매되어 재고 수량을 빼는 기능
	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;

	// 도서가 구매되어 재고 수량을 더하는 기능
	void buy(String isbn, int quantity) throws ISBNNotFoundException;

	int getTotalAmount();// 재고 도서들의 수량* 금액을 하여 총 재고 금액을 구하여 리턴

	void open(); // 클래스 생성시에 호출되어 지며, 파일(“book.dat”)에 저장된 파일을 읽어서 ArrayList에 저장한다.

	void close();// 프로그램 종료시에 호출되어 지며, ArrayList에 있는 도서 정보를 파일로 저장한다
}
