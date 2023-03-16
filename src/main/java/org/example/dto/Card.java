package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.enums.Status;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@Entity
@Table(name = "atto_card")
public class Card {
    @Id
    private Integer id;
    private String number;
    private String exp_date;
    private Double balance;
    private Status status;
    private String phone;
    private LocalDateTime created_date;

    public Card(Integer id, String number, String exp_date, Double balance, Status status, String phone, LocalDateTime created_date) {
        this.id=id;
        this.number = number;
        this.exp_date = exp_date;
        this.balance = balance;
        this.status = status;
        this.phone = phone;
        this.created_date = created_date;
    }

    public Card() {
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", exp_date='" + exp_date + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                ", phone='" + phone + '\'' +
                ", created_date=" + created_date +
                '}';
    }
}
