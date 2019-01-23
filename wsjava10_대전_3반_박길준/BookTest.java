package com.ssafy;

import java.util.ArrayList;

// 주석을 해제하시면 각 기능을 실행할 수 있습니다.

public class BookTest {

	public static void main(String[] args) {
		BookMgrImgl manager = BookMgrImgl.getInstance();
		// book.txt 파일에 있는 정보 받아오는 함수.
		manager.open();

		// 모든 도서 출력 기능.
		manager.print();
		System.out.println("-----------------------------------------------------");
		
		// sell 기눙 구현1(실행 테스트 시, 예외와 함께 프로그램이 종료되기 때문에, 주석처리했습니다.)
		try {
			manager.sell("123456", 11);
		} catch (QuantityException e) {
			System.out.println("재고가 모자랍니다.");
		} catch (ISBNNotFoundException e) {
			System.out.println("해당 isbn의 도서가 없습니다.");
		}
		System.out.println("-----------------------------------------------------");
		
		// sell 기눙 구현2(실행 테스트 시, 예외와 함께 프로그램이 종료되기 때문에, 주석처리했습니다.)
		try {
			manager.sell("111", 5);
		} catch (QuantityException e) {
			System.out.println("재고가 모자랍니다.");
		} catch (ISBNNotFoundException e) {
			System.out.println("해당 isbn의 도서가 없습니다.");
		}
		System.out.println("-----------------------------------------------------");
		
		// Buy 기능 구현(도서 구매 완료)
		try {
			manager.buy("123456", 26);
		} catch (ISBNNotFoundException e) {
			System.out.println("해당 isbn의 도서가 없습니다.");
		}

		manager.print();
		System.out.println("-----------------------------------------------------");
		
		// Buy 기능 구현2(도서번호가 일치하지 않을 떄)
		try {
			manager.buy("123336", 26);
		} catch (ISBNNotFoundException e) {
			System.out.println("해당 isbn의 도서가 없습니다.");
		}
		
		System.out.println("-----------------------------------------------------");
		// 재고 도서의 총 금액 구하기
		int total_price = manager.getTotalAmount();
		System.out.println("재고 도서의 총 금액 : " + total_price);
		
		System.out.println("-----------------------------------------------------");
		
		// 파일 입력 후, book.txt파일로 전송하기.
		manager.add(new Book("383838","보안의 정석", 25000, 8));
		manager.add(new Magazine("2223838","자바의 정석", 23000, 9, 11));
		
		// 데이터입력 후, book.txt 파일 확인.
		manager.close();
		
		System.out.println("-----------------------------------------------------");
	}

}
