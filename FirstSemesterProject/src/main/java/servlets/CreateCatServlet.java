package servlets;

import dao.CatDao;
import exceptions.DBException;
import services.CatService;
import services.FilesService;
import services.UserService;
import utils.ErrorHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@MultipartConfig
@WebServlet("/welcome/profile/cat-passport-create")
public class CreateCatServlet extends HttpServlet {

    private UserService userService;
    private FilesService filesService;
    private CatService catService;
    private CatDao catDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService) getServletContext().getAttribute("userService");
        filesService = (FilesService) getServletContext().getAttribute("filesService");
        catService = (CatService) getServletContext().getAttribute("catService");
        catDao = (CatDao) getServletContext().getAttribute("catDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        userService.authenticUser(userService.getUser(req), req);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/cat-passport.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String breed = req.getParameter("breed");
        String character = req.getParameter("character");
        Part part = req.getPart("file-img");
        if (req.getParameter("btn-save-pass") != null) {
            String validData = catService.validInputData(name, age, breed, character);
            if (validData.equals("")) {
                try {
                    String fileName = "";
                    if (!part.getSubmittedFileName().equals("")) {
                        String realFileName = part.getSubmittedFileName();
                        if (filesService.validFile(realFileName)) {
                            UUID uuidPhoto = UUID.randomUUID();
                            fileName = uuidPhoto + part.getSubmittedFileName();
                            filesService.upload(fileName, part.getInputStream());
                        } else {
                            ErrorHelper.showMessage(req, resp, "only jpg/jpeg/png files can be uploaded", "/error");
                        }
                    } else {
                        fileName = "default_photo.png";
                    }
                    catDao.insertCat(name, userService.getUser(req).getId(), Integer.valueOf(age), breed, character, fileName);
                    resp.sendRedirect(req.getContextPath() + "/welcome/profile");
                } catch (DBException e) {
                    throw new ServletException(e);
                }
            } else {
                ErrorHelper.showMessage(req, resp, "Fill in all the fields and check the correctness of the entered data ( " + validData + ").", "/error");
            }
        }
    }
}

