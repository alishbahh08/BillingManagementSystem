package billmanage;

class Product implements Calculable, Discountable {
    private int id;
    private String name;
    private String category;
    private double price;
    private int stockQuantity;
    private double discount;

    public Product(int id, String name, String category, double price, int stockQuantity, double discount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public double get;
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculateTotal(int quantity) {
        return price * quantity;
    }

    @Override
    public double applyDiscount(double discountPercentage) {
        double discountAmount = (price * discountPercentage) / 100;
        return price - discountAmount;
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Category: " + category + ", Price: " + price + ", Stock: " + stockQuantity + ", Discount: " + discount;
    }

    void setDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void display() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}