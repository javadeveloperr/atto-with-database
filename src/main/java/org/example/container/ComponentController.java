package org.example.container;
import org.example.controller.*;
import org.example.dto.Card;
import org.example.dto.Profile;
import org.example.dto.Terminal;
import org.example.dto.Transaction;
import org.example.repository.CardRepository;
import org.example.repository.TerminalRepository;
import org.example.repository.TransactionRepository;
import org.example.repository.UserRepository;
import org.example.service.CardService;
import org.example.service.TerminalService;
import org.example.service.TransactionService;
import org.example.service.UserService;

import java.time.LocalDate;

public class ComponentController {
    public static Profile profile;
    public static Card card;
    public static UserRepository userRepository;
    public static UserService userService;
    public static MenuController menuController;
    public static AdminMenuController adminMenuController;
    public static CardController cardController;
    public static CardService cardService;
    public static CardRepository cardRepository;
    public static Terminal terminal;
    public static TerminalRepository terminalRepository;
    public static TerminalController terminalController;
    public static TerminalService terminalService;
    public static UserController userController;
    public static Transaction transaction;
    public static TransactionRepository transactionRepository;
    public static TransactionService transactionService;
    public static TransactionController transactionController;
    public static LocalDate localDate;

    static {
        card=new Card();
        terminal=new Terminal();
        terminalRepository=new TerminalRepository();
        terminalController=new TerminalController();
        terminalService=new TerminalService();
        adminMenuController=new AdminMenuController();
        menuController=new MenuController();
        userService = new UserService();
        userController=new UserController();
        profile = new Profile();
        userRepository = new UserRepository();
        cardRepository=new CardRepository();
        cardService=new CardService();
        cardController = new CardController();
        transaction =new Transaction();
        transactionRepository = new TransactionRepository();
        transactionService=new TransactionService();
        transactionController=new TransactionController();
        localDate=LocalDate.now();
    }
}
