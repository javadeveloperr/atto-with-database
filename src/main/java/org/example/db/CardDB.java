//package org.example.db;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import static org.example.db.Connection.getConnection;
//
//
//public class CardDB {
//    public static void createTypeCardStatus() {
//        try {
//            Connection connection = getConnection();
//            String statusCardQuery = "CREATE TYPE card_status AS ENUM" +
//                    "('ACTIVE','BLOCK')";
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(statusCardQuery);
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public static void createCardTable() {
////        createTypeCardStatus();
//        try {
//            String attoCard = "create table if not exists atto_card( " +
//                    "                id serial primary key, " +
//                    "                number varchar(16) unique not null, " +
//                    "                exp_date date not null, " +
//                    "                balance double precision not null," +
//                    "                status varchar(10) not null," +
//                    "                phone varchar(13)," +
//                    "                created_date timestamp not null," +
//                    "                profile_id integer," +
//                    "                foreign key(profile_id) references atto_p(id)" +
//                    "         );";
//            Connection con = getConnection();
//            Statement statement = con.createStatement();
//            statement.executeUpdate(attoCard);
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
