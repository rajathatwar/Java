package com.project.orderManagementJsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class OrderPlace {

	private static Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "SYSTEM";
		String password = "SYSADMIN";
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(false);

		return conn;
	}

	public int maxId(ResultSet maxOrderId) throws SQLException {
		if (maxOrderId.next()) {

			return (maxOrderId.getInt("MAX(ORDER_ID)") + 1);

		} else {
			return 0;
		}

	}

	public void orderPlace(String[] id, String[] quantity) {

		ArrayList<Integer> itemId = new ArrayList<Integer>();
		ArrayList<Integer> quant = new ArrayList<Integer>();
		// int quant[];

		int noOfItems = id.length;
		if (id != null && quantity != null) {
			for (int i = 0; i < noOfItems; i++) {
				itemId.add(Integer.parseInt(id[i]));
				quant.add(Integer.parseInt(quantity[i]));
			}
		}
		
		int cust = CustomerDaoImpl.cust;
		int price = 0;
		int totalPrice = 0;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			st = conn.createStatement();
			if (id != null && quantity != null) {
				for (int i = 0; i < noOfItems; i++) {

					ResultSet itemPrice = st.executeQuery("SELECT ITEM_PRICE FROM ITEM WHERE ITEM_ID=" + itemId.get(i));
					if (itemPrice.next()) {

						price = itemPrice.getInt("ITEM_PRICE");
						totalPrice = (price * quant.get(i)) + totalPrice;
					}

				}
			}

			ResultSet maxOrderId = st.executeQuery("SELECT MAX(ORDER_ID) FROM ORDER_PLACED");

			int max = maxId(maxOrderId);

			st.executeQuery("INSERT INTO ORDER_PLACED (ORDER_ID, C_ID) VALUES(" + max + "," + cust + ")");
			conn.commit();
			System.out.println("Your Order is placed");
		
			st.executeQuery("INSERT INTO CUSTOMER_ORDER(ORDER_ID, ITEM_ID, QUANTITY, PRICE) VALUES(" + max + ","
					+ itemId + "," + quant + "," + totalPrice + ")");
			
			conn.commit();

			// TODO Auto-generated method stub

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (Exception ex) {

			}
		}

	}
}
