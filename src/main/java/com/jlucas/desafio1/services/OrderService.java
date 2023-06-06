package com.jlucas.desafio1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlucas.desafio1.entities.Order;

@Service
public class OrderService {
	
	@Autowired
	private ShippingService shippingService;

	public OrderService(ShippingService shippingService) {
		this.shippingService = shippingService;
	}
	
	public double total(Order order) {
		return order.getBasic() + shippingService.shipment(order) - ((order.getDiscount() * order.getBasic())/100.0);
	}
	
}
