package Business.Concretes;

import Business.Abstracts.AuthenticationService;
import Business.Abstracts.UserService;
import Business.Abstracts.ValidityService;
import Core.LoggerService;
import DataAccess.Abstracts.UserDao;
import Entities.Concretes.User;

import java.util.NoSuchElementException;

public class UserManager implements UserService {
    private UserDao userDao;
    private AuthenticationService authenticationService;
    private LoggerService loggerService;

    public UserManager() {
    }

    public UserManager(UserDao userDao, AuthenticationService authenticationService, LoggerService loggerService) {
        this.userDao = userDao;
        this.authenticationService = authenticationService;
        this.loggerService = loggerService;
    }


    @Override
    public void register(User user) {
        ValidityService validityService = new ValidityManager(userDao);
        if(validityService.isValid(user.getEmail())
                && authenticationService.firstNameCheck(user.getFirstName())
                && authenticationService.lastNameCheck(user.getLastName())
                && authenticationService.emailCheck(user.getEmail())
                && authenticationService.passwordCheck(user.getPassword())) {
            userDao.add(user);
            this.loggerService.logToSystem("Registered");

            System.out.println("Please check the email address and click the verification mail.");
            System.out.println("Process completed"); //todo: after click process.
            System.out.println("------------------------------------------");
        }
    }

    @Override
    public void SignIn(String email, String password) {
        for (int i = 0; i < userDao.getAll().size(); i++) {
            if (userDao.getAll().get(i).getEmail().equals(email) &&
                    userDao.getAll().get(i).getPassword().equals(password)) {
                System.out.println("Successful login");
                return;
            }
        }
        System.out.println("Email or password is not right");
    }
}
