import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StreamingService subscription = new BasicSubscription();  // Start with basic subscription

        System.out.println("Current Subscription: " + subscription.getDescription() + " | Cost: $" + subscription.getCost());

        System.out.println("Do you want to add 4K Resolution? (yes/no)");
        String add4K = scanner.nextLine();
        if (add4K.equalsIgnoreCase("yes")) {
            subscription = new FourKFeature(subscription);
        }

        System.out.println("Final Subscription: " + subscription.getDescription() + " | Total Cost: $" + subscription.getCost());
        scanner.close();
    }
}
