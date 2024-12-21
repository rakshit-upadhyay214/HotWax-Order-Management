package repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Customer;

@Repository
public interface Customer_jpa_repo extends JpaRepository<Customer, Integer> {
}
