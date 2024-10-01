import java.util.ArrayList;
import java.util.List;

public class GameLobbyMediator implements Mediator {
    private final List<Player> players;

    public GameLobbyMediator() {
        this.players = new ArrayList<>();
    }

    @Override
    public List<Player> getPlayers() {  // Implement the getPlayers method
        return players;
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
        System.out.println(player.getName() + " joined the game lobby.");
    }

    @Override
    public void sendMessage(String message, Player sender) {
        for (Player player : players) {
            if (player != sender) {
                player.receive(message);
            }
        }
    }
}
