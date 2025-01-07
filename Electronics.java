package billmanage;
import java.util.Scanner;

class Electronics extends Product {
    public String warranty;

    public Electronics(int id, String name, String category, double price, String warranty, int stockQuantity, double discount) {
        super(id, name, category, price, stockQuantity, discount);
        this.warranty = warranty;
    }

    public void setDetails() {
        super.setDetails();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter new warranty period: ");
        warranty = input.nextLine();
    }

    public void display() {
        super.display();
        System.out.println("Warranty: " + warranty);
    }
}
