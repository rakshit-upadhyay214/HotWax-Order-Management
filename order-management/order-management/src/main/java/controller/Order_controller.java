package controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Order_header;
import service.Order_service;

@RestController
@RequestMapping("/orders")

public class Order_controller {
	 @Autowired
	    private Order_service orderService;
	 
	 @PostMapping
	    public Order_header createOrder(@RequestBody Order_header order) {
	        return orderService.createOrder(order);
	    }
	 
	 @GetMapping("/{orderId}")
	    public Optional<Order_header> getOrderById(@PathVariable Integer orderId) {
	        return orderService.getOrderById(orderId);
	    }
	 
	 @DeleteMapping("/{orderId}")
	    public void deleteOrder(@PathVariable Integer orderId) {
	        orderService.deleteOrder(orderId);
	    }
	 
	 @PutMapping("/{orderId}")
	    public Order_header updateOrder(@PathVariable Integer orderId, @RequestBody Order_header updatedOrder) {
	        return orderService.updateOrder(orderId, updatedOrder);
	    }
}
