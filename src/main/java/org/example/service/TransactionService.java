package org.example.service;

import org.example.container.ComponentController;
import org.example.dto.Transaction;

import java.time.LocalDate;
import java.util.List;

public class TransactionService {
    public void printTransaction() {
        List<Transaction> transactions = ComponentController.transactionRepository.getTransactionList();
        if (!transactions.isEmpty()) {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }else {
            System.out.println("Mazgi No transactions yet!");
            return;
        }
    }
    public void companyBalance(){
        ComponentController.transactionRepository.getCompanyCardBalance();
    }
    public void getTransactionToday(){
        List<Transaction> transactions =ComponentController.transactionRepository.getTodayTransaction();
        if (!transactions.isEmpty()) {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }else {
            System.out.println("Mazgi No Today transactions yet!");
            return ;
        }
    }
    public void getDayTransaction(LocalDate date){
        List<Transaction> transactions =ComponentController.transactionRepository.getDayTransaction(date);
        if (!transactions.isEmpty()) {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }else {
            System.out.println("Mazgi No Today transactions yet!");
            return ;
        }
    }
    public void getIntermediateDayTransaction(LocalDate date1, LocalDate date2){
        List<Transaction> transactions =ComponentController.transactionRepository.getIntermediateDayTransaction(date1, date2);
        if (!transactions.isEmpty()) {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }else {
            System.out.println("Mazgi No Today transactions yet!");
            return ;
        }
    }
    public void getTransactionByTerminal(String terminalCode){
        List<Transaction> transactions =ComponentController.transactionRepository.getTransactionByTerminal(terminalCode);
        if (!transactions.isEmpty()) {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }else {
            System.out.println("Mazgi No Today transactions yet!");
            return ;
        }
    }
    public void getTransactionByCard(String cardNumber){
        List<Transaction> transactions =ComponentController.transactionRepository.getTransactionByCard(cardNumber);
        if (!transactions.isEmpty()) {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }else {
            System.out.println("Mazgi No Today transactions yet!");
            return ;
        }
    }
}
