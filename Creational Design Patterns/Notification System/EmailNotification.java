public class EmailNotification implements Notification {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Sending Email to " + user.getEmail() + ": " + message);
    }
}
