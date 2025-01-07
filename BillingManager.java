/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package billmanage;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class BillingManager {
    private final List<Customer> customers;
    private final List<Product> products;
    private final List<Order> orders;
    private final List<Employee> employees;

    public BillingManager() {
        customers = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer searchCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public boolean deleteCustomer(int id) {
        Customer customer = searchCustomerById(id);
        if (customer != null) {
            customers.remove(customer);
            return true;
        }
        return false;
    }

    public void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("--- Customer List ---");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product searchProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public boolean deleteProduct(int id) {
        Product product = searchProductById(id);
        if (product != null) {
            products.remove(product);
            return true;
        }
        return false;
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("--- Product List ---");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void addOrder(Order order) {
        orders.add(order);
        order.getCustomer().addOrder(order); // Add order to customer's order history
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee searchEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public boolean deleteEmployee(int id) {
        Employee employee = searchEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            return true;
        }
        return false;
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("--- Employee List ---");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public void displayOrderHistory(int customerId) {
        Customer customer = searchCustomerById(customerId);
        if (customer != null) {
            List<Order> orderHistory = customer.getOrderHistory();
            if (orderHistory.isEmpty()) {
                System.out.println("No order history found for customer: " + customer.getName());
            } else {
                System.out.println("--- Order History for " + customer.getName() + " ---");
                for (Order order : orderHistory) {
                    System.out.println(order);
                    System.out.println("Products in this order:");
                    for (Product product : order.getProducts()) {
                        System.out.println(product);
                    }
                }
            }
        } else {
            System.out.println("Customer not found!");
        }
    }

    public void generateSalesReport() throws IOException {
        try (FileWriter fw = new FileWriter("sales_report.txt", true)) { // Append mode
            fw.write("Sales Report generated on: " + LocalDateTime.now() + "\n");
            double totalSales = 0;
            for (Order order : orders) {
                totalSales += order.getTotalAmount();
            }
            System.out.println("Total Sales: " + totalSales);
            System.out.println("Total Inventory Value: " + calculateTotalInventoryValue());
            System.out.println("Total Employees: " + employees.size());
            for (Employee employee : employees) {
                System.out.println(employee.getName() + " - Salary: " + employee.getSalary());
            }
        } catch (IOException e) {
            System.err.println("Error writing sales report to file: " + e.getMessage());
        }
    }

    private double calculateTotalInventoryValue() {
        double totalValue = 0;
        for (Product product : products) {
            totalValue += product.getPrice() * product.getStockQuantity();
        }
        return totalValue;
    }

    public void generateOrderReport() {
        System.out.println("--- Order Report ---");
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println("Total Orders: " + orders.size());
        double totalSales = 0;
        for (Order order : orders) {
            totalSales += order.getTotalAmount();
        }
        System.out.println("Total Sales from all orders: " + totalSales);
    }

}
    
     
 