package com.sg.consoletictactoe;

import com.sg.consoletictactoe.controller.TicTacToeController;
import com.sg.consoletictactoe.service.TicTacToeService;
import com.sg.consoletictactoe.ui.TicTacToeView;
import com.sg.consoletictactoe.ui.UserIO;
import com.sg.consoletictactoe.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mohamed
 */
public class App {

    public static void main(String[] args) {
//        UserIO io = new UserIOConsoleImpl();
//        TicTacToeView view = new TicTacToeView(io);
//        TicTacToeService service = new TicTacToeService();
//        TicTacToeController controller = new TicTacToeController(service, view);
//        controller.run();

        ApplicationContext appContext
                = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        TicTacToeController controller = appContext.getBean("controller", TicTacToeController.class);
        controller.run();
    }
}
