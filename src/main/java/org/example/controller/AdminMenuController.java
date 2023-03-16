package org.example.controller;
import org.example.container.ComponentController;
import static org.example.controller.MenuController.action;
public class AdminMenuController {
    public void adminMenu() {
        System.out.println("*** Admin Menu ***\n" +
                "    (Card)\n" +
                "    1. Create Card(number,exp_date)\n" +
                "    2. Card List\n" +
                "    3. Update Card (number,exp_date)\n" +
                "    4. Change Card status\n" +
                "    5. Delete Card\n" +
                "   (Terminal)\n" +
                "    6. Create Terminal (code unique,address)\n" +
                "    7. Terminal List\n" +
                "    8. Update Terminal (code,address)\n" +
                "    9. Change Terminal Status\n" +
                "    10. Delete\n" +
                "    (Profile)\n" +
                "    11. Profile List\n" +
                "    12. Change Profile Status (by phone)\n" +
                "    (Transaction)\n" +
                "    13. Transaction List\n" +
                "    14. Company Card Balance\n" +
                "    15. Bugungi to'lovlar\n" +
                "    16. Kunlik to'lovlar (bir kunlik to'lovlar): \n" +
                "    17. Oraliq to'lovlar:\n" +
                "    18. Umumiy balance (company card dagi pulchalar)\n" +
                "    19. Transaction by Terminal:\n" +
                "    20. Transaction By Card:\n");
        Boolean b = true;
        while (b) {
            int action;
            action = action();
            switch (action) {
                case 1 -> ComponentController.cardController.addCard();
                case 2 -> ComponentController.cardController.cardListAdmin();
                case 3 -> ComponentController.cardController.updateCardAdmin();
                case 4 -> ComponentController.cardController.updateCardStatusAdmin();
                case 5 -> ComponentController.cardController.deleteCardByNumber();
                case 6 -> ComponentController.terminalController.createTerminal();
                case 7 -> ComponentController.terminalController.terminalList();
                case 8 -> ComponentController.terminalController.updateTerminal();
                case 9 -> ComponentController.terminalController.changeTerminalStatus();
                case 10 -> ComponentController.terminalController.deleteTerminal();
                case 11 -> ComponentController.userController.printProfiles();
                case 12 -> ComponentController.userController.changeProfileStatus();
                case 13 -> ComponentController.transactionController.getTransactionsList();
                case 14 -> ComponentController.transactionController.getCompanyBalance();
                case 15 -> ComponentController.transactionController.getTodayTransaction();
                case 16 -> ComponentController.transactionController.getDayTransaction();
                case 17 -> ComponentController.transactionController.getIntermediateDayTransaction();
                case 18 -> ComponentController.transactionController.getTransactionByTerminal();
                case 19 -> ComponentController.transactionController.getTransactionByCard();
                case 0 -> b = false;
            }
        }
    }
}
