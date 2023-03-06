package org.example.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.db.Connection.getConnection;

public class TransactionDB {
    public static void createTransactionType() {
        try {
            Connection connection = getConnection();
            String statusTerminalQuery = "CREATE TYPE transaction_type AS ENUM" +
                    "('REFILL','PAYMENT')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(statusTerminalQuery);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTransactionTable() {
        createTransactionType();
        try {
            String transactionQuery = "create table if not exists atto_card( " +
                    "id serial primary key, " +
                    "card_number varchar(16) not null," +
                    "amount double precision not null," +
                    "terminal_code integer not null," +
                    "type transaction_type not null," +
                    "created_date timestamp not null default now()," +
                    "foreign key(terminal_code) references terminal(id)," +
                    "foreign key(card_number) references atto_card(number)" +
                    "         );";
            Connection con = getConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate(transactionQuery);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
