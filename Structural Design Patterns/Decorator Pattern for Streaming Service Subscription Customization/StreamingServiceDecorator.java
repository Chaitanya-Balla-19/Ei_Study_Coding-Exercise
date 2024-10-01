public abstract class StreamingServiceDecorator implements StreamingService {
    protected StreamingService streamingService;

    public StreamingServiceDecorator(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @Override
    public String getDescription() {
        return streamingService.getDescription();
    }

    @Override
    public double getCost() {
        return streamingService.getCost();
    }
}
