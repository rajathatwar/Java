package com.practice.junit.test2;

public class OrderUtil {

	public Order calculateOrderDetails(Item item){
		Order order = new Order();
		
		if(item != null && item.isOnSale() && item.getDiscountPercent() > 0 ){
			
			double discountPrice = (item.getItemPrice() * item.getDiscountPercent()) / 100;
			
			double finalPrice = item.getItemPrice() - discountPrice;
			
			order.setDisountAmount(discountPrice);
			order.setFinalAmount(finalPrice);
			
		}else {
			
			double discountPrice = 0.0;
			
			double finalPrice = item.getItemPrice() - discountPrice;
			
			order.setDisountAmount(discountPrice);
			order.setFinalAmount(finalPrice);
		}
		
		return order;
	}
}
