package HW13.HW13.service;

import HW13.HW13.entity.User;

import java.util.List;

public interface UserService {
    List<HW13.HW13.entity.User> showAll();
    User create(User user);
}
