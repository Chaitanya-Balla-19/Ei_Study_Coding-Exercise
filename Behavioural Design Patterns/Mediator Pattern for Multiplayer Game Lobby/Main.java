import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Mediator gameLobby = new GameLobbyMediator();

        System.out.println("Enter the number of players:");
        int numberOfPlayers = scn.nextInt();
        scn.nextLine();  

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.println("Enter name for Player " + i + ":");
            String playerName = scn.nextLine();
            Player player = new HumanPlayer(gameLobby, playerName);
            gameLobby.addPlayer(player);
        }

        String choice;
        do {
            System.out.println("Select a player to send a message (enter the player's name or type 'exit' to quit):");
            String senderName = scn.nextLine();

            Player sender = null;
            for (Player player : gameLobby.getPlayers()) {  
                if (player.getName().equals(senderName)) {  
                    sender = player;
                    break;
                }
            }

            if (sender != null) {
                System.out.println("Enter the message:");
                String message = scn.nextLine();
                sender.send(message);
            } else if (!senderName.equalsIgnoreCase("exit")) {
                System.out.println("Player not found. Try again.");
            }

            System.out.println("Do you want to send another message? (yes/no)");
            choice = scn.nextLine();
        } while (choice.equalsIgnoreCase("yes"));

        scn.close();
        System.out.println("Game lobby closed.");
    }
}
