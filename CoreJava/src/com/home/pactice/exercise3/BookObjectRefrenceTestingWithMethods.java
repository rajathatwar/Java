package com.home.pactice.exercise3;

public class BookObjectRefrenceTestingWithMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b = new Book();
		b.setBookName("CoreJava");
		b.setBookAuthor("Murli Sir");
		b.setBookId(01);
		b.setBookPrice(100);

		System.out.println("Before Discount Price is : " + b.getBookPrice() + " For book: " + b.getBookName()
				+ " Published By Author: " + b.getBookAuthor() + " And BookId is: " + b.getBookId());
		System.out.println();

		Month m1 = new Month();

		m1.setMonthName("January");
		String monthName = m1.getMonthName();

		BookObjectRefrenceTestingWithMethods test = new BookObjectRefrenceTestingWithMethods();

		System.out.println("Using If Else");
		test.calculateBookFinalPrice(b, monthName);
		System.out.println("Discount in month: " + monthName + " is " + b.getBookDiscount()
				+ " And Price After Discount  is $: " + b.getBookPrice() + " For book: " + b.getBookName()
				+ " Published By Author: " + b.getBookAuthor() + " And BookId is: " + b.getBookId());

		Book b2 = new Book();

		b2.setBookName("CoreJava");
		b2.setBookAuthor("Murli Sir");
		b2.setBookId(01);
		b2.setBookPrice(100);

		Month m2 = new Month();

		m2.setMonthName("June");
		monthName = m2.getMonthName();
		System.out.println();
		System.out.println("Use of Switch Case");
		test.calculateBookFinalPriceUsingSwitchCase(b2, monthName);

		System.out.println("Discount in month: " + monthName + " is " + b2.getBookDiscount()
				+ " And Price After Discount  is $: " + b2.getBookPrice() + " For book: " + b2.getBookName()
				+ " Published By Author: " + b2.getBookAuthor() + " And BookId is: " + b2.getBookId());

	}

	private void calculateBookFinalPrice(Book b1, String monthName) {
		double price = b1.getBookPrice();
		if (monthName.equals("January") || monthName.equals("February") || monthName.equals("March")
				|| monthName.equals("April")) {
			b1.setBookDiscount(15);
		} else {
			if (monthName.equals("May") || monthName.equals("June") || monthName.equals("July")
					|| monthName.equals("August")) {

				b1.setBookDiscount(10);

			} else {
				b1.setBookDiscount(0);
			}
		}
		int dis = b1.getBookDiscount();
		double bookPrice = price - (((double) dis / 100) * price);
		b1.setBookPrice(bookPrice);
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
