package listeners;

import dao.ArticleDao;
import dao.CatDao;
import dao.UserDao;
import exceptions.DBException;
import models.Article;
import services.ArticleService;
import services.CatService;
import services.FilesService;
import services.UserService;
import utils.ConnectionProvider;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionProvider connectionProvider = ConnectionProvider.getInstance();
            sce.getServletContext().setAttribute("userDao", new UserDao(connectionProvider));
            sce.getServletContext().setAttribute("userService", new UserService(new UserDao(connectionProvider)));
            sce.getServletContext().setAttribute("catDao", new CatDao(connectionProvider));
            sce.getServletContext().setAttribute("catService", new CatService(new CatDao(connectionProvider)));
            sce.getServletContext().setAttribute("articleDao", new ArticleDao(connectionProvider));
            sce.getServletContext().setAttribute("articleService", new ArticleService(new ArticleDao(connectionProvider)));
            sce.getServletContext().setAttribute("filesService", new FilesService());
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
