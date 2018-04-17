package com.home.book;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

public class BookMainClass {
	public static void main(String[] args) {
		BookMainClass data = new BookMainClass();
		ArrayList<BookDetails> returnedListOfBooksDetails = new ArrayList<BookDetails>();
		HashMap<Integer, BookDetails> map = new HashMap<>();

		// ArrayList<BookDetails> books;// = new ArrayList<BookDetails>();
		// ArrayList<BookDetails> listOfBooks;

		System.out.println("************************************************************\n" + "	Welcome to Book Store\n"
				+ "************************************************************");

		while (true) {

			System.out.println("Please select one of the following options:\r\n" + "\r\n" + "1. Insert Book\r\n"
					+ "2. Update Book\r\n" + "3. Delete Book\r\n" + "4. Show the Book\r\n" + "5. Show all books\r\n"
					+ "6. Exit ");

			System.out.println("************************************************************");

			Scanner sc = new Scanner(System.in);

			int option = sc.nextInt();

			if (option == 1) {
				returnedListOfBooksDetails = data.loadBookObjects();

			} else {
				if (option == 2) {
					System.out.println("Enter id to be updated");
					int updateId = sc.nextInt();
					for (int i = 0; i < returnedListOfBooksDetails.size(); i++) {
						BookDetails b = returnedListOfBooksDetails.get(i);
						if (updateId == b.getBookId()) {
							b.setBookId(updateId);
							System.out.println("Enter book Name");
							b.setBookName(sc.next());
							System.out.println("Enter book price :$");
							b.setBookPrice(sc.nextDouble());
							break;
						}
					}

					/*
					 * map = new HashMap<Integer, BookDetails>(); for (BookDetails details :
					 * returnedListOfBooksDetails) { map.put(details.getBookId(), details); }
					 * 
					 * System.out.println("Enter id to be updated"); int updateId = sc.nextInt();
					 * BookDetails b = new BookDetails(); // map.replace(updateId,b. ); map.replace(
					 * updateId,b.getBookName(), b.g ,newValue);
					 */

				} else {

					if (option == 3) {

						System.out.println("Enter id to be delete");
						int removeId = sc.nextInt();
						for (int i = 0; i < returnedListOfBooksDetails.size(); i++) {
							BookDetails b = returnedListOfBooksDetails.get(i);
							if (removeId == b.getBookId()) {
								returnedListOfBooksDetails.remove(b);
								System.out.println("Book has been deleted");
								break;
							}

						}

						/*
						 * for (BookDetails details : returnedListOfBooksDetails) {
						 * map.put(details.getBookId(), details); } Iterator<Integer> iterator =
						 * map.keySet().iterator(); System.out.println(iterator.hasNext());
						 * while(iterator.hasNext()){ int id = iterator.next();
						 * System.out.println("Enter id to be removed"); int removeId = sc.nextInt();
						 * if(id==removeId){ iterator.remove(); } }
						 */

						/*
						 * 
						 * Set<Integer> setOfIds = map.keySet(); System.out.println("a"); for (int
						 * loop=0;loop<setOfIds.size();loop++) { System.out.println("a");
						 * System.out.println("Enter id to be removed"); int removeId = sc.nextInt(); if
						 * (setOfIds.contains(removeId) ) { map.remove(removeId);
						 * System.out.println("Removed :" + removeId); } }
						 */
					} else {
						if (option == 4) {

							for (BookDetails details : returnedListOfBooksDetails) {
								map.put(details.getBookId(), details);
							}
							System.out.println("Enter id to find");
							int searchId = sc.nextInt();

							for (Map.Entry<Integer, BookDetails> entry : map.entrySet()) {
								int key = entry.getKey();
								BookDetails val = entry.getValue();

								if (searchId == key) {
									System.out.println(key + ":" + val);
									break;
								}
							}

							/*
							 * System.out.println("Enter id to be find"); int searchId = sc.nextInt();
							 * for(int i=0;i<returnedListOfBooksDetails.size();i++) { BookDetails b
							 * =returnedListOfBooksDetails.get(i); if(searchId==b.getBookId()) {
							 * System.out.println(returnedListOfBooksDetails.get(i)); }
							 * 
							 * 
							 * }
							 */

						} else {
							if (option == 5) {
								for (int i = 0; i < returnedListOfBooksDetails.size(); i++) {

									System.out.println("Book id is : " + returnedListOfBooksDetails.get(i).getBookId());
									System.out.println(
											"Book name is : " + returnedListOfBooksDetails.get(i).getBookName());
									System.out.println("Book price before discount : "
											+ returnedListOfBooksDetails.get(i).getBookPrice());
									System.out.println();
								}
							} else {
								if (option == 6) {
									System.out.println("bye..");
									break;
								}
							}
						}
					}
				}
			}

			System.out.println("Do you want to continue press y");

			if (!("y".equals(sc.next()))) {
				break;
			}

		}

	}

	/*
	 * switch(option)
	 * 
	 * { case 1: break; case2 : break; case 3:
	 * 
	 * break; case 4: break; case 5: break; case 6: System.out.println("Thank-you");
	 * break; default: break;
	 * 
	 * }
	 */

	public ArrayList<BookDetails> loadBookObjects() {

		ArrayList<BookDetails> listOfBooks = new ArrayList<BookDetails>();
		// System.out.println("Size "+listOfBooks.size());

		Scanner in = new Scanner(System.in);
		System.out.println("Enter no of  book object to create: ");
		int size = in.nextInt();

		for (int i = 0; i < size; i++) {
			listOfBooks.add(new BookDetails());
			/*
			 * }
			 * 
			 * // listOfBooks.add(new Book()); // listOfBooks.add(new Book());
			 * 
			 * Book b1; for (int i = 0; i < listOfBooks.size(); i++) {
			 */

			BookDetails b1 = listOfBooks.get(i);

			System.out.println("Enter book Id");

			b1.setBookId(in.nextInt());
			System.out.println("Enter book Name");
			b1.setBookName(in.next());

			System.out.println("Enter book price :$");
			b1.setBookPrice(in.nextDouble());
		}

		return listOfBooks;

	}
}

/*
 * switch (option)
 * 
 * { case 1:
 * 
 * listOfBooks = new ArrayList<BookDetails>();
 * 
 * Scanner in = new Scanner(System.in);
 * System.out.println("Enter no of  book object to create: "); int size =
 * in.nextInt();
 * 
 * for (int i = 0; i < size; i++) { listOfBooks.add(new BookDetails());
 * 
 * BookDetails b1 = listOfBooks.get(i);
 * 
 * System.out.println("Enter book Id");
 * 
 * b1.setBookId(in.nextInt()); System.out.println("Enter book Name");
 * b1.setBookName(in.next()); System.out.println("Enter Authour name : ");
 * b1.setAuthorName(in.next()); System.out.println("Enter book price :$");
 * b1.setBookPrice(in.nextDouble()); } break; case 2:
 * System.out.println("Enter book id to update data :"); int updateId =
 * sc.nextInt(); for (int m = 0; m < listOfBooks.size(); m++) {
 * 
 * } break; case 3:
 * 
 * break; case 4: break; case 5:
 * 
 * break; case 6: System.out.println("Thank-you");
 * 
 * break; default: break;
 * 
 * }
 * 
 * }
 * 
 * public void loadBookObjects() {
 * 
 * }
 * 
 */
