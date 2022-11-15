package servlets;

import dao.UserDao;
import exceptions.DBException;
import models.User;
import org.apache.commons.codec.digest.DigestUtils;
import services.UserService;
import utils.ErrorHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDao userDao;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userDao = (UserDao) getServletContext().getAttribute("userDao");
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (userService.isAuthenticUser(req)) {
            resp.sendRedirect(req.getContextPath() + "/welcome/main-page");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (req.getParameter("btn-login") != null && !username.equals("") && !password.equals("")) {
            try {
                User user = userDao.getAccount(username, getPasswordHash(password));
                if (userService.authorizUser(user)) {
                    ErrorHelper.showMessage(req, resp, "Data entered incorrectly", "/error");
                } else {
                    userService.authenticUser(user, req);
                    resp.sendRedirect(req.getContextPath() + "/welcome/main-page");
                }
            } catch (DBException e) {
                throw new ServletException(e);
            }
        } else {
            ErrorHelper.showMessage(req, resp, "Fill in all the fields.", "/error");
        }

    }
    public static String getPasswordHash (String password) {
        return DigestUtils.md5Hex(password);
    }
}
