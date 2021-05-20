import Business.Abstracts.UserService;
import Business.Concretes.AuthenticationManager;
import Business.Concretes.UserManager;
import Core.RegisterLoggerAdapter;
import DataAccess.Concretes.InMemoryUserDao;
import Entities.Concretes.User;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserManager(new InMemoryUserDao(),new AuthenticationManager(),new RegisterLoggerAdapter());

        User user1 = new User(1,"es","mer","es888@gmail.com","1234567");
        userService.register(user1);

        User user2 = new User(2,"af","mer","123445@edu.tr","12345678");
        userService.register(user2);

        User user3 = new User(3,"se","ker","com","123456");//user with invalid email.
        userService.register(user3);

        userService.SignIn("ay","1233");
        userService.SignIn("memisesra888@gmail.com","1234567");

    }
}
