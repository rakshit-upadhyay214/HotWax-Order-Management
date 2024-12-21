package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Customer;
import repository.Customer_jpa_repo;

@Service
public class Customer_service {
	private final Customer_jpa_repo customer_repo;

	public Customer_service(Customer_jpa_repo customer_repo) {
		this.customer_repo = customer_repo;
	}
	
	public List<Customer> getAllCustomers() {
        return customer_repo.findAll();
    }
	
	
	public Customer createCustomer(Customer customer) {
        return customer_repo.save(customer);
    }
	
	public Customer updateCustomer(Integer id, Customer customerDetails) {
	    Customer existingCustomer = customer_repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
	    
	    existingCustomer.setFirst_name(customerDetails.getFirst_name());
	    existingCustomer.setLast_name(customerDetails.getLast_name());

	    return customer_repo.save(existingCustomer);
	}
}
