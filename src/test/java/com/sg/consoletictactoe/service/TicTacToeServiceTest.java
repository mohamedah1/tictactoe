/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.consoletictactoe.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mohamed
 */
public class TicTacToeServiceTest {
    
    TicTacToeService service = new TicTacToeService();
    
    public TicTacToeServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of validPlay method, of class TicTacToeService.
     */
    @Test
    public void testValidPlay() {
    }

    /**
     * Test of getOne method, of class TicTacToeService.
     */
    @Test
    public void testGetOne() {
    }

    /**
     * Test of setOne method, of class TicTacToeService.
     */
    @Test
    public void testSetOne() {
    }

    /**
     * Test of getTwo method, of class TicTacToeService.
     */
    @Test
    public void testGetTwo() {
    }

    /**
     * Test of setTwo method, of class TicTacToeService.
     */
    @Test
    public void testSetTwo() {
    }

    /**
     * Test of initBoard method, of class TicTacToeService.
     */
    @Test
    public void testInitBoard() {
    }

    /**
     * Test of getBoard method, of class TicTacToeService.
     */
    @Test
    public void testGetBoard() {
    }

    /**
     * Test of checkStatus method, of class TicTacToeService.
     */
    @Test
    public void testCheckStatus() {
        service.initBoard();
        
        service.makePlay(3, 1);
        service.makePlay(6, 1);
        service.makePlay(9, 1);
        
        assertEquals(TicTacToeService.Status.XWON, service.checkStatus());
        
                service.initBoard();
        
        service.makePlay(7, 1);
        service.makePlay(8, 1);
        service.makePlay(9, 1);
        
        assertEquals(TicTacToeService.Status.XWON, service.checkStatus());
        
        service.makePlay(1, 1);
        service.makePlay(5, 1);
        service.makePlay(9, 1);
        
        assertEquals(TicTacToeService.Status.XWON, service.checkStatus());
        
        service.makePlay(1, 1);
        service.makePlay(2, 1);
        service.makePlay(3, 2);
        
        service.makePlay(4, 2);
        service.makePlay(5, 2);
        service.makePlay(6, 1);
        
        service.makePlay(7, 1);
        service.makePlay(8, 2);
        service.makePlay(9, 1);
        
        assertEquals(TicTacToeService.Status.DRAW, service.checkStatus());
    }

    /**
     * Test of makePlay method, of class TicTacToeService.
     */
    @Test
    public void testMakePlay() {
    }
    
}
