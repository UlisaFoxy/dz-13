package dbreadertests;
import models.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBReader {

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USER_NAME = "postgres";
    private final static String USER_PASSWORD = "postgres";
    private final static String QUERY_SELECT_ALL = "select * from Tickets1";
    private final static String QUERY_INSERT = "insert into Tickets1 values(?,?,?)";
    private final static String QUERY_UPDATE = "update Tickets1 set price=? where id=?";
    private final static String QUERY_DELETE = "delete from Tickets1 where id=?";

    public static List<Ticket> getTicketsFromTable() {
        List<Ticket> tickets = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {
            Statement sqlStatement =  connection.createStatement();
            ResultSet resultSet = sqlStatement.executeQuery(QUERY_SELECT_ALL);


            while (resultSet.next()){
                Ticket ticket = new Ticket(resultSet.getInt("num"),resultSet.getFloat("price"));
                tickets.add(ticket);
            }

        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Please check connection string" +
                    ". URL [%s], name [%s], pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }
        return tickets;
    }

    public static void insert(int id, int num, float price) {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, 9);
            preparedStatement.setInt(2, 10);
            preparedStatement.setFloat(3, 25.5f);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Please check connection string" +
                    ". URL [%s], name [%s], pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }

    }

    public static void update(int id, float price) {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setInt(1, 2);
            preparedStatement.setFloat(2, 38.9f);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Please check connection string" +
                    ". URL [%s], name [%s], pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }
    }

    public static void delete(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, 5);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Please check connection string" +
                    ". URL [%s], name [%s], pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }
    }
    public static void main (String[] args){getTicketsFromTable();}
}