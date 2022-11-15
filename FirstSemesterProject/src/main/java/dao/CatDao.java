package dao;

import exceptions.DBException;
import models.Cat;
import models.User;
import utils.ConnectionProvider;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatDao {

    private final ConnectionProvider cp;

    public CatDao(ConnectionProvider cp) {
        this.cp = cp;
    }

    public void insertCat(String name, Integer owner_id, Integer age, String breed, String character, String photo) throws DBException {
        try {
            Connection connection = cp.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into cats (name_c, owner_id, age, breed, character, photo) values (?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setInt(2, owner_id);
            ps.setInt(3, age);
            ps.setString(4, breed);
            ps.setString(5, character);
            ps.setString(6, photo);
            ps.execute();
        } catch (SQLException e) {
            throw new DBException("Can't connect to DB.", e);
        }
    }

    public ArrayList<Cat> getCats(Integer owner_id) throws DBException {
        try {
            Connection connection = cp.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from cats where owner_id = ?");
            ps.setInt(1, owner_id);
            ResultSet result = ps.executeQuery();
            ArrayList<Cat> catList = new ArrayList<>();

            while (result.next()) {
                Cat cat = new Cat(
                result.getInt("id_c"),
                result.getString("name_c"),
                result.getInt("owner_id"),
                result.getInt("age"),
                result.getString("breed"),
                result.getString("character"),
                result.getString("photo")
                );
                catList.add(cat);
            }
            if (catList.isEmpty()) {
                return null;
            } else {
                return catList;
            }
        } catch (SQLException e) {
            throw new DBException("Can't connect to DB.", e);
        }
    }

    public ArrayList<Cat> getAllCats() throws DBException {
        try {
            Connection connection = cp.getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "select name_c, age, breed, character, name, photo from cats c " +
                            "inner join users u on c.owner_id = u.id");
            ResultSet result = ps.executeQuery();
            ArrayList<Cat> catList = new ArrayList<>();

            while (result.next()) {
                Cat cat = new Cat(
                        result.getString("name_c"),
                        result.getInt("age"),
                        result.getString("breed"),
                        result.getString("character"),
                        result.getString("name"),
                        result.getString("photo")
                );
                catList.add(cat);
            }
            if (catList.isEmpty()) {
                return null;
            } else {
                return catList;
            }
        } catch (SQLException e) {
            throw new DBException("Can't connect to DB.", e);
        }
    }
}
