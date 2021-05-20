package Business.Concretes;

import Business.Abstracts.AuthenticationService;
import DataAccess.Abstracts.UserDao;
import Entities.Concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthenticationManager implements AuthenticationService {

    @Override
    public boolean emailCheck(String email) {
        String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()) {
            return true;
        }else if(email.isEmpty()) {
            System.out.println("Email can not be empty.");
            return false;
        }else{
            System.out.println("Invalid email address.");
            return false;
        }
    }

    @Override
    public boolean firstNameCheck(String firstName) {
        if(firstName.length() < 2) {
            System.out.println("Firstname must contain at least two characters");
            return false;
        }
        return true;
    }

    @Override
    public boolean lastNameCheck(String lastName) {
        if(lastName.length() < 2) {
            System.out.println("Lastname must contain at least two characters");
            return false;
        }
        return true;
    }

    @Override
    public boolean passwordCheck(String password) {
        if(password.length() < 6) {
            System.out.println("Password must contain at least 6 characters.");
            return false;
        }
        return true;
    }
}
