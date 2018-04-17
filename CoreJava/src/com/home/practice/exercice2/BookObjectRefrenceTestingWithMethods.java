package com.home.practice.exercice2;

public class BookObjectRefrenceTestingWithMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b = new Book();
		b.setBookName("CoreJava");
		b.setBookAuthor("Murli Sir");
		b.setBookId(01);
		b.setBookPrice(100);
		b.setBookDiscount(15);
		System.out.println("Before Discount Price is : " + b.getBookPrice() + " For book: " + b.getBookName()
				+ " Published By Author: " + b.getBookAuthor() + " And BookId is: " + b.getBookId());

		BookObjectRefrenceTestingWithMethods test = new BookObjectRefrenceTestingWithMethods();
		test.calculateBookFinalPrice(b);
		System.out.println("After Discount Price is : " + b.getBookPrice() + " For book: " + b.getBookName()
				+ " Published By Author: " + b.getBookAuthor() + " And BookId is: " + b.getBookId());
	}

	private void calculateBookFinalPrice(Book b1) {
		double price = b1.getBookPrice();
		int dis = b1.getBookDiscount();
		double bookPrice = price - (((double) dis / 100) * price);
		b1.setBookPrice(bookPrice);
	}

}
