import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collecting user details
        System.out.println("Enter your name:");
        String name = scanner.nextLine();

        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        System.out.println("Enter your phone number:");
        String phoneNumber = scanner.nextLine();

        // Create a User object
        User user = new User(name, email, phoneNumber);

        // Ask for notification type
        System.out.println("Enter notification type (email or sms):");
        String type = scanner.nextLine();

        // Create notification using the factory
        Notification notification = NotificationFactory.createNotification(type);

        if (notification != null) {
            System.out.println("Enter your message:");
            String message = scanner.nextLine();
            // Send personalized notification
            notification.sendNotification(user, message);
        } else {
            System.out.println("Invalid notification type.");
        }

        scanner.close();
    }
}
