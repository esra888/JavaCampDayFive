package Business.Concretes;

import Business.Abstracts.ValidityService;
import DataAccess.Abstracts.UserDao;
import Entities.Concretes.User;

import java.util.List;

public class ValidityManager implements ValidityService {
    UserDao userDao;

    public ValidityManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean isValid(String email) {
        for(User user : userDao.getAll()) {
            if(email.equals(user.getEmail())) {
                System.out.println("This email address is already registered.");
                return false;
            }
        }
        return true;
    }
}
