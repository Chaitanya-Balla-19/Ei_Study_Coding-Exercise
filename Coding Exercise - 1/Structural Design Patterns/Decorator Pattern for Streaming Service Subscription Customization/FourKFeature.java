public class FourKFeature extends StreamingServiceDecorator {
    public FourKFeature(StreamingService streamingService) {
        super(streamingService);
    }

    @Override
    public String getDescription() {
        return streamingService.getDescription() + " + 4K Resolution";
    }

    @Override
    public double getCost() {
        return streamingService.getCost() + 5.00;  // Extra cost for 4K
    }
}
