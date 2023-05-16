package ro.itschool.auction2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.itschool.auction2.entities.UserEntity;
import ro.itschool.auction2.repositories.UserRepository;
import ro.itschool.auction2.requests.SignUpRequest;

@Service
public class SingUpService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void signup(SignUpRequest signupRequest) {
        UserEntity user = new UserEntity();
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        userRepository.save(user);
    }
}
