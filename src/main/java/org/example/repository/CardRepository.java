package org.example.repository;

import org.example.container.ComponentController;
import org.example.dto.Card;
import org.example.enums.Status;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CardRepository {
    public Card getCardByNumber(String cardNumber) {
        Card card = null;
        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from atto_card where number=?");
            preparedStatement.setString(1, cardNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                card = ComponentController.card;
                card.setId(resultSet.getInt("id"));
                card.setNumber(resultSet.getString("number"));
                card.setExp_date(resultSet.getString("exp_date"));
                card.setPhone(resultSet.getString("phone"));
                card.setStatus(Status.valueOf(resultSet.getString("status")));
                card.setBalance(resultSet.getDouble("balance"));
                card.setCreated_date(resultSet.getTimestamp("created_date").toLocalDateTime());
                connection.close();
                return card;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void createCard(Card card) {
        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into atto_card(number,exp_date,balance,status,created_date) values (?,?,?,?,now())");
            preparedStatement.setString(1, card.getNumber());
            preparedStatement.setDate(2, Date.valueOf(LocalDate.parse(card.getExp_date())));
            preparedStatement.setDouble(3, 0d);
            preparedStatement.setString(4, String.valueOf(Status.ACTIVE));
            int effectedRows = preparedStatement.executeUpdate();
            if (effectedRows == 1) {
                System.out.println("Success");
                return;
            }
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Card> adminGetCardList() {
        List<Card> result = new LinkedList<>();
        try {
            Connection connection = org.example.db.Connection.getConnection();
            String sql = "select * from atto_card ";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Integer cardId = resultSet.getInt("id");
                String cardNumber = resultSet.getString("number");
                Double balance = resultSet.getDouble("balance");
                LocalDate expDate = resultSet.getDate("exp_date").toLocalDate();
                String status = resultSet.getString("status");
                String phone = resultSet.getString("phone");
                LocalDateTime createdDate = resultSet.getTimestamp("created_date").toLocalDateTime();

                Card card = new Card();
                card.setId(cardId);
                card.setNumber(cardNumber);
                card.setBalance(balance);
                card.setExp_date(expDate.toString());
                card.setStatus(Status.valueOf(status));
                card.setPhone(phone);
                card.setCreated_date(createdDate);

                result.add(card);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public void deleteCard(String cardNumber) {
        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from atto_card where number=?");
            preparedStatement.setString(1, cardNumber);
//            ResultSet resultSet = preparedStatement.executeQuery();
            int effectedRows = preparedStatement.executeUpdate();
            if (effectedRows == 1) {
                System.out.println("Success");
                return;
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void updateCardAdmin(String cardNumber, LocalDate date){

        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update atto_card set exp_date=? where number=?");
            preparedStatement.setDate(1, Date.valueOf(date));
            preparedStatement.setString(2, cardNumber);
//            ResultSet resultSet = preparedStatement.executeQuery();
            int effectedRows = preparedStatement.executeUpdate();
            if (effectedRows == 1) {
                System.out.println("Success");
                return;
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCardStatusAdmin(String cardNumber, Status status){
        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update atto_card set status=? where number=?");
            preparedStatement.setString(1, String.valueOf(status));
            preparedStatement.setString(2, cardNumber);
//            ResultSet resultSet = preparedStatement.executeQuery();
            int effectedRows = preparedStatement.executeUpdate();
            if (effectedRows == 1) {
                System.out.println("Success");
                return;
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
