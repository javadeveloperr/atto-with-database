package org.example.controller;

import org.example.container.ComponentController;
import org.example.db.ProfileDB;
import org.example.dto.Profile;
import org.example.enums.Role;
import org.example.util.ScannerUtil;

import java.sql.*;

import static org.example.db.Connection.getConnection;

public class MenuController {
    public static Integer action() {
        System.out.println("Select menu : ");
        return ScannerUtil.IntScanner.nextInt();
    }
    public void mainMenu() {
        System.out.println("***   Menu   ***");
        System.out.println("1. Log In");
        System.out.println("2. Registration");
        System.out.println("0. Exit");
        boolean b=true;
        while (b){
        int action=action();
            switch (action){
                case 1 -> logIn();
                case 2 -> {
                    register();
                    break;
                }
                case 0 ->{
                    b=false;
                    break;
                }
                default -> System.out.println("Mazgi  select menu");
            }
        }
    }

    private void register() {
//        ProfileDB.createProfileTable();
        System.out.print("Enter name: ");
        String name=ScannerUtil.StringScanner.next().trim();
        System.out.print("Enter surname: ");
        String surname=ScannerUtil.StringScanner.next().trim();
        System.out.print("Enter phone: ");
        String phone=ScannerUtil.StringScanner.next();
        System.out.print("Enter password: ");
        String password=ScannerUtil.StringScanner.next();
        Profile profile=new Profile();
        profile.setName(name);
        profile.setSurname(surname);
        profile.setPhone(phone);
        profile.setPassword(password);
        profile.setRole(Role.USER);
        ComponentController.userService.addUser(profile);
        return;
    }
    public static boolean isAdmin(String number, String password) {
        Connection con = getConnection();
        // 3-poyezd
//        Statement statement = null;
        try {
//            statement = con.createStatement();
//            String sql = String.format("Select * from profile where phone = '%s' and  role='ADMIN' and password = '%s'", number, password);
//            ResultSet resultSet = statement.executeQuery(sql);
            PreparedStatement preparedStatement= con.prepareStatement("select * from atto_p where phone=? and  role='ADMIN' and password=?;");
            preparedStatement.setString(1,number);
            preparedStatement.setString(2, password);
            ResultSet resultSet= preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    private void logIn() {
        System.out.println("Enter phone : ");
        String phone=ScannerUtil.StringScanner.next().trim();
        System.out.println("Enter password : ");
        String password=ScannerUtil.StringScanner.next().trim();
        if (isAdmin(phone,password)){
            ComponentController.adminMenuController.adminMenu();
        }else {
            System.out.println("User menyunu yasang");
        }
    }
}