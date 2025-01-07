package billmanage;
import java.util.Scanner;


class Groceries extends Product {
    public String expiryDate;

    public Groceries(int id, String name, String category, double price, String expiryDate, int stockQuantity, double discount) {
        super(id, name, category, price, stockQuantity, discount);
        this.expiryDate = expiryDate;
    }

    @Override
    public void setDetails() {
        super.setDetails();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter new expiry date: ");
        expiryDate = input.nextLine();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Expiry Date: " + expiryDate);
    }
}
