import java.util.*;
import java.io.*;

public class MinimaxPlayer extends Player {
    public MinimaxPlayer(String mark, int type) {
        super(mark, type);
    }

    public int play(Board board) {
        int bestMove = 0;
        int bestVal;
        if (type == MIN_PLAY) {
            bestVal = 100000; //arbitrary large number
        } else {
            bestVal = -100000; //arbitrary small number
        }
        
        int curVal;

        //find best move by going through all empty spaces
        for (int i = 0; i < BOARD_SIZE * BOARD_SIZE; i++) {
            if (board.board[i].equals(" ")){ //If space is empty
                board.addMark(mark, i); //place a mark there
                curVal = minimax(board, 0, (type + 1) % 2); //calculate the value of the board
                
                if (type == MIN_PLAY && curVal < bestVal) {
                    bestVal = curVal; //store the value if it is better
                    bestMove = i; //store the move if it is better
                } else if (type == MAX_PLAY && curVal > bestVal) {
                    bestVal = curVal; //store the value if it is better
                    bestMove = i; //store the move if it is better
                }
                board.remMark(i); //remove the mark
            }
        }

        board.addMark(mark, bestMove); //place the best move
        return bestMove;
    }

    public int minimax(Board board, int depth, int minOrMax) {
        int value = board.boardValue();
        if (value != 0) { //someone has won
            if (minOrMax == MAX_PLAY) {return value - depth;}
            else {return value + depth; } //return the value of the board + the depth left if there is any
        }
        if (board.empty.size() == 0) { //board is full, a tie
            return 0;
        }

        int bestVal;
        if (minOrMax == MAX_PLAY) { //maximizing player
            bestVal = -100000; //arbitrary small number
            for (int i = 0; i < BOARD_SIZE * BOARD_SIZE; i++) {  //go through entire board
                if (board.board[i].equals(" ")) { //if space is empty
                    board.addMark(X, i); // place mark

                    //call minimax on next move and replace bestVal if the minimax returns a greater value
                    bestVal = Math.max(bestVal, minimax(board, depth + 1, MIN_PLAY)); 

                    board.remMark(i); //remove mark
                }
            }
            return bestVal;
        } 
        else { //minimizing player
            bestVal = 100000;
            for (int i = 0; i < BOARD_SIZE * BOARD_SIZE; i++) { //go through entire board
                if (board.board[i].equals(" ")) { //if space is empty
                    board.addMark(O, i); // place mark

                    //call minimax on next move and replace bestVal if the minimax returns a smaller value
                    bestVal = Math.min(bestVal, minimax(board, depth + 1, MAX_PLAY)); 

                    board.remMark(i); //remove mark
                }
            }
            return bestVal;
        }
    }
}