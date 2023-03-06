package org.example.controller;

import org.example.container.ComponentController;

import java.time.LocalDate;

public class CardController {
    public void cardListAdmin(){
        ComponentController.cardService.printAdminCardList();
    }
    public void deleteCardByNumber(String cardNumber){
        ComponentController.cardService.deleteCardByNumber(cardNumber);
    }
    public void updateCardAdmin(){
        ComponentController.cardService.updateCardAdmin();
    }
    public void updateCardStatusAdmin(){
        ComponentController.cardService.updateCardStatusAdmin();
    }
}
