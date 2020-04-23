package pl.javastart.demo.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//BEAN
@Controller
public class UserController {

    // Model -> Mapa { klucz = wartość }

    @GetMapping("/user")
    String getUser(Model model) {
        User exampleUser = new User("Jan", "Kowalski");

        // Map.put("user", exampleUser);
        model.addAttribute(
                "user",
                exampleUser);
        model.addAttribute(
                "header",
                "Tekst dla użytkownika Jana");

        model.addAttribute(
                "number",
                new Random().nextInt() - 400_000
        );
        return "userView";
    }

    @GetMapping("/users")
    String getUsers(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User("Jan", "Kowalski"));
        users.add(new User("X", "Y"));
        users.add(new User("123", "456"));

        model.addAttribute("users", users);

        return "usersView";
    }
}
