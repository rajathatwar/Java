package com.home.practice.exercise5;

import java.util.ArrayList;
import java.util.Scanner;

import com.home.pactice.exercise3.Book;

public class BookArrayTestAndReadDataFromScannerUsingArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		BookArrayTestAndReadDataFromScannerUsingArrayList data = new BookArrayTestAndReadDataFromScannerUsingArrayList();

		// ArrayList<Book> listOfBooksDetails = new ArrayList<Book>();

		ArrayList<Book> returnedListOfBooksDetails = data.loadBookObjects();

		for (int i = 0; i < returnedListOfBooksDetails.size(); i++) {

			System.out.println("Book id is : " + returnedListOfBooksDetails.get(i).getBookId());
			System.out.println("Book name is : " + returnedListOfBooksDetails.get(i).getBookName());
			System.out.println("Book price before discount : " + returnedListOfBooksDetails.get(i).getBookPrice());
		}
		for (int i = 0; i < returnedListOfBooksDetails.size(); i++) {

			System.out.println("Enter the month in which you want discount : ");

			String month1 = scanner.next();

			data.calculateBookFinalPriceUsingSwitchCase(returnedListOfBooksDetails.get(i), month1);
			System.out.println("Book Discounted price for month : " + month1 + " is "
					+ returnedListOfBooksDetails.get(i).getBookPrice() + " and we got discount of "
					+ returnedListOfBooksDetails.get(i).getBookDiscount());
		}

		scanner.close();

	}

	public ArrayList<Book> loadBookObjects() {

		ArrayList<Book> listOfBooks = new ArrayList<Book>();
		// System.out.println("Size "+listOfBooks.size());

		Scanner in = new Scanner(System.in);
		System.out.println("Enter no of  book object to create: ");
		int size = in.nextInt();

		for (int i = 0; i < size; i++) {
			listOfBooks.add(new Book());
			/*
			 * }
			 * 
			 * // listOfBooks.add(new Book()); // listOfBooks.add(new Book());
			 * 
			 * Book b1; for (int i = 0; i < listOfBooks.size(); i++) {
			 */

			Book b1 = listOfBooks.get(i);

			System.out.println("Enter book Id");

			b1.setBookId(in.nextInt());
			System.out.println("Enter book Name");
			b1.setBookName(in.next());
			System.out.println("Enter book price :$");
			b1.setBookPrice(in.nextDouble());
		}

		return listOfBooks;

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
