package org.example.service;
import org.example.container.ComponentController;
import org.example.dto.Profile;
public class UserService {
    public void addUser(Profile profile){
        Profile existsProfile = ComponentController.userRepository.getProfileByPhone(profile.getPhone());
        if (existsProfile!=null){
            System.out.println("User already registered");
            return;
        }
        ComponentController.userRepository.saveProfile(profile);
    }
}
