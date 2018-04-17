package com.project.orderManagementJsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.orderManagementJsp.modal.Item;

public class ItemDaoImpl implements ItemDao {

/*	public static void main(String[] args) {
		ItemDaoImpl cus = new ItemDaoImpl();
		List<Item> itemList2 = cus.viewAllItems();
		//cus.searchItems("motorola");
		
		System.out.println(itemList2.size());
		for (Item item : itemList2) {
			System.out.println("hooo");
			System.out.println(item.getItemName());
			System.out.println(item.getPrice());
		}
	}*/

	public List<Item> viewAllItems() {
		List<Item> itemList = new ArrayList<Item>();
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
			rs = st.executeQuery("SELECT * FROM 	ITEM");

			while (rs.next()) {
				Item item = new Item();
				item.setItemId(rs.getLong("ITEM_ID"));
				item.setItemName(rs.getString("ITEM_NAME"));
				item.setPrice(rs.getLong("ITEM_PRICE"));
				item.setDiscount(rs.getInt("DISCOUNT_PER"));
				itemList.add(item);

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

		return itemList;
	}

	public List<Item> searchItems(String itemSearcgToken) {
		List<Item> itemList = new ArrayList<Item>();

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
			pst = conn.prepareStatement("SELECT * FROM 	ITEM where ITEM_NAME like ? ");

			pst.setString(1, "%"+itemSearcgToken+"%");

			rs = pst.executeQuery();
			while (rs.next()) {
				Item item = new Item();
				item.setItemId(rs.getLong("ITEM_ID"));
				item.setItemName(rs.getString("ITEM_NAME"));
				item.setPrice(rs.getLong("ITEM_PRICE"));
				item.setDiscount(rs.getInt("DISCOUNT_PER"));
				itemList.add(item);

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

		return itemList;
	}
}
