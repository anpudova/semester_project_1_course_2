package dao;

import exceptions.DBException;
import models.Article;
import models.Cat;
import utils.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticleDao {

    private final ConnectionProvider cp;

    public ArticleDao(ConnectionProvider cp) {
        this.cp = cp;
    }

    public ArrayList<Article> getArticles(String category) throws DBException {
        try {
            Connection connection = cp.getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "select id_a, name_a, content, image, name_c from articles a " +
                            "join list_art_categ l on a.id_a = l.id_article " +
                            "join category c on l.id_category = c.id_c where name_c = ?");
            ps.setString(1, category);
            ResultSet result = ps.executeQuery();
            ArrayList<Article> articleList = new ArrayList<>();

            while (result.next()) {
                Article article = new Article(
                        result.getInt("id_a"),
                        result.getString("name_a"),
                        result.getString("content"),
                        result.getString("image")
                );
                articleList.add(article);
            }
            if (articleList.isEmpty()) {
                return null;
            } else {
                return articleList;
            }
        } catch (SQLException e) {
            throw new DBException("Can't connect to DB.", e);
        }
    }
    public Article getDetail(Integer id) throws DBException {
        try {
            Connection connection = cp.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from articles where id_a = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            boolean hasOne = result.next();

            if (hasOne) {
                return new Article(
                        result.getInt("id_a"),
                        result.getString("name_a"),
                        result.getString("content"),
                        result.getString("image")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DBException("Can't connect to DB.", e);
        }
    }

    public void updateBreeds(Integer id, String name, String content) throws DBException {
        try {
            Connection connection = cp.getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "update articles " +
                            "set name_a = ?, content = ? " +
                            "where id_a = ?");
            ps.setString(1, name);
            ps.setString(2, content);
            ps.setInt(3, id);
            ps.execute();
        } catch (SQLException e) {
            throw new DBException("Can't connect to DB.", e);
        }
    }
}
