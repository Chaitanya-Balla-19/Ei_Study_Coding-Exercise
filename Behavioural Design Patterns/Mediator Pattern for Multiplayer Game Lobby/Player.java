public abstract class Player {
    protected Mediator mediator;
    protected String name;

    public Player(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() {  // Add this method to return the player's name
        return name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}
