package org.example.service;

import org.example.container.ComponentController;
import org.example.dto.Card;
import org.example.enums.Status;
import org.example.util.ScannerUtil;

import java.time.LocalDate;
import java.util.List;

public class CardService {
    public void createCard(Card card){
        Card existsCard= ComponentController.cardRepository.getCardByNumber(card.getNumber());
        if (existsCard!=null){
            System.out.println("Card already registered");
            return;
        }
        ComponentController.cardRepository.createCard(card);
    }
    public void printAdminCardList(){
        List<Card> cards=ComponentController.cardRepository.adminGetCardList();
        for (Card card:cards) {
            System.out.println(card);
        }
    }
    public void deleteCardByNumber(String cardNumber){
        ComponentController.cardRepository.deleteCard(cardNumber);
    }
    public void updateCardAdmin(){
        System.out.println("Enter card number : ");
        String cardNum = ScannerUtil.StringScanner.next().trim();
        System.out.println("Enter Exp date : ");
        LocalDate expDate = LocalDate.parse(ScannerUtil.LocalDateScanner.next().trim());
        ComponentController.cardRepository.updateCardAdmin(cardNum,expDate);
    }
    public void updateCardStatusAdmin(){
        System.out.println("Enter card number : ");
        String cardNum = ScannerUtil.StringScanner.next().trim();
        System.out.println("Enter status : ");
        System.out.println("1. ACTIVE\n" +
                "2. BLOCK");
        Status status=null;
            int action=ScannerUtil.IntScanner.nextInt();
            switch (action){
                case 1:
                    status=Status.ACTIVE;
                    break;
                case 2:
                    status=Status.BLOCK;
                    break;
            }

        ComponentController.cardRepository.updateCardStatusAdmin(cardNum,status);
    }
    public void setCardProfilePhone(String phone, String cardNumber){
        Integer profileIdByPhone = ComponentController.cardRepository.getProfileIdByPhone(phone);
        ComponentController.cardRepository.addCardUser(cardNumber,profileIdByPhone,phone);
    }
}
