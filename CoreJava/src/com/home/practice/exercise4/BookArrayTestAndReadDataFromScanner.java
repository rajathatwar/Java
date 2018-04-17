package com.home.practice.exercise4;

import java.util.Scanner;

import com.home.pactice.exercise3.Book;

public class BookArrayTestAndReadDataFromScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		BookArrayTestAndReadDataFromScanner data = new BookArrayTestAndReadDataFromScanner();
		Book[] returnBookData = data.loadBookObjects();
		for (int i = 0; i < returnBookData.length; i++) {
			System.out.println("Book id is : " + returnBookData[i].getBookId());
			System.out.println("Book name is : " + returnBookData[i].getBookName());
			System.out.println("Book price before discount : " + returnBookData[i].getBookPrice());
		}
		// String[] month = { "January", "June", "December" };
		for (int i = 0; i < returnBookData.length; i++) {

			System.out.println("Enter the month in which you want discount : ");

			String month1 = scanner.next();

			data.calculateBookFinalPriceUsingSwitchCase(returnBookData[i], month1);
			System.out
					.println("Book Discounted price for month : " + month1 + " is " + returnBookData[i].getBookPrice()
							+ " and we got discount of " + returnBookData[i].getBookDiscount());
		}
		scanner.close();
	}

	public Book[] loadBookObjects() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter size of object :");
		int size = in.nextInt();
		Book[] b1 = new Book[size];
		System.out.println(b1.length);

		for (int i = 0; i < b1.length; i++) {
			b1[i] = new Book();
			System.out.println("Enter book Id");
			b1[i].setBookId(in.nextInt());
			System.out.println("Enter book Name");
			b1[i].setBookName(in.next());
			System.out.println("Enter book price :$");
			b1[i].setBookPrice(in.nextDouble());

		}
		//in.close();
		return b1;

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
