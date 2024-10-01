import java.util.List;

public interface Mediator {
    void sendMessage(String message, Player sender);
    void addPlayer(Player player);
    List<Player> getPlayers();  // Add this method to retrieve players
}
