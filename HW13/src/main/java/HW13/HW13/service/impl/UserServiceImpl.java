package HW13.HW13.service.impl;

import HW13.HW13.entity.User;
import HW13.HW13.repository.UserRepository;
import HW13.HW13.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<HW13.HW13.entity.User> showAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

}
