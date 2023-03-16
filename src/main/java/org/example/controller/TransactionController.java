package org.example.controller;

import org.example.container.ComponentController;
import org.example.util.ScannerUtil;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class TransactionController {
    public void getTransactionsList(){
        ComponentController.transactionService.printTransaction();
    }
    public void getCompanyBalance(){
        ComponentController.transactionService.companyBalance();
    }
    public void getTodayTransaction(){
        ComponentController.transactionService.getTransactionToday();
    }
    public void getDayTransaction(){
        System.out.println("Enter date : ");
        String date=ScannerUtil.StringScanner.next().trim() ;
        ComponentController.transactionService.getDayTransaction(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
    public void getIntermediateDayTransaction(){
        System.out.println("Enter date : ");
        String date1=ScannerUtil.StringScanner.next().trim() ;
        System.out.println("Enter date : ");
        String date2=ScannerUtil.StringScanner.next().trim() ;
        ComponentController.transactionService.getIntermediateDayTransaction(LocalDate.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd")),LocalDate.parse(date2, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
    public void getTransactionByTerminal(){
        System.out.println("Enter terminal code : ");
        String terminalCode=ScannerUtil.StringScanner.next().trim() ;
        ComponentController.transactionService.getTransactionByTerminal(terminalCode);
    }
    public void getTransactionByCard(){
        System.out.println("Enter card number : ");
        String cardNumber=ScannerUtil.StringScanner.next().trim() ;
        ComponentController.transactionService.getTransactionByCard(cardNumber);
    }
}
