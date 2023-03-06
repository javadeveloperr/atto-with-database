package org.example.service;

import org.example.container.ComponentController;
import org.example.dto.Card;
import org.example.dto.Terminal;
import org.example.enums.Status;
import org.example.util.ScannerUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TerminalService {
    public void saveTerminal(Terminal terminal) {
        Terminal exists = ComponentController.terminalRepository.getTerminalById(terminal.getCode());
        if (exists!=null){
            System.out.println("Mazgi this terminal already created ! ");
            return;
        }else {
            terminal.setStatus(Status.ACTIVE);
            terminal.setCreated_date(LocalDateTime.now());
        ComponentController.terminalRepository.createTerminal(terminal);
        }
    }
    public void printTerminalList(){
        List<Terminal> terminals=ComponentController.terminalRepository.getTerminalList();
        for (Terminal terminal: terminals) {
            System.out.println(terminal);
        }
    }
    public void deleteTerminal(){
        System.out.println("Enter terminal code : ");
        String terminalCode = ScannerUtil.StringScanner.next().trim();
        Terminal exists=ComponentController.terminalRepository.getTerminalById(terminalCode);
        if (exists==null){
            System.out.println("Terminal not found mazgi ");
        }
        ComponentController.terminalRepository.deleteTerminal(terminalCode);
    }
    public void updateTerminal(){
        System.out.println("Enter terminal code : ");
        String terminalCode = ScannerUtil.StringScanner.next().trim();
        Terminal exists=ComponentController.terminalRepository.getTerminalById(terminalCode);
        if (exists==null){
            System.out.println("Terminal not found mazgi ");
        }
        System.out.println("Enter terminal address : ");
        String address = ScannerUtil.StringScanner.next().trim();
        ComponentController.terminalRepository.updateTerminal(terminalCode, address);
    }
    public void updateTerminalStatus(){
        System.out.println("Enter terminal code : ");
        String terminalCode = ScannerUtil.StringScanner.next().trim();
        Terminal exists=ComponentController.terminalRepository.getTerminalById(terminalCode);
        if (exists==null){
            System.out.println("Terminal not found mazgi ");
        }
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
        ComponentController.terminalRepository.updateTerminalStatus(terminalCode,status);
    }
}
