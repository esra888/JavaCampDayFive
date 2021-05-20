package DataAccess.Abstracts;

import Entities.Concretes.User;

import java.util.List;

public interface UserDao {
    public void add(User user);
    public void update(User user);
    public void delete(User user);
    public User get(int id);
    List<User> getAll();
}
