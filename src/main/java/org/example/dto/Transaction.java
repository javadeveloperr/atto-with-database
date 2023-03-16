package org.example.dto;
import lombok.*;
import org.example.enums.TransactionType;
import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private Integer id;
    private String cardNumber;
    private Double amount;
    private String terminalCode;
    private TransactionType transactionType;
    private LocalDateTime createdDate;
}