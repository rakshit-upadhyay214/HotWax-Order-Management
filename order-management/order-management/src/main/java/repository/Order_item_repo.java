package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Order_item;

public interface Order_item_repo extends JpaRepository<Order_item, Integer>{

}
