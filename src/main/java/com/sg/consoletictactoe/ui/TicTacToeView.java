package com.sg.consoletictactoe.ui;

/**
 *
 * @author mohamed
 */
public class TicTacToeView {
    UserIO io;

    public TicTacToeView(UserIO io) {
        this.io = io;
    }
    
    public void displayBoard(int[][] board) {
        io.print("");
        for(int i = 0;i<board.length;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j<board[i].length;j++) {
                
                switch(board[i][j]) {
                    case 0:
                        sb.append(" ");
                        break;
                    case 1:
                        sb.append("X");
                        break;
                    case 2:
                        sb.append("O");
                        break;
                }
                
                if(j < board[i].length-1) {
                    sb.append("|");
                }
            }
            io.print(sb.toString());
            if(i < board.length-1) {
                io.print("------");
            }
        }
        io.print("");
    }
    
    public void displayStartBanner() {
        io.print("Welcome to Tic-Tac-Toe");
    }
    
    
    public int selectNumberOfPlayers() {
        return io.readInt("Select # of players", 0, 2);
    }
    
    public String selectXOrO() {
        return io.readString("Do you want to be X or O?");
    }

    public void invalidEntry() {
    io.print("Invalid entry, please try again");
    }

    public int selectPlay() {
        io.print("1 2 3");
        io.print("4 5 6");
        io.print("7 8 9");
        return io.readInt("Select a position to play in:");
    }

    public void printDraw() {
        io.print("A strange game. The only winning move is not to play.");
    }

    public void printWinner(String winner) {
        io.print(winner + " has won.");
    }
}
