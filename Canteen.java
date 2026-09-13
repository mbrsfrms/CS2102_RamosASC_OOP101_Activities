import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        char orderAgain;
        int totalItems = 0;
        double overallTotal = 0.0;

        do {
            System.out.println("==== M E N U ====");
            System.out.println("1. Burger   - $80.00");
            System.out.println("2. Pizza    - $120.00");
            System.out.println("3. Pasta    - $100.00");
            System.out.println("4. Sandwich - $70.00");
            System.out.println("5. Milk Tea - $90.00");
            System.out.println();

            System.out.print("Enter item number: ");
            int itemNumber = scanner.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            if (itemNumber < 1 || itemNumber > 5 || quantity <= 0) {
                System.out.println("\nInvalid order! Please enter a valid item and quantity.\n");
            } else {
                double pricePerItem = 0.0;

                switch (itemNumber) {
                    case 1: pricePerItem = 80.00; break;
                    case 2: pricePerItem = 120.00; break;
                    case 3: pricePerItem = 100.00; break;
                    case 4: pricePerItem = 70.00; break;
                    case 5: pricePerItem = 90.00; break;
                }

                double subtotal = pricePerItem * quantity;

                System.out.print("Are you a student? (Y/N): ");
                char isStudent = scanner.next().toUpperCase().charAt(0);

                double discount = 0.0;
                if (isStudent == 'Y') {
                    double discountRate = (quantity >= 5) ? 0.15 : 0.10;
                    discount = subtotal * discountRate;
                }

                double orderTotal = subtotal - discount;

                System.out.printf("Subtotal: $%.2f%n", subtotal);
                System.out.printf("Discount: $%.2f%n", discount);
                System.out.printf("Order total: $%.2f%n", orderTotal);

                totalItems += quantity;
                overallTotal += orderTotal;
            }

            System.out.println();
            System.out.print("Do you want to order again? (Y/N): ");
            orderAgain = scanner.next().toUpperCase().charAt(0);
            System.out.println();

        } while (orderAgain == 'Y');
 
        System.out.println("==== ORDER SUMMARY ====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Overall total: $%.2f%n", overallTotal);

        scanner.close();
    }
}
