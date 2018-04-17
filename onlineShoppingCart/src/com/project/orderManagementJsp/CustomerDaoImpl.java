package com.project.orderManagementJsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerDaoImpl implements CustomerDao {
	
	public static int cust;
	
	/*
	 * public static void main(String[] args) { CustomerDaoImpl cust= new
	 * CustomerDaoImpl(); boolean v=cust.isUserValid("raja", "hatwar"); if(v) {
	 * System.out.println("valid"); }else { System.out.println("Invld"); } }
	 */
	public boolean isUserValid(String userName, String userPassword) {

		
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement pst = null;

		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String username = "SYSTEM";
			String password = "SYSADMIN";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);

			conn.setAutoCommit(false);

			st = conn.createStatement();
			pst = conn.prepareStatement("SELECT * FROM CUSTOMER where USER_NAME=? AND PASSWORD=?");

			pst.setString(1, userName);
			pst.setString(2, userPassword);
			rs = pst.executeQuery();
			if (rs.next()) {
				cust = rs.getInt("c_id");
				return true;
			}

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
		return false;
	}
}
