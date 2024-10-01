public class Validator {
    public static boolean isValidTime(String time) {
        return time.matches("([01]\\d|2[0-3]):[0-5]\\d");
    }

    public static boolean isValidPriority(String priority) {
        return priority.equalsIgnoreCase("High") ||
               priority.equalsIgnoreCase("Medium") ||
               priority.equalsIgnoreCase("Low");
    }
}