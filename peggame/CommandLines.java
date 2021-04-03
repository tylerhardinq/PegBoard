package peggame;
import java.util.Scanner;


/**
 * Command-line interface that lets users play the game
 */
public class CommandLines {
    /**
     * Prompts the user to enter a command and plays the game
     * based on the command.
     * 
     * @param game takes in the new started game
     * @throws PegGameException
     */
    public static void CLI(PegGame game) throws PegGameException {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        //Contantly prompts the user to enter a command
        while(flag) {
        System.out.println(game);
        System.out.print(">> ");
        String input = sc.nextLine();

        //if the user enters help displays lists of commands
        if(input.trim().equals("help")) {
            System.out.println("help - displays this message");
            System.out.println("move r1 c1 r2 c2 - attempts to move a peg from r1 c1 to r2 c2 on the board.");
            System.out.println("hint - displays an available move.");
            System.out.println("solve - automatically solves the game.");
            System.out.println("quit - quits the game");
            System.out.println();
        }

        //if the user enters hint it displays one possible move that helps the user to win :)
        if(input.trim().equals("hint")) {
            GameSolver solution = GameSolver.solve(game);
            if(solution == null){
                System.out.println("There is no solution :( ");
            }
            else{
                System.out.println(solution.getMoves().get(0));
            }
        }
 
        //if the user enters solve, it automaticaly solves the game and prints the winning game
        if(input.trim().equals("solve")) {
            GameSolver solution = GameSolver.solve(game);
            System.out.println(" ↓↓  SOLUTION　↓↓　");
            for(Move move : solution.getMoves()) {
                System.out.println(move);
                game.makeMove(move);
                System.out.println(game);
            }  
            //ends the game
            System.out.println("Game solved! Wow that was easy. Don't forget to like and subscribe :)" + "\n");
            flag = false;
        }

        //displays a goodbye message and ends the game
        if(input.trim().equals("quit")) {
            System.out.println("Are you sure? (y/n)");
            input = sc.nextLine();
            if (input.equals("y")) {
                flag = false;
                System.out.println("Goodbye.");
            }
        }

        //if the user enters move it calls the makeMove function and 
        //checks if the move specified is valid and also checks the state of the game
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
            if(game.getGameState() == GameState.STALEMATE) {
                System.out.println(game);
                System.out.println();
                System.out.println("lol you lose.");
                flag = false;
            } else if(game.getGameState() == GameState.WON) {
                System.out.println(game);
                System.out.println();
                System.out.println("GG");
                flag = false;
            }
            
        }



    }
    sc.close();
}
}