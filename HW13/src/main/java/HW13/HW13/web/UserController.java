package HW13.HW13.web;

import HW13.HW13.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final HW13.HW13.service.UserService userService;

    public UserController(HW13.HW13.service.UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/showusers")
    List<User> showUsers() {
        return userService.showAll();
    }

    @PostMapping("/adduser")
    User addUser(@RequestBody User user) {
        return userService.create(user);
    }

}
