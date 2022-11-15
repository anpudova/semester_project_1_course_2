package servlets;

import dao.UserDao;
import exceptions.DBException;
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

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

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
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (req.getParameter("btn-register") != null & req.getParameter("agreement").equals("agree")) {
            String validData = userService.validInputData(username, email, password);
            if (validData.equals("")) {
                try {
                    String message = userDao.existAccount(username, email);
                    if (message.equals("")) {
                        userDao.insertAccount(username, email, getPasswordHash(password));
                        resp.sendRedirect(req.getContextPath() + "/login");
                    } else {
                        ErrorHelper.showMessage(req, resp, message, "/error");
                    }
                } catch (DBException e) {
                    throw new ServletException(e);
                }
            } else {
                ErrorHelper.showMessage(req, resp, "Data entered incorrectly ( " + validData + ")", "/error");
            }
        } else {
            ErrorHelper.showMessage(req, resp, "Confirm your consent to data processing.", "/error");
        }
    }

    public static String getPasswordHash (String password) {
        return DigestUtils.md5Hex(password);
    }
}

