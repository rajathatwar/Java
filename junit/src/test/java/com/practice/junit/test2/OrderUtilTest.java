package com.practice.junit.test2;

import org.junit.Test;

import com.practice.junit.test2.Item;
import com.practice.junit.test2.Order;
import com.practice.junit.test2.OrderUtil;

import static org.junit.Assert.*;

public class OrderUtilTest {

	private OrderUtil orderUtil = new OrderUtil();
	
	@Test
	public void testCalculateOrderDetailsWhenIsOnSale(){		
		
		Item item = new Item();
		item.setItemPrice(100.0);
		item.setOnSale(true);
		item.setDiscountPercent(30);
		
		assertNotNull(orderUtil);
		
		Order resultOrder = orderUtil.calculateOrderDetails(item);
		
		assertNotNull(resultOrder);
		assertEquals(30, resultOrder.getDisountAmount(), 0.0);
		assertEquals(70, resultOrder.getFinalAmount(), 0.0);
				
	}
	
	@Test
	public void testCalculateOrderDetailsWhenIsNotOnSale(){		
		
		Item item = new Item();
		item.setItemPrice(100.0);
		item.setOnSale(false);
		item.setDiscountPercent(0);
		
		assertNotNull(orderUtil);
		
		Order resultOrder = orderUtil.calculateOrderDetails(item);
		
		assertNotNull(resultOrder);
		assertEquals(0, resultOrder.getDisountAmount(), 0.0);
		assertEquals(100, resultOrder.getFinalAmount(), 0.0);
				
	}
}
