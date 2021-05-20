package Business.Abstracts;

import Entities.Concretes.User;

public interface UserService {
    void register(User user);
    void SignIn(String email, String password);
}
