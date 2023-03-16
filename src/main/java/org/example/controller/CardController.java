package org.example.controller;

import org.example.container.ComponentController;
import org.example.util.ScannerUtil;

import java.time.LocalDate;

public class CardController {
    public void addCard(){
        System.out.println("Enter card number : ");
        String cardNum = ScannerUtil.StringScanner.next().trim();
        ComponentController.card.setNumber(cardNum);
        System.out.println("Enter Exp date : ");
        String expDate = ScannerUtil.StringScanner.next().trim();
        ComponentController.card.setExp_date(expDate);
        ComponentController.cardService.createCard(ComponentController.card);
    }
    public void cardListAdmin(){
        ComponentController.cardService.printAdminCardList();
    }
    public void deleteCardByNumber(){
        System.out.println("Enter card number : ");
        String cardOfNum = ScannerUtil.StringScanner.next().trim();
        ComponentController.cardService.deleteCardByNumber(cardOfNum);
    }
    public void updateCardAdmin(){
        ComponentController.cardService.updateCardAdmin();
    }
    public void updateCardStatusAdmin(){
        ComponentController.cardService.updateCardStatusAdmin();
    }
    public void setPhoneUser(){
        System.out.println("Enter phone number : ");
        String phoneNumber = ScannerUtil.StringScanner.next().trim();
        System.out.println("Enter card number : ");
        String cardNumber = ScannerUtil.StringScanner.next().trim();
        ComponentController.cardService.setCardProfilePhone(phoneNumber, cardNumber);
    }
}
