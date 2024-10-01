import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the amount to pay:");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        System.out.println("Select payment method: 1. Credit Card 2. PayPal");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        PaymentStrategy paymentStrategy;

        switch (choice) {
            case 1:
                // Ask for Credit Card Number
                System.out.println("Enter Credit Card Number:");
                String cardNumber = scanner.nextLine();
                paymentStrategy = new CreditCardPayment(cardNumber);
                break;
            case 2:
                // Ask for PayPal Email
                System.out.println("Enter PayPal Email:");
                String email = scanner.nextLine();
                paymentStrategy = new PayPalPayment(email);
                break;
            default:
                System.out.println("Invalid choice");
                paymentStrategy = null;
                break;
        }

        if (paymentStrategy != null) {
            paymentStrategy.pay(amount); // Execute the payment with the chosen strategy
        }

        scanner.close();
    }
}
