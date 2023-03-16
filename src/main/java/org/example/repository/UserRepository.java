package org.example.repository;
import org.example.container.ComponentController;
import org.example.dto.Profile;
import org.example.enums.Role;
import org.example.enums.Status;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
public class UserRepository {
    public Profile getProfileByPhone(String phone) {

        try {
            Profile profile = null;
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("select * from atto_p where phone=?");
            preparedStatement.setString(1, phone);
//            System.out.println(profile.getPhone());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                profile = new Profile();
                profile.setId(resultSet.getInt("id"));
                profile.setName(resultSet.getString("name"));
                profile.setSurname(resultSet.getString("surname"));
                profile.setPhone(resultSet.getString("phone"));
                profile.setRole(Role.valueOf(resultSet.getString("role")));
                profile.setStatus(Status.valueOf(resultSet.getString("status")));
                profile.setCratedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                profile.setPassword(resultSet.getString("password"));
                connection.close();
                return profile;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void saveProfile(Profile profile) {
        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into atto_p(name, surname,phone, password) values (?,?,?,?)");
            preparedStatement.setString(1, profile.getName());
            preparedStatement.setString(2, profile.getSurname());
            preparedStatement.setString(3, profile.getPhone());
            preparedStatement.setString(4, profile.getPassword());
            int effectedRows=preparedStatement.executeUpdate();
            if (effectedRows==1){
            System.out.println("Success");
            return;
            }
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Profile> getProfileList() {
        List<Profile> result = new LinkedList<>();
        try {
            Connection connection = org.example.db.Connection.getConnection();
            String sql = "select * from atto_p;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Profile profile=null;
            while (resultSet.next()) {
                profile=ComponentController.profile;
                profile.setId(resultSet.getInt("id"));
                profile.setName(resultSet.getString("name"));
                profile.setSurname(resultSet.getString("surname"));
                profile.setPhone(resultSet.getString("phone"));
                profile.setPassword(resultSet.getString("password"));
                profile.setCratedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                profile.setStatus(Status.valueOf(resultSet.getString("status")));
                profile.setRole(Role.valueOf(resultSet.getString("role")));
                result.add(profile);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
    public void updateUserStatus(String phone, Status status){
        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update atto_p set status=? where phone=?");
            preparedStatement.setString(1, String.valueOf(status));
            preparedStatement.setString(2, phone);
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
