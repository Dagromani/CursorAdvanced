package HW13.HW13.service;

import HW13.HW13.entity.User;
import HW13.HW13.entity.UserDetails;
import HW13.HW13.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JPAUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public JPAUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("404"));
        return user.map(UserDetails::new).get();
    }
}
