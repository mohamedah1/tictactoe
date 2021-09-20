package com.sg.consoletictactoe.service;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 * @author mohamed
 */
public class TicTacToeService {

    int[][] board;

    Player one;
    Player two;

    public boolean validPlay(int position) {
        switch (position) {
            case 1:
                return board[0][0] == 0;
            case 2:
                return board[0][1] == 0;
            case 3:
                return board[0][2] == 0;
            case 4:
                return board[1][0] == 0;
            case 5:
                return board[1][1] == 0;
            case 6:
                return board[1][2] == 0;
            case 7:
                return board[2][0] == 0;
            case 8:
                return board[2][1] == 0;
            case 9:
                return board[2][2] == 0;
            default:
                return false;
        }
    }

    public enum Status {
        INPROGRESS,
        XWON,
        OWON,
        DRAW
    }

    public Player getOne() {
        return one;
    }

    public void setOne(Player one) {
        this.one = one;
    }

    public Player getTwo() {
        return two;
    }

    public void setTwo(Player two) {
        this.two = two;
    }

    public void initBoard() {
        int[][] newboard = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        board = newboard;
    }

    public int[][] getBoard() {
        return board;
    }

    public Status checkStatus() {
        Status status = Status.INPROGRESS;

        if (status == Status.INPROGRESS && ((board[0][0] == board[0][1] && board[0][1] == board[0][2])
                || (board[0][0] == board[1][0] && board[1][0] == board[2][0]))) {
            status = determineStatus(board[0][0]);
        }

        if (status == Status.INPROGRESS && ((board[2][0] == board[2][1] && board[2][1] == board[2][2])
                || (board[0][2] == board[1][2] && board[1][2] == board[2][2]))) {
            status = determineStatus(board[2][2]);
        }

        if (status == Status.INPROGRESS && ((board[1][0] == board[1][1] && board[1][1] == board[1][2])
                || (board[0][1] == board[1][1] && board[1][1] == board[2][1])
                || (board[0][0] == board[1][1] && board[1][1] == board[2][2])  //Diagnoals
                || (board[0][2] == board[1][1] && board[1][1] == board[2][0]))) {
            status = determineStatus(board[1][1]);
        }
        if (status == Status.INPROGRESS && Arrays.stream(board)
                .flatMapToInt(Arrays::stream)
                .noneMatch((i) -> i == 0)) {
            status = Status.DRAW;
        }

        return status;

    }

    public void makePlay(int position, int player) {
        switch (position) {
            case 1:
                board[0][0] = player;
                break;
            case 2:
                board[0][1] = player;
                break;
            case 3:
                board[0][2] = player;
                break;
            case 4:
                board[1][0] = player;
                break;
            case 5:
                board[1][1] = player;
                break;
            case 6:
                board[1][2] = player;
                break;
            case 7:
                board[2][0] = player;
                break;
            case 8:
                board[2][1] = player;
                break;
            case 9:
                board[2][2] = player;
                break;
        }
    }

    private Status determineStatus(int player) {
        switch (player) {
            case 1:
                return Status.XWON;
            case 2:
                return Status.OWON;
            default:
                return Status.INPROGRESS;
        }
    }
}
