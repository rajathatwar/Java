package com.project.orderManagementJsp;

import java.util.List;

import com.project.orderManagementJsp.modal.Item;

public interface ItemDao {
	List<Item> searchItems(String itemSearcgToken);
}
