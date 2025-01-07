/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package billmanage;

import java.io.IOException;
import java.util.Scanner;

public class BillManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BillingManager manager = new BillingManager();

        while (true) {
            System.out.println("\n--- Billing Management System ---");
            System.out.println("1. Manage Data");
            System.out.println("2. Create Order");
            System.out.println("3. Display Customers");
            System.out.println("4. Display Products");
            System.out.println("5. Display Employees");
            System.out.println("6. Generate Reports");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            int choice = getIntInput(scanner, 1, 7);

            switch (choice) {
                case 1:
                    manageData(scanner, manager);
                    break;
                case 2:
                    createOrder(scanner, manager);
                    break;
                case 3:
                    manager.displayCustomers();
                    break;
                case 4:
                    manager.displayProducts();
                    break;
                case 5:
                    manager.displayEmployees();
                    break;
                case 6:
                    generateReports(scanner, manager);
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
            }
        }
    }

    private static void manageData(Scanner scanner, BillingManager manager) {
        while (true) {
            System.out.println("\n--- Manage Data ---");
            System.out.println("1. Manage Customers");
            System.out.println("2. Manage Products");
            System.out.println("3. Manage Employees");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice (1-4): ");

            int choice = getIntInput(scanner, 1, 4);

            switch (choice) {
                case 1:
                    manageCustomers(scanner, manager);
                    break;
                case 2:
                    manageProducts(scanner, manager);
                    break;
                case 3:
                    manageEmployees(scanner, manager);
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void manageCustomers(Scanner scanner, BillingManager manager) {
        while (true) {
            System.out.println("\n--- Manage Customers ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Search Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. View Order History");
            System.out.println("6. Back to Manage Data Menu");
            System.out.print("Enter your choice (1-6): ");

            int choice = getIntInput(scanner, 1, 6);

            switch (choice) {
                case 1:
                    addCustomer(scanner, manager);
                    break;
                case 2:
                    updateCustomer(scanner, manager);
                    break;
                case 3:
                    searchCustomer(scanner, manager);
                    break;
                case 4:
                    deleteCustomer(scanner, manager);
                    break;
                case 5:
                    viewOrderHistory(scanner, manager);
                    break;
                case 6:
                    return;
            }
        }
    }

    private static void addCustomer(Scanner scanner, BillingManager manager) {
        System.out.print("Enter Customer ID: ");
        int customerId = getIntInput(scanner);
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Customer customer = new Customer(customerId, customerName, contact, email);
        manager.addCustomer(customer);
        System.out.println("Customer added successfully.");
    }

    private static void updateCustomer(Scanner scanner, BillingManager manager) {
        System.out.print("Enter Customer ID to update: ");
        int updateId = getIntInput(scanner);
        Customer existingCustomer = manager.searchCustomerById(updateId);
        if (existingCustomer != null) {
            System.out.print("Enter new Customer Name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new Contact: ");
            String newContact = scanner.nextLine();
            System.out.print("Enter new Email: ");
            String newEmail = scanner.nextLine();

            existingCustomer.setName(newName);
            existingCustomer.setContact(newContact);
            existingCustomer.setEmail(newEmail);
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Customer not found!");
        }
    }

    private static void searchCustomer(Scanner scanner, BillingManager manager) {
        System.out.print("Enter Customer ID to search: ");
        int searchId = getIntInput(scanner);
        Customer foundCustomer = manager.searchCustomerById(searchId);
        if (foundCustomer != null) {
            System.out.println("Customer found: " + foundCustomer);
        } else {
            System.out.println("Customer not found!");
        }
    }

    private static void deleteCustomer(Scanner scanner, BillingManager manager) {
        System.out.print("Enter Customer ID to delete: ");
        int deleteId = getIntInput(scanner);
        if (manager.deleteCustomer(deleteId)) {
            System.out.println("Customer deleted successfully.");
        } else {
            System.out.println("Customer not found!");
        }
    }

    private static void viewOrderHistory(Scanner scanner, BillingManager manager) {
        System.out.print("Enter Customer ID to view order history: ");
        int historyId = getIntInput(scanner);
        manager.displayOrderHistory(historyId);
    }

    private static void manageProducts(Scanner scanner, BillingManager manager) {
        while (true) {
            System.out.println("\n--- Manage Products ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Search Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Back to Manage Data Menu");
            System.out.print("Enter your choice (1-5): ");

            int choice = getIntInput(scanner, 1, 5);

            switch (choice) {
                case 1:
                    addProduct(scanner, manager);
                    break;
                case 2:
                    updateProduct(scanner, manager);
                    break;
                case 3:
                    searchProduct(scanner, manager);
                    break;
                case 4:
                    deleteProduct(scanner, manager);
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void addProduct(Scanner scanner, BillingManager manager) {
        System.out.print("Enter Product ID: ");
        int productId = getIntInput(scanner);
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = getDoubleInput(scanner);
        System.out.print("Enter Stock Quantity: ");
        int stockQuantity = getIntInput(scanner);
        System.out.print("Enter Discount: ");
        double discount = getDoubleInput(scanner);

        Product product = new Product(productId, productName, category, price, stockQuantity, discount);
        manager.addProduct(product);
        System.out.println("Product added successfully.");
    }

    private static void updateProduct(Scanner scanner, BillingManager manager) {
        System.out.print("Enter Product ID to update: ");
        int updateProductId = getIntInput(scanner);
        Product existingProduct = manager.searchProductById(updateProductId);
        if (existingProduct != null) {
            System.out.print("Enter new Product Name: ");
            String newProductName = scanner.nextLine();
            System.out.print("Enter new Category: ");
            String newCategory = scanner.nextLine();
            System.out.print("Enter new Price: ");
            double newPrice = getDoubleInput(scanner);
            System.out.print("Enter new Stock Quantity: ");
            int newStockQuantity = getIntInput(scanner);
            System.out.print("Enter new Discount: ");
            double newDiscount = getDoubleInput(scanner);

            existingProduct.setName(newProductName);
            existingProduct.setCategory(newCategory);
            existingProduct.setPrice(newPrice);
            existingProduct.setStockQuantity(newStockQuantity);
            existingProduct.setDiscount(newDiscount);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void searchProduct(Scanner scanner, BillingManager manager) {
        System.out.print("Enter Product ID to search: ");
        int searchProductId = getIntInput(scanner);
        Product foundProduct = manager.searchProductById(searchProductId);
        if (foundProduct != null) {
            System.out.println("Product found: " + foundProduct);
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void deleteProduct(Scanner scanner, BillingManager manager) {
        System.out.print("Enter Product ID to delete: ");
        int deleteProductId = getIntInput(scanner);
        if (manager.deleteProduct(deleteProductId)) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void manageEmployees(Scanner scanner, BillingManager manager) {
        while (true) {
            System.out.println("\n--- Manage Employees ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Back to Manage Data Menu");
            System.out.print("Enter your choice (1-5): ");

            int choice = getIntInput(scanner, 1, 5);

            switch (choice) {
                case 1:
                    addEmployee(scanner, manager);
                    break;
                case 2:
                    updateEmployee(scanner, manager);
                    break;
                case 3:
                    searchEmployee(scanner, manager);
                    break;
                case 4:
                    deleteEmployee(scanner, manager);
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void addEmployee(Scanner scanner, BillingManager manager) {
        System.out.print("Enter Employee ID: ");
        int employeeId = getIntInput(scanner);
        System.out.print("Enter Employee Name: ");
        String employeeName = scanner.nextLine();
        System.out.print("Enter Position: ");
        String position = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = getDoubleInput(scanner);

        Employee employee = new Employee(employeeId, employeeName, position, salary);
        manager.addEmployee(employee);
        System.out.println("Employee added successfully.");
    }

    private static void updateEmployee(Scanner scanner, BillingManager manager) {
        System.out.print("Enter Employee ID to update: ");
        int updateEmployeeId = getIntInput(scanner);
        Employee existingEmployee = manager.searchEmployeeById(updateEmployeeId);
        if (existingEmployee != null) {
            System.out.print("Enter new Employee Name: ");
            String newEmployeeName = scanner.nextLine();
            System.out.print("Enter new Position: ");
            String newPosition = scanner.nextLine();
            System.out.print("Enter new Salary: ");
            double newSalary = getDoubleInput(scanner);

            existingEmployee.setName(newEmployeeName);
            existingEmployee.setPosition(newPosition);
            existingEmployee.setSalary(newSalary);
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static void searchEmployee(Scanner scanner, BillingManager manager) {
        System.out.print("Enter Employee ID to search: ");
        int searchEmployeeId = getIntInput(scanner);
        Employee foundEmployee = manager.searchEmployeeById(searchEmployeeId);
        if (foundEmployee != null) {
            System.out.println("Employee found: " + foundEmployee);
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static void deleteEmployee(Scanner scanner, BillingManager manager) {
        System.out.print("Enter Employee ID to delete: ");
        int deleteEmployeeId = getIntInput(scanner);
        if (manager.deleteEmployee(deleteEmployeeId)) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static void createOrder(Scanner scanner, BillingManager manager) {
        System.out.print("Enter Order ID: ");
        int orderId = getIntInput(scanner);
        System.out.print("Enter Customer ID: ");
        int customerId = getIntInput(scanner);
        Customer customer = manager.searchCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer not found! Order cannot be created.");
            return;
        }

        Order order = new Order(orderId, customer);
        while (true) {
            System.out.print("Enter Product ID to add to order (or -1 to finish): ");
            int productId = getIntInput(scanner);
            if (productId == -1) {
                break;
            }
            Product product = manager.searchProductById(productId);
            if (product != null) {
                System.out.print("Enter quantity: ");
                int quantity = getIntInput(scanner);
                order.addProduct(product, quantity);
            } else {
                System.out.println("Product not found!");
            }
        }

        System.out.print("Enter discount percentage (or 0 if none): ");
        double discountPercentage = getDoubleInput(scanner);
        if (discountPercentage > 0) {
            double totalAmount = order.getTotalAmount();
            totalAmount -= (totalAmount * discountPercentage / 100);
            order.setTotalAmount(totalAmount);
        }

        System.out.println("Payment Options:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");
        System.out.print("Select Payment Method (1-2): ");
        int paymentMethod = getIntInput(scanner, 1, 2);
        Payment payment;

        switch (paymentMethod) {
            case 1:
                System.out.print("Enter Card Number: ");
                String cardNumber = scanner.next();
                payment = new CreditCardPayment(order.getTotalAmount(), cardNumber);
                break;
            case 2:
                payment = new CashPayment(order.getTotalAmount());
                break;
            default:
                System.out.println("Invalid payment method.");
                return;
        }

        payment.processPayment();
        manager.addOrder(order);
        System.out.println("Order created successfully for Customer: " + customer.getName());
    }

    private static void generateReports(Scanner scanner, BillingManager manager) {
        System.out.println("\n--- Generate Reports ---");
        System.out.println("1. Sales Report");
        System.out.println("2. Order Report");
        System.out.print("Enter your choice (1-2): ");

        int choice = getIntInput(scanner, 1, 2);

        switch (choice) {
            case 1:
                try {
                    manager.generateSalesReport();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                manager.generateOrderReport();
                break;
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter an integer: ");
            }
        }
    }

    private static int getIntInput(Scanner scanner, int min, int max) {
        while (true) {
            int input = getIntInput(scanner);
            if (input >= min && input <= max) {
                return input;
            } else {
                System.out.printf("Invalid choice! Please enter a number between %d and %d: ", min, max);
            }
        }
    }

    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a decimal number: ");
            }
        }
    }
}
            