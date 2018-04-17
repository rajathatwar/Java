package com.home.practice.exercise5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.home.pactice.exercise3.Book;

public class BookDataUsingHashMap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		BookDataUsingHashMap data = new BookDataUsingHashMap();

		// ArrayList<Book> listOfBooksDetails = new ArrayList<Book>();

		HashMap<Integer, Book> returnedMap = data.loadBookObjects();

		Set keys = returnedMap.keySet();
		Iterator keyItrt = keys.iterator();
		while (keyItrt.hasNext()) {
			int key = (Integer) keyItrt.next();
			Book value = (Book) returnedMap.get(key);

			System.out.println("Book id is : " + value.getBookId());
			System.out.println("Book name is : " + value.getBookName());
			System.out.println("Book price before discount : " + value.getBookPrice());
		}

		Set keys2 = returnedMap.keySet();
		Iterator keyItrt2 = keys2.iterator();
		while (keyItrt2.hasNext()) {
			int key2 = (Integer) keyItrt2.next();
			Book value2 = (Book) returnedMap.get(key2);

			System.out.println("Enter the month in which you want discount : ");

			String month1 = scanner.next();

			data.calculateBookFinalPriceUsingSwitchCase(value2, month1);
			System.out.println("Book Discounted price for month : " + month1 + " is " + value2.getBookPrice()
					+ " and we got discount of " + value2.getBookDiscount());
		}

		scanner.close();

	}

	public HashMap<Integer, Book> loadBookObjects() {

		HashMap<Integer, Book> hmap = new HashMap<Integer, Book>();
		// hmap.put(01, "All Book Values Comma Seprated");
while(true) {
		Book b1 = new Book();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter book Id");
		b1.setBookId(in.nextInt());
		System.out.println("Enter book Name");
		b1.setBookName(in.next());
		System.out.println("Enter book price :$");
		b1.setBookPrice(in.nextDouble());
		hmap.put(1, b1);
		Scanner inn = new Scanner(System.in);
		System.out.println("If you dont want to continue press '0' else 1 to continue");
		if(inn.nextInt()==0) {
			break;
		}
}

	/*	Book b2 = new Book();

		System.out.println("Enter book Id");
		b2.setBookId(in.nextInt());
		System.out.println("Enter book Name");
		b2.setBookName(in.next());
		System.out.println("Enter book price :$");
		b2.setBookPrice(in.nextDouble());

		hmap.put(1, b1);
		hmap.put(2, b2);*/

		return hmap;
	}

	private void calculateBookFinalPriceUsingSwitchCase(Book b1, String monthName) {
		double price = b1.getBookPrice();
		switch (monthName) {
		case "January":
		case "February":
		case "March":
		case "April":
			b1.setBookDiscount(15);
			break;
		case "May":
		case "June":
		case "July":
		case "August":
			b1.setBookDiscount(10);
			break;
		case "September":
		case "October":
		case "November":
		case "December":
			b1.setBookDiscount(0);
			break;
		default:
			System.out.println("You entered Wrong Data");
		}
		int dis = b1.getBookDiscount();
		double bookPrice = price - (((double) dis / 100) * price);
		b1.setBookPrice(bookPrice);

	}

}
