package org.example.dto;
import lombok.*;
import org.example.enums.TransactionType;

import javax.persistence.Column;
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
@Table(name = "transaction")
public class Transaction {
    @Id
    private Integer id;
    @Column(name = "card_number")
    private String cardNumber;
    private Double amount;
    @Column(name = "terminal_code")
    private String terminalCode;
    @Column(name = "type")
    private TransactionType transactionType;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
}