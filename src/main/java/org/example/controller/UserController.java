package org.example.controller;

import org.example.container.ComponentController;
import org.example.dto.Profile;
import org.example.enums.Status;
import org.example.util.ScannerUtil;
import java.util.List;

public class UserController {
    public void printProfiles() {
        List<Profile> users = ComponentController.userService.printUser();
        for (Profile profile : users) {
            System.out.println(profile);
        }

    }
    public void changeProfileStatus(){
        System.out.println("Enter profile phone : ");
        String phone = ScannerUtil.StringScanner.next().trim();
        Profile exists=ComponentController.userRepository.getProfileByPhone(phone);
        if (exists==null){
            System.out.println("User not found mazgi ");
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
        ComponentController.userService.profileStatus(phone, status);
    }
}
