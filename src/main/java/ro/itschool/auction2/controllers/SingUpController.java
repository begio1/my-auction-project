
package ro.itschool.auction2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.itschool.auction2.entities.UserEntity;
import ro.itschool.auction2.repositories.UserRepository;
import ro.itschool.auction2.requests.SignUpRequest;
@RestController
@RequestMapping("/singUp")
public class SingUpController {
    private final UserRepository userRepository;

    public SingUpController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> signUpUser(@RequestBody SignUpRequest signUpRequest) {
        // check if user with the given email already exists
        if (userRepository.findByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        }

        // create a new UserEntity
        UserEntity user = new UserEntity();
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());


        // Save the user to the database
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}
