package services;

import DTO.UserRegistrationDto;
import model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UserInfo createUser(UserRegistrationDto registrationDto) {
        UserInfo newUser = new UserInfo();
        newUser.setUsername(registrationDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        newUser.setEmail(registrationDto.getEmail());
        newUser.setUserType(registrationDto.getUserType());

        return userRepository.save(newUser);
    }
}


