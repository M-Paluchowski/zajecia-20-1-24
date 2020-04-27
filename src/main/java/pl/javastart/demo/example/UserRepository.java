package pl.javastart.demo.example;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Service
//@Component
@Repository
public class UserRepository {

    private List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
    }

    public void save(User user) {
        userList.add(user);
    }

    public List<User> findAll() {
        return new ArrayList<>(userList);
    }
}
