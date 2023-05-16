//package ro.itschool.auction2.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import ro.itschool.auction2.entities.UserEntity;
//import ro.itschool.auction2.repositories.UserRepository;
//import ro.itschool.auction2.requests.LoginRequest;
////import ro.itschool.auction2.requests.SingUpRequest;
//import ro.itschool.auction2.responses.JwtResponse;
//import ro.itschool.auction2.security.jwt.JwtUtils;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthenticationController {
//
//    @Autowired
//    private JwtUtils jwtUtils;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping("/signIn")
//    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
//                        loginRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String jwt = jwtUtils.generateToken(authentication);
//
//        User user = (User) authentication.getPrincipal();
//
//        JwtResponse jwtResponse = new JwtResponse(user.getUsername(), jwt);
//
//        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
//    }
//}
//
//    @PostMapping("/signUp")
//    public ResponseEntity<?> signUpUser(@RequestBody SingUpRequest signUpRequest) {
//        // check if user with the given email already exists
//        if (userRepository.findByEmail(signUpRequest.getEmail())) {
//            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
//        }
//
//        // create a new UserEntity
//        UserEntity user = new UserEntity();
//        user.setEmail(signUpRequest.getEmail());
//        user.setPassword(signUpRequest.getPassword());
//
//
//        // Save the user to the database
//        userRepository.save(user);
//
//        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
//    }
//}


