package services;

import dao.ArticleDao;
import dao.CatDao;
import exceptions.DBException;
import models.Article;
import models.User;

import javax.servlet.http.HttpServletRequest;

public class ArticleService {

    private final ArticleDao articleDao;

    public ArticleService(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public void initArticle(HttpServletRequest req) throws DBException {
        String id = req.getParameter("id");
        Article article = articleDao.getDetail(Integer.parseInt(id));
        req.getSession().setAttribute("article", article);
    }

    public void updateArticle(HttpServletRequest req, String name, String content) throws DBException {
        String id = req.getParameter("id");
        articleDao.updateBreeds(Integer.valueOf(id), name, content);
    }

    public void getArticles(HttpServletRequest req, String category) throws DBException {
        req.setAttribute("articles", articleDao.getArticles(category));
    }
}
