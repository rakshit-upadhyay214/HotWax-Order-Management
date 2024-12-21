package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Order_header;

@Repository
public interface Order_repo extends JpaRepository<Order_header, Integer> {

}
