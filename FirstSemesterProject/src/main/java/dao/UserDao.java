package dao;

import exceptions.DBException;
import models.Cat;
import models.User;
import utils.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

    private final ConnectionProvider cp;

    public UserDao(ConnectionProvider cp) {
        this.cp = cp;
    }

    public User getAccount(String username, String password) throws DBException {
        try {
            Connection connection = cp.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from users where name=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                return new User(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("email"),
                        null,
                        result.getString("role")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DBException("Can't connect to DB.", e);
        }
    }

    public ArrayList<User> getUsers() throws DBException {
        try {
            Connection connection = cp.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from users");
            ResultSet result = ps.executeQuery();
            ArrayList<User> userList = new ArrayList<>();

            while (result.next()) {
                User user = new User(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("email"),
                        result.getString("role")
                );
                userList.add(user);
            }
            if (userList.isEmpty()) {
                return null;
            } else {
                return userList;
            }
        } catch (SQLException e) {
            throw new DBException("Can't connect to DB.", e);
        }
    }

    public void insertAccount(String username, String email, String password) throws DBException {
        try {
            Connection connection = cp.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into users (name, email, password) values (?,?,?)");
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.execute();
        } catch (SQLException e) {
            throw new DBException("Can't connect to DB.", e);
        }
    }

    public void updateAccount(Integer id, String username, String email, String password) throws DBException {
        try {
            Connection connection = cp.getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "update users set name = ?, email = ?, password = ? where id = ?");
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setInt(4, id);
            ps.execute();
        } catch (SQLException e) {
            throw new DBException("Can't connect to DB.", e);
        }
    }

    public void deleteAccount(Integer id) throws DBException {
        try {
            Connection connection = cp.getConnection();
            PreparedStatement psCats = connection.prepareStatement("delete from cats where owner_id = ?");
            psCats.setInt(1, id);
            psCats.execute();
            PreparedStatement psUser = connection.prepareStatement("delete from users where id = ?");
            psUser.setInt(1, id);
            psUser.execute();
        } catch (SQLException e) {
            throw new DBException("Can't connect to DB.", e);
        }
    }

    public String existAccount(String username, String email) throws DBException {
        try {
            Connection connection = cp.getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "select name, email from users where name = ? or email = ?");
            ps.setString(1, username);
            ps.setString(2, email);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                if (result.getString("name").equals(username)) {
                    return "An account with this username already exists.";
                } else if (result.getString("email").equals(email)) {
                    return "This email is already linked to another account.";
                } else {
                    return "";
                }
            } else {
                return "";
            }
        } catch (SQLException e) {
            throw new DBException("Can't connect to DB.", e);
        }
    }
}
