public class BasicSubscription implements StreamingService {
    @Override
    public String getDescription() {
        return "Basic Subscription";
    }

    @Override
    public double getCost() {
        return 9.99;  // Base cost
    }
}
