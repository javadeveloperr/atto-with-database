package org.example.dto;

import lombok.*;
import org.example.enums.Status;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Terminal {
    private String code;
    private String address;
    private Status status;
    private LocalDateTime created_date;
}
