package com.project.orderManagementJsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class DeleteOrder {
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

	public void deleteOrder(String oid) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		int cust = CustomerDaoImpl.cust;

		
		int deleteId = Integer.valueOf(oid);
		ResultSet orderPlaced;
		try {
			
			st.executeQuery("DELETE FROM ORDER_PLACED WHERE ORDER_ID=" + deleteId);

			st.executeQuery("DELETE FROM CUSTOMER_ORDER WHERE ORDER_ID=" + deleteId);

			conn.commit();

			System.out.println("Order has been deleted");
		} catch (SQLException e) {
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
