public class SMSNotification implements Notification {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Sending SMS to " + user.getPhoneNumber() + ": " + message);
    }
}
