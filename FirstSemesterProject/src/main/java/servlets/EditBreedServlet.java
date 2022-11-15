package servlets;

import dao.ArticleDao;
import dao.UserDao;
import exceptions.DBException;
import models.Article;
import org.apache.commons.codec.digest.DigestUtils;
import services.ArticleService;
import services.UserService;
import utils.ErrorHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/welcome/admin/edit-breed")
public class EditBreedServlet extends HttpServlet {

    private ArticleService articleService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        articleService = (ArticleService) getServletContext().getAttribute("articleService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            articleService.initArticle(req);
        } catch (DBException e) {
            throw new ServletException(e);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/edit-breed.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String content = req.getParameter("content");
        if (req.getParameter("btn-save") != null) {
            try {
                articleService.updateArticle(req, name, content);
            } catch (DBException e) {
                throw new ServletException(e);
            }
            resp.sendRedirect(req.getContextPath() + "/welcome/admin");
        }
    }
}
