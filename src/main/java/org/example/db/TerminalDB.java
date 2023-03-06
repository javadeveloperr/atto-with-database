package org.example.db;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static org.example.db.Connection.getConnection;
public class TerminalDB {
    public static void createTerminalTable() {
        try {
            String attoCard = "create table if not exists terminal( " +
                    "                code varchar unique, " +
                    "                address varchar(50) not null, " +
                    "                status varchar not null default 'ACTIVE'," +
                    "                created_date timestamp not null default now()" +
                    "         );";
            Connection con = getConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate(attoCard);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
