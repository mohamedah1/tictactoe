package com.sg.consoletictactoe.controller;

import com.sg.consoletictactoe.service.Player;
import com.sg.consoletictactoe.service.TicTacToeService;
import com.sg.consoletictactoe.service.TicTacToeService.Status;
import com.sg.consoletictactoe.ui.TicTacToeView;

/**
 *
 * @author mohamed
 */
public class TicTacToeController {

    TicTacToeService service;
    TicTacToeView view;

    public TicTacToeController(TicTacToeService service, TicTacToeView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        view.displayStartBanner();

        service.initBoard();

        int players = view.selectNumberOfPlayers();

        setPlayers(players); //0 = computers, 2 = users, 1 = select x or o

        boolean playerOnesTurn = true;

        while (service.checkStatus() == Status.INPROGRESS) {
            if (playerOnesTurn) {
                if (service.getOne() == Player.USER) {
                    selectAndMakePlay(1);
                } else { //Computer
                    makeComputerPlay(1);
                }
                playerOnesTurn = false;
            } else {
                if (service.getTwo() == Player.USER) {
                    selectAndMakePlay(2);
                } else { //Computer
                    makeComputerPlay(2);
                }
                playerOnesTurn = true;
            }

            //Needs a loop to play the game
            int[][] currentBoard = service.getBoard();
            view.displayBoard(currentBoard);
        }

        switch (service.checkStatus()) {
            case XWON:
                view.printWinner("X");
                break;
            case OWON:
                view.printWinner("O");
                break;
            case DRAW:
                view.printDraw();
                break;
        }
    }

    private void makeComputerPlay(int player) {
        boolean valid = false;
        int position = -1;
        while (!valid) {
            //Random
            position = (int) (Math.random() * 9) + 1;
            valid = service.validPlay(position);
        }
        service.makePlay(position, player);
    }

    private void selectAndMakePlay(int player) {
        boolean valid = false;
        int position = -1;
        while (!valid) {
            position = view.selectPlay();
            if (service.validPlay(position)) {
                valid = true;
            } else {
                view.invalidEntry();
            }
        }
        service.makePlay(position, player);
    }

    private void setPlayers(int players) {
        switch (players) {
            case 0:
                service.setOne(Player.COMPUTER);
                service.setTwo(Player.COMPUTER);
                break;
            case 1:
                boolean selected = false;
                do {
                    String xOrO = view.selectXOrO();
                    if ("X".equalsIgnoreCase(xOrO)) {
                        service.setOne(Player.USER);
                        service.setTwo(Player.COMPUTER);
                        selected = true;
                    } else if ("O".equalsIgnoreCase(xOrO)) {
                        service.setOne(Player.COMPUTER);
                        service.setTwo(Player.USER);
                        selected = true;
                    } else {
                        view.invalidEntry();
                    }
                } while (!selected);
                break;
            case 2:
                service.setOne(Player.USER);
                service.setTwo(Player.USER);
                break;
        }
    }

}
