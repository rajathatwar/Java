package com.project.orderManagementJsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.orderManagementJsp.modal.ViewOrderModel;

import oracle.jdbc.driver.OracleDriver;

public class ViewOrder {

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

	public List<ViewOrderModel> viewOrder(String ordId) throws Exception {
		List<ViewOrderModel> viewList = new ArrayList<ViewOrderModel>();
		int oId = Integer.valueOf(ordId);

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		int cust = CustomerDaoImpl.cust;

		conn = getConnection();

		st = conn.createStatement();
		rs = st.executeQuery(
				"select * from CUSTOMER_ORDER LEFT JOIN ORDERS USING (C_ID,ORDER_ID) WHERE ORDER_ID=" + oId);

		while (rs.next()) {
			ViewOrderModel obj = new ViewOrderModel();
			obj.setCUST_ID(rs.getInt("CUST_ID"));
			obj.setITEM_ID(rs.getInt("ITEM_ID"));
			obj.setORDER_ID(rs.getInt("ORDER_ID"));
			obj.setQUANTITY(rs.getInt("QUANTITY"));
			obj.setTOTALPRICE(rs.getInt("PRICE"));
			viewList.add(obj);

		}
		return viewList;

	}

}
