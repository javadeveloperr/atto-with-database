package org.example.db;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.db.Connection.getConnection;

public class ProfileDB {

    public static void createProfileTable() {
//        try {
//            String attoProfile = "create table  atto_p( " +
//                    "                id serial primary key, " +
//                    "                name varchar(25) not null, " +
//                    "                surname varchar(25) not null, " +
//                    "                phone varchar(13) unique, " +
//                    "                password varchar," +
//                    "                created_date timestamp not null default now()," +
//                    "                status varchar not null default 'ACTIVE'," +
//                    "                role varchar not null default 'USER'" +
//                    "         );";
//            Connection con = getConnection();
//            Statement statement = con.createStatement();
//            statement.executeUpdate(attoProfile);
//            System.out.println(attoProfile.toString());
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
        try {
        String attoCard = "create table if not exists atto_p( " +
                "                id serial primary key, " +
                "                name varchar(50) not null, " +
                "                surname varchar(50) not null, " +
                "                phone varchar(50) not null, " +
                "                password varchar(50) not null);";
        Connection con = getConnection();
        Statement statement = con.createStatement();
        statement.executeUpdate(attoCard);
        con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
