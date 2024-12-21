package service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Order_header;
import model.Order_item;
import repository.Order_item_repo;
import repository.Order_repo;

@Service
public class Order_service {

    @Autowired
    private Order_repo order_repo;

    @Autowired
    private Order_item_repo order_item_repo;

    
    public Order_header createOrder(Order_header order) {
    	Order_header newOrder = order_repo.save(order);
    	for (Order_item o : order.getListOfItems()) {
    		o.setOrderId(newOrder.getOrderId());
    	}
        return order_repo.save(newOrder);
    }

    public Optional<Order_header> getOrderById(Integer orderId) {
        return order_repo.findById(orderId);
    }

  
    public Order_header updateOrder(Integer orderId, Order_header updatedOrder) {
        if (order_repo.existsById(orderId)) {
            updatedOrder.setOrderId(orderId); 
            return order_repo.save(updatedOrder);
        }
        return null;
    }

    public void deleteOrder(Integer orderId) {
        order_repo.deleteById(orderId);
    }

    public Order_item addOrderItem(Integer orderId, Order_item orderItem) {
        Optional<Order_header> order = order_repo.findById(orderId);
        if (order.isPresent()) {
            orderItem.setOrderId(orderId); 
            return order_item_repo.save(orderItem);
        }
        return null;
    }

    // Update an item in an order
    public Order_item updateOrderItem(Integer orderId, Integer orderItemSeqId, Order_item updatedOrderItem) {
        Optional<Order_item> orderItem = order_item_repo.findById(orderItemSeqId);
        if (orderItem.isPresent() && orderItem.get().getOrderId() == orderId) {
            updatedOrderItem.setOrderItemSeqId(orderItemSeqId); 
            updatedOrderItem.setOrderId(orderId);
            return order_item_repo.save(updatedOrderItem);
        }
        return null;
    }

    // Delete an item from an order
    public void deleteOrderItem(Integer orderId, Integer orderItemSeqId) {
        Optional<Order_item> orderItem = order_item_repo.findById(orderItemSeqId);
        if (orderItem.isPresent() && orderItem.get().getOrderId() == orderId) {
            order_item_repo.deleteById(orderItemSeqId);
        }
    }
}
