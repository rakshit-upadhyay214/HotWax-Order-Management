package controller;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Customer;
import service.Customer_service;


@RestController

public class Customer_controller {

	private Customer_service customer_service;
	
	public Customer_controller(Customer_service customer_service) {
		this.customer_service = customer_service;
	}

	@GetMapping("/customer")
    public List<Customer> getPersons() {
        return customer_service.getAllCustomers();
    }
	
	@PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customer_service.createCustomer(customer);
        return ResponseEntity.ok(createdCustomer);
    }
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customerDetails) {
	    Customer updatedCustomer = customer_service.updateCustomer(id, customerDetails);
	    return ResponseEntity.ok(updatedCustomer);
	}
}
