package org.example.db;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static org.example.db.Connection.getConnection;
public class TransactionDB {
    public static void createTransactionTable() {
        try {
            String transactionQuery = "create table if not exists transaction( " +
                    "id serial primary key, " +
                    "card_number varchar(16) not null," +
                    "amount double precision not null," +
                    "terminal_code varchar not null," +
                    "type varchar(10) not null," +
                    "created_date timestamp not null default now()," +
                    "foreign key(terminal_code) references terminal(code)," +
                    "foreign key(card_number) references atto_card(number));";
            Connection con = getConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate(transactionQuery);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
