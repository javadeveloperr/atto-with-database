package org.example.dto;

import lombok.*;
import org.example.enums.Status;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "terminal")
public class Terminal {
    @Id
    private String code;
    private String address;
    private Status status;
    private LocalDateTime created_date;
}
