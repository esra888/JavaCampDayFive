package DataAccess.Concretes;

import DataAccess.Abstracts.UserDao;
import Entities.Concretes.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserDao implements UserDao {
    private List<User> users;

    public InMemoryUserDao() {
        this.users = new ArrayList<User>();
    }

    @Override
    public void add(User user) {
        this.users.add(user);
        System.out.println("User added to system."); //TODo: Üyelik sonucu kullanıcıya e posta gönderilmelidir.
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {
        User tUser = get(user.getId());
        users.remove(tUser);
    }

    @Override
    public User get(int id) {
        for(User user : users )
            if(user.getId() == id){
                return user;
            }
            return null;
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }
}
