package org.example.container;
import org.example.controller.*;
import org.example.dto.Card;
import org.example.dto.Profile;
import org.example.dto.Terminal;
import org.example.repository.CardRepository;
import org.example.repository.TerminalRepository;
import org.example.repository.UserRepository;
import org.example.service.CardService;
import org.example.service.TerminalService;
import org.example.service.UserService;
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


    static {
        card=new Card();
        terminal=new Terminal();
        terminalRepository=new TerminalRepository();
        terminalController=new TerminalController();
        terminalService=new TerminalService();
        adminMenuController=new AdminMenuController();
        menuController=new MenuController();
        userService = new UserService();
        profile = new Profile();
        userRepository = new UserRepository();
        cardRepository=new CardRepository();
        cardService=new CardService();
        cardController = new CardController();
    }
}
