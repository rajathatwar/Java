package com.project.jdbc.part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class PlaceOrder implements OrderManagementDAO {

	public int maxId(ResultSet maxOrderId) throws SQLException {
		if (maxOrderId.next()) {

			return (maxOrderId.getInt("MAX(ORDER_ID)") + 1);

		} else {
			return 0;
		}

	}

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

	@Override
	public ResultSet itemSearch() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			st = conn.createStatement();

			rs = st.executeQuery("SELECT * FROM ITEM");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	@Override
	public void orderPlace(int id, int quantity, int c_id) {
		int itemId = id;
		int quant = quantity;
		int cust = c_id;
		int price = 0;

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			st = conn.createStatement();

			ResultSet itemPrice = st.executeQuery("SELECT ITEM_PRICE FROM ITEM WHERE ITEM_ID=" + itemId);
			if (itemPrice.next()) {

				price = itemPrice.getInt("ITEM_PRICE");

			}

			int totalPrice = (price * quant);

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
