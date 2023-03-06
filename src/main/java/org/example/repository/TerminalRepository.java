package org.example.repository;
import org.example.container.ComponentController;
import org.example.dto.Terminal;
import org.example.enums.Status;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
public class TerminalRepository {
    public Terminal getTerminalById(String code) {
        Terminal terminal = null;
        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from terminal where code=?");
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                terminal=ComponentController.terminal;
                terminal.setCode(resultSet.getString("code"));
                terminal.setAddress(resultSet.getString("address"));
                terminal.setStatus(Status.valueOf(resultSet.getString("status")));
                terminal.setCreated_date(resultSet.getTimestamp("created_date").toLocalDateTime());
                connection.close();
                return terminal;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void createTerminal(Terminal terminal) {
        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into terminal(code,address,status,created_date) values (?,?,?,?)");
            preparedStatement.setString(1, terminal.getCode());
            preparedStatement.setString(2, terminal.getAddress());
            preparedStatement.setString(3, terminal.getStatus().name());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(terminal.getCreated_date()));
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
    public List<Terminal> getTerminalList() {
        List<Terminal> result = new LinkedList<>();
        try {
            Connection connection = org.example.db.Connection.getConnection();
            String sql = "select * from terminal;";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Terminal terminal=ComponentController.terminal;
                terminal.setCode(resultSet.getString("code"));
                terminal.setAddress(resultSet.getString("address"));
                terminal.setStatus(Status.valueOf(resultSet.getString("status")));
                terminal.setCreated_date(resultSet.getTimestamp("created_date").toLocalDateTime());
                result.add(terminal);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
    public void deleteTerminal(String terminalCode) {
        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from terminal where code=?");
            preparedStatement.setString(1, terminalCode);
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
    public void updateTerminal(String terminalCode, String address){

        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update terminal set address=? where code=?");
            preparedStatement.setString(1,address);
            preparedStatement.setString(2, terminalCode);
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

    public void updateTerminalStatus(String terminalCode, Status status){
        try {
            Connection connection = org.example.db.Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update terminal set status=? where code=?");
            preparedStatement.setString(1, String.valueOf(status));
            preparedStatement.setString(2, terminalCode);
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
