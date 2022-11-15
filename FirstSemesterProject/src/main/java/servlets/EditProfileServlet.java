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

@WebServlet("/welcome/profile/edit")
public class EditProfileServlet extends HttpServlet {

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
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/edit-profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (req.getParameter("btn-save") != null) {
            String validData = userService.validInputData(username, email, password);
            if (validData.equals("")) {
                try {
                    String message = userDao.existAccount(username, email);
                    if (message.equals("")) {
                        Integer id = userService.getUser(req).getId();
                        userDao.updateAccount(id, username, email, getPasswordHash(password));
                        userService.editProfile(req, username, email, getPasswordHash(password));
                        resp.sendRedirect(req.getContextPath() + "/welcome/profile");
                    } else {
                        ErrorHelper.showMessage(req, resp, message, "/error");
                    }
                } catch (DBException e) {
                    throw new ServletException(e);
                }
            } else {
                ErrorHelper.showMessage(req, resp, "The data is entered incorrectly ( " + validData + ").", "/error");
            }
        }
    }

    public static String getPasswordHash (String password) {
        return DigestUtils.md5Hex(password);
    }
}
