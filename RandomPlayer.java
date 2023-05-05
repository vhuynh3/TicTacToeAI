import java.util.*;
import java.io.*;

public class RandomPlayer extends Player {
    public RandomPlayer(String mark, int type) {
        super(mark, type);
    }

    public int play(Board board){ //choose random place to play
        Random rand = new Random();
        int idx = rand.nextInt(board.empty.size());
        idx = board.empty.get(idx);
        board.addMark(mark, idx);
        return idx;
    }
}