package servlets;

import dao.CatDao;
import exceptions.DBException;
import models.User;
import services.CatService;
import services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/welcome/profile/cats")
public class CatsServlet extends HttpServlet {

    private UserService userService;
    private CatService catService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        catService = (CatService) getServletContext().getAttribute("catService");
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            catService.initCats(req, userService.getUser(req).getId());
        } catch (DBException e) {
            throw new ServletException(e);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/cats.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
