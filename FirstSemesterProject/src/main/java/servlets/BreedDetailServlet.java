package servlets;

import exceptions.DBException;
import services.ArticleService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/welcome/breed/detail")
public class BreedDetailServlet extends HttpServlet {

    private ArticleService articleService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        articleService = (ArticleService) getServletContext().getAttribute("articleService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            articleService.initArticle(req);
        } catch (DBException e) {
            throw new ServletException(e);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/breed-detail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
