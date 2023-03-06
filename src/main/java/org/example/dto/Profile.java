package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.enums.Role;
import org.example.enums.Status;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
public class Profile {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private String password;
    private Role role;
    private Status status;
    private LocalDateTime cratedDate;
}
