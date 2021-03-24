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

        if(input.equals("help")) {
            System.out.println("help - displays this message");
            System.out.println("move r1 c1 r2 c2 - attempts to move a peg from r1 c1 to r2 c2 on the board.");
            System.out.println("hint - displays an available move.");
            System.out.println("quit - quits the game");
            System.out.println();
        }

        if(input.equals("hint")) {
            System.out.println(game.getPossibleMoves().iterator().next());
        }

        if(input.equals("quit")) {
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
            System.out.println(move);
            game.makeMove(move);
            
        }



    }
    sc.close();
}
}