import java.util.*;
import java.io.*;

public class UserPlayer extends Player {
    public UserPlayer(String mark, int type) {
        super(mark, type);
    }

    public int play(Board board){ //choose random place to play
        System.out.println("Your turn:");
        System.out.println(board);
        Scanner s = new Scanner(System.in);

        int move = 0;
        boolean invalid = true;
        while (invalid) {
            System.out.println("Choose your next move: ");
            move = Integer.parseInt(s.nextLine());
            if (move < 0 || move > 8) {
                System.out.println("Invalid move.");
            }
            else if (!(board.board[move]).equals(" ")){
                System.out.println("Invalid move.");
            }
            else {
                invalid = false;
            }
        }
        board.addMark(mark, move);

        System.out.println("\nOpponent's turn:");
        System.out.println(board);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return move;
    }
}