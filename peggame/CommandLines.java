package peggame;
import java.util.Scanner;

public class CommandLines {
    public static void CLI(Game game) throws PegGameException {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while(flag) {
        System.out.println(game.getBoard());
        System.out.print(">> ");
        String input = sc.nextLine();

        if(input.trim().equals("help")) {
            System.out.println("help - displays this message");
            System.out.println("move r1 c1 r2 c2 - attempts to move a peg from r1 c1 to r2 c2 on the board.");
            System.out.println("hint - displays an available move.");
            System.out.println("quit - quits the game");
            System.out.println();
        }

        if(input.trim().equals("hint")) {
            // System.out.println(game.getPossibleMoves().toArray()[0]);
            game.getPossibleMoves().stream().forEach(System.out::println); // Will print all the hints
        }

        if(input.trim().equals("quit")) {
            System.out.println("Are you sure? (y/n)");
            input = sc.nextLine();
            if (input.equals("y")) {
                flag = false;
                System.out.println("Goodbye.");
            }
        }

        String[] tokens = input.split(" ");
        if(tokens[0].equals("move") && tokens.length == 5) {
            Location from = new Location(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            Location to = new Location(Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
            Move move = new Move(from, to);
            try {
                game.makeMove(move);
            } catch (PegGameException yeah) {
                System.out.println("Invalid move! Try using 'hint'");
            }
            if(game.getBoard().getState() == GameState.STALEMATE) {
                System.out.println(game.getBoard());
                System.out.println();
                System.out.println("lol you lose.");
                flag = false;
            } else if(game.getBoard().getState() == GameState.WON) {
                System.out.println(game.getBoard());
                System.out.println();
                System.out.println("GG");
                flag = false;
            }
            
        }



    }
    sc.close();
}
}