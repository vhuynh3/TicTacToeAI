import java.util.*;
import java.io.*;

public class Program {
    public static final int MAX_PLAY = 1;
    public static final int MIN_PLAY = 0;

    public static final int RANDOM = 0;
    public static final int MINIMAX = 1;
    public static final int ALPHABETA = 2;
    public static final int MEM = 3;
    public static final int USER = 4;

    public static final String usage = "usage: java Program <RANDOM/MINIMAX/ALPHABETA/MEM> <RANDOM/MINIMAX/ALPHABETA/MEM> <# of Games> <output file>";

    public static void main(String[] args) {
        //java Program RANDOM RANDOM 100 output.txt

        if (args.length != 4) {
            System.out.println(usage);
            System.exit(0);
        }
        int p1 = RANDOM;
        int p2 = RANDOM;

        if (args[0].equals("RANDOM")) {p1 = RANDOM;}
        else if (args[0].equals("MINIMAX")) {p1 = MINIMAX;}
        else if (args[0].equals("ALPHABETA")) {p1 = ALPHABETA;}
        else if (args[0].equals("MEM")) {p1 = MEM;}
        else if (args[0].equals("USER")) {p1 = USER;}
        else {
            System.out.println("Player 1 type invalid. Using RANDOM as default");
        }

        if (args[1].equals("RANDOM")) {p2 = RANDOM;}
        else if (args[1].equals("MINIMAX")) {p2 = MINIMAX;}
        else if (args[1].equals("ALPHABETA")) {p2 = ALPHABETA;}
        else if (args[1].equals("MEM")) {p2 = MEM;}
        else if (args[1].equals("USER")) {p2 = USER;}
        else {
            System.out.println("Player 2 type invalid. Using RANDOM as default");
        }

        int numGames = 100; //default 100
        try {
            numGames = Integer.parseInt(args[2]);   
        } catch(NumberFormatException e) {
            System.out.println("Invalid number of games. Using 100 as default.");
        }

        Game game;
        int result;

        int p1wins = 0; //min player
        int p2wins = 0; //max player
        int tie = 0;

        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < numGames; i++) {
            game = new Game(p1, p2);
            result = game.playGame();
            if (result > 0) {
                p2wins ++;
            } else if (result < 0) {
                p1wins ++;
            } else {
                tie ++;
            }
        }
        long timeEnd = System.currentTimeMillis();
        float p1Rate = p1wins * 100/numGames ;
        float p2Rate = p2wins* 100/numGames;
        float tieRate = tie* 100/numGames;

        File f;
        FileWriter w;
        try {
            f = new File(args[3]);
            w = new FileWriter(f);
            w.write("Number of games: " + numGames + "\n");
            w.write("player 1 wins: " + p1Rate + "%\n");
            w.write("player 2 wins: " + p2Rate + "%\n");
            w.write("ties: " + tieRate + "%\n");
            w.write("Average game time: " + (timeEnd - timeStart)/numGames + " ms");
            w.close();
        } catch (IOException e) {
            System.out.println("Could not open " + args[3] + ". Try again.");
            System.exit(0);
        }

    }
}