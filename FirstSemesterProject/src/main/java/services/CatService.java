package services;

import dao.CatDao;
import exceptions.DBException;
import models.Cat;
import models.User;
import validators.InputValid;

import javax.servlet.http.HttpServletRequest;

public class CatService {

    private final CatDao catDao;

    public CatService(CatDao catDao) {
        this.catDao = catDao;
    }

    public void initCats(HttpServletRequest req, Integer owner_id) throws DBException {
        req.getSession().setAttribute("cats", catDao.getCats(owner_id));
    }

    public void initAllCats(HttpServletRequest req) throws DBException {
        req.getSession().setAttribute("allcats", catDao.getAllCats());
    }

    public String validInputData(String name, String age, String breed, String character) {
        InputValid valid = new InputValid();
        return valid.validUsername(name) + valid.validAge(age) + valid.validInputText(breed) + valid.validInputText(character);
    }
}
