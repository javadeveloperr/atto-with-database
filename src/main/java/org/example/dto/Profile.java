package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.enums.Role;
import org.example.enums.Status;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@Entity
@Table(name = "atto_p")
public class Profile {
    @Id
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private String password;
    private Role role;
    private Status status;
    private LocalDateTime cratedDate;
}
