package com.project.jdbc.part1;

import java.sql.ResultSet;

public interface OrderManagementDAO {
	public ResultSet itemSearch();

	public void orderPlace(int id, int quantity, int c_id);

}
