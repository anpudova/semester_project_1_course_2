package utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorHelper {

    public static void showMessage(HttpServletRequest req, HttpServletResponse resp, String msg, String page) throws ServletException, IOException {
        req.getSession().setAttribute("msg", msg);
        resp.sendRedirect(req.getContextPath() + page);
        //req.getRequestDispatcher("/WEB-INF/jsp/" + page + ".jsp").forward(req, resp);
    }

}
