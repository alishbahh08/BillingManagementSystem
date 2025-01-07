/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package billmanage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private double totalAmount;
    private boolean paymentStatus;
    private Date orderDate;
    private String status;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.totalAmount = 0;
        this.paymentStatus = false;
        this.orderDate = new Date();
        this.status = "Pending";
    }

    public int getOrderId() {
        return orderId;
    }

    public void addProduct(Product product, int quantity) {
        if (product.getStockQuantity() >= quantity) {
            product.setStockQuantity(product.getStockQuantity() - quantity);
            products.add(product);
            totalAmount += product.calculateTotal(quantity);
        } else {
            System.out.println("Insufficient stock for product: " + product.getName());
        }
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
        this.status = paymentStatus ? "Completed" : "Pending";
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customer.getName() + ", Total Amount: " + totalAmount + ", Status: " + status + ", Date: " + orderDate;
    }
}