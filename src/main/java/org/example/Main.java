package org.example;
import org.example.container.ComponentController;
import org.example.db.CardDB;
import org.example.db.ProfileDB;
import org.example.db.TerminalDB;
import org.example.db.TransactionDB;
public class Main {
    public static void main(String[] args) {
        ProfileDB.createProfileTable();
        TerminalDB.createTerminalTable();
        CardDB.createCardTable();
        TransactionDB.createTransactionTable();
        ComponentController.menuController.mainMenu();
        System.out.println("Life is beautiful!");
    }
}