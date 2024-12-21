package model;

import java.sql.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class Order_header {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    
    @Column(nullable = false)
    private Date orderDate;
    private int customerId;
    private int shippingContactMechId;
    private int billingContactMechId;
    @OneToMany(mappedBy = "orderId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order_item> listOfItems;

    public List<Order_item> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(List<Order_item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getShippingContactMechId() {
        return shippingContactMechId;
    }

    public void setShippingContactMechId(int shippingContactMechId) {
        this.shippingContactMechId = shippingContactMechId;
    }

    public int getBillingContactMechId() {
        return billingContactMechId;
    }

    public void setBillingContactMechId(int billingContactMechId) {
        this.billingContactMechId = billingContactMechId;
    }

    @Override
    public String toString() {
        return "OrderHeader{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", customerId=" + customerId +
                ", shippingContactMechId=" + shippingContactMechId +
                ", billingContactMechId=" + billingContactMechId +
                ", listOfItems=" + listOfItems +
                '}';
    }
}