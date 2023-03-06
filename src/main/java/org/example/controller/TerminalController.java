package org.example.controller;

import org.example.container.ComponentController;
import org.example.dto.Terminal;
import org.example.util.ScannerUtil;

public class TerminalController {
    public void createTerminal() {
        System.out.println("Enter terminal code : ");
        String terminalCode= ScannerUtil.StringScanner.next().trim();
        System.out.println("Enter terminal address : ");
        String terminalAddress=ScannerUtil.StringScanner.next().trim();
        Terminal terminal= ComponentController.terminal;
        terminal.setCode(terminalCode);
        terminal.setAddress(terminalAddress);
        ComponentController.terminalService.saveTerminal(terminal);
    }
    public void terminalList(){
        ComponentController.terminalService.printTerminalList();
    }
    public void updateTerminal(){
        ComponentController.terminalService.updateTerminal();
    }
    public void changeTerminalStatus(){
        ComponentController.terminalService.updateTerminalStatus();
    }
    public void deleteTerminal(){
        ComponentController.terminalService.deleteTerminal();
    }
}
