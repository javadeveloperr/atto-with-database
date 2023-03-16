package org.example.repository;

import org.example.container.ComponentController;
import org.example.dto.Terminal;
import org.example.dto.Transaction;
import org.example.enums.Status;
import org.example.enums.TransactionType;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class TransactionRepository {
    public List<Transaction> getTransactionList() {
        List<Transaction> result = new LinkedList<>();
        try {
            Connection connection = org.example.db.Connection.getConnection();
            String sql = "select * from transaction;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Transaction transaction = null;
            while (resultSet.next()) {
                transaction = ComponentController.transaction;
                transaction.setId(resultSet.getInt("id"));
                transaction.setCardNumber(resultSet.getString("card_number"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setTerminalCode(resultSet.getString("terminal_code"));
                transaction.setTransactionType(TransactionType.valueOf(resultSet.getString("type")));
                transaction.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                result.add(transaction);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public Double getCompanyCardBalance() {
            Double balanceCompanyCard=0d;
        try {
            Connection connection = org.example.db.Connection.getConnection();
            String sql = "select balance from atto_card where number='7777' and phone='914444150';";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (!resultSet.wasNull()){
            balanceCompanyCard=resultSet.getDouble("balance");}
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return balanceCompanyCard;
    }
    public List<Transaction> getTodayTransaction() {
        List<Transaction> result = new LinkedList<>();
        LocalDate date=ComponentController.localDate;
        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from transaction where DATE(created_date)=?;");
            preparedStatement.setDate(1, Date.valueOf(date));
            Transaction transaction = null;
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                transaction = ComponentController.transaction;
                transaction.setId(resultSet.getInt("id"));
                transaction.setCardNumber(resultSet.getString("card_number"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setTerminalCode(resultSet.getString("terminal_code"));
                transaction.setTransactionType(TransactionType.valueOf(resultSet.getString("type")));
                transaction.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                result.add(transaction);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
    public List<Transaction> getDayTransaction(LocalDate date) {
        List<Transaction> result = new LinkedList<>();
        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from transaction where DATE(created_date)=?;");
            preparedStatement.setDate(1, Date.valueOf(date));
            Transaction transaction = null;
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                transaction = ComponentController.transaction;
                transaction.setId(resultSet.getInt("id"));
                transaction.setCardNumber(resultSet.getString("card_number"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setTerminalCode(resultSet.getString("terminal_code"));
                transaction.setTransactionType(TransactionType.valueOf(resultSet.getString("type")));
                transaction.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                result.add(transaction);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
    public List<Transaction> getIntermediateDayTransaction(LocalDate date1, LocalDate date2) {
        List<Transaction> result = new LinkedList<>();
        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from transaction where DATE(created_date)>=? and DATE(created_date)<=?;");
            preparedStatement.setDate(1, Date.valueOf(date1));
            preparedStatement.setDate(2, Date.valueOf(date2));
            Transaction transaction = null;
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                transaction = ComponentController.transaction;
                transaction.setId(resultSet.getInt("id"));
                transaction.setCardNumber(resultSet.getString("card_number"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setTerminalCode(resultSet.getString("terminal_code"));
                transaction.setTransactionType(TransactionType.valueOf(resultSet.getString("type")));
                transaction.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                result.add(transaction);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
    public List<Transaction> getTransactionByTerminal(String terminalCode) {
        List<Transaction> result = new LinkedList<>();
        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from transaction where terminal_code=?");
            preparedStatement.setString(1, terminalCode);
            Transaction transaction = null;
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                transaction = ComponentController.transaction;
                transaction.setId(resultSet.getInt("id"));
                transaction.setCardNumber(resultSet.getString("card_number"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setTerminalCode(resultSet.getString("terminal_code"));
                transaction.setTransactionType(TransactionType.valueOf(resultSet.getString("type")));
                transaction.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                result.add(transaction);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
    public List<Transaction> getTransactionByCard(String cardNumber) {
        List<Transaction> result = new LinkedList<>();
        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from transaction where card_number=?");
            preparedStatement.setString(1, cardNumber);
            Transaction transaction = null;
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                transaction = ComponentController.transaction;
                transaction.setId(resultSet.getInt("id"));
                transaction.setCardNumber(resultSet.getString("card_number"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setTerminalCode(resultSet.getString("terminal_code"));
                transaction.setTransactionType(TransactionType.valueOf(resultSet.getString("type")));
                transaction.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                result.add(transaction);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
}
