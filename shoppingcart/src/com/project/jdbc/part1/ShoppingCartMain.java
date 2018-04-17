package com.project.jdbc.part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartMain {
	public static int cust;

	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;

	public void userValidation() {
while(true) {
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String username = "SYSTEM";
			String password = "SYSADMIN";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);

			conn.setAutoCommit(false);

			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM CUSTOMER");

			System.out.println("Enter User Name: ");
			String usrName = sc.next();
			System.out.println("Enter Password: ");
			String pass = sc.next();
			while (rs.next()) {

				if ((rs.getString("USER_NAME").equals(usrName)) && (rs.getString("PASSWORD").equals(pass))) {
					cust = rs.getInt("c_id");
					System.out.println();
					System.out.println("***************Welcome to shopping cart ********************************");
					System.out.println();
					System.out.println("Lets Shop : " + rs.getString("F_NAME"));

					menu();
				}

			}
			// System.out.println("Invalid user");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();

				conn.close();

			} catch (SQLException sqlExce) {
				System.out.println("Problem while closing the connection.");
			}

		}
		System.out.println("Please try again in valid user else press 0 to stop ");
		int stp=sc.nextInt();
		if(stp==0) {
			System.out.println("Thank you for visiting");
			break;
		}
		continue;
}

	}

	public void menu() throws SQLException, ClassNotFoundException {
		while (true) {

			System.out.println("1. Place order \n" + "2. Delete Order \n" + "3. View Orders\n");
			System.out.println("Select any option above :");
			int val = sc.nextInt();
			switch (val) {
			case 1:
				PlaceOrder obj = new PlaceOrder();

				ResultSet rs = obj.itemSearch();

				while (rs.next()) {

					System.out.println("Item id: " + rs.getInt("ITEM_ID") + "\n ITEM NAME: " + rs.getString("ITEM_NAME")
							+ "\n ITEM PRICE : " + rs.getInt("ITEM_PRICE"));

				}

				System.out.println("Enter itemes to be added : ");
				int itemId = sc.nextInt();
				System.out.println("Enter no of quantity you want to add");
				int quant = sc.nextInt();

				obj.orderPlace(itemId, quant, cust);

				break;

			case 2:
				System.out.println("Enter order Id to delete");
				int deleteId = sc.nextInt();
				st.executeQuery("DELETE FROM ORDER_PLACED WHERE ORDER_ID=" + deleteId);

				st.executeQuery("DELETE FROM CUSTOMER_ORDER WHERE ORDER_ID=" + deleteId);

				conn.commit();

				System.out.println("Order has been deleted");
				break;

			case 3:
				ResultSet allOrderId = st.executeQuery("SELECT ORDER_ID FROM ORDER_PLACED WHERE C_ID=" + cust);
				while (allOrderId.next()) {
					System.out.println(allOrderId.getInt("ORDER_ID"));
				}
				System.out.println("Enter orderId to find details");
				int detailId = sc.nextInt();
				ResultSet orderPlaced = st.executeQuery("SELECT * FROM CUSTOMER_ORDER WHERE ORDER_ID=" + detailId);
				while (orderPlaced.next()) {
					System.out.println("Item id is : " + orderPlaced.getInt("ITEM_ID"));

					System.out.println("Quantity is : " + orderPlaced.getInt("QUANTITY"));
					System.out.println("Price is : " + orderPlaced.getInt("PRICE"));
				}
				break;

			default:
				break;
			}
			System.out.println("Do you want to continue press 1 : ");
			int cont = sc.nextInt();
			if (!(cont == 1)) {
				System.out.println("Thank you for placing order please visit next time");
				break;
			} 

		}
	}

	public static void main(String args[]) {
		ShoppingCartMain shop = new ShoppingCartMain();
		shop.userValidation();
	}
}

/*
 * public ArrayList<BookDetails> loadBookObjects() {
 * 
 * ArrayList<BookDetails> listOfBooks = new ArrayList<BookDetails>();
 * 
 * 
 * Scanner in = new Scanner(System.in);
 * System.out.println("Enter no of  book object to create: "); int size =
 * in.nextInt();
 * 
 * for (int i = 0; i < size; i++) { listOfBooks.add(new BookDetails());
 * 
 * 
 * BookDetails b1 = listOfBooks.get(i);
 * 
 * System.out.println("Enter book Id");
 * 
 * b1.setBookId(in.nextInt()); System.out.println("Enter book Name");
 * b1.setBookName(in.next());
 * 
 * System.out.println("Enter book price :$"); b1.setBookPrice(in.nextDouble());
 * }
 * 
 * return listOfBooks;
 * 
 * }
 */