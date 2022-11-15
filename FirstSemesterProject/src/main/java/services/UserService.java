package services;

import dao.UserDao;
import exceptions.DBException;
import models.User;
import validators.InputValid;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void authenticUser(User user, HttpServletRequest req) {
        req.getSession().setAttribute("user", user);
    }

    public boolean authorizUser(User user) throws DBException {
        return user == null;
    }

    public boolean isAuthenticUser(HttpServletRequest req) {
        return req.getSession().getAttribute("user") != null;
    }

    public String validInputData(String username, String email, String password) {
        InputValid valid = new InputValid();
        return valid.validUsername(username) + valid.validEmail(email) + valid.validPassword(password);
    }

    public void initUsers(HttpServletRequest req) throws DBException {
        req.getSession().setAttribute("users", userDao.getUsers());
    }

    public void logout(HttpServletRequest req) {
        req.getSession().invalidate();
    }

    public User getUser(HttpServletRequest req) {
        return (User) req.getSession().getAttribute("user");
    }

    public void editProfile(HttpServletRequest req, String username, String email, String password) {
        User user = new User(getUser(req).getId(), username, email, password, getUser(req).getRole());
        authenticUser(user, req);
    }
}
