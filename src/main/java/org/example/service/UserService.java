package org.example.service;
import org.example.container.ComponentController;
import org.example.dto.Profile;
import org.example.enums.Status;

import java.util.List;

public class UserService {
    public void addUser(Profile profile){
        Profile existsProfile = ComponentController.userRepository.getProfileByPhone(profile.getPhone());
        if (existsProfile!=null){
            System.out.println("User already registered");
            return;
        }
        ComponentController.userRepository.saveProfile(profile);
    }
    public List<Profile> printUser(){
      return   ComponentController.userRepository.getProfileList();
    }

    public void profileStatus(String phone, Status status) {
        ComponentController.userRepository.updateUserStatus(phone,status);
    }
}
