package services;

import DTO.UserRegistrationDto;
import model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.UserRepository;

import exception.UserIdNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Transactional
    public UserInfo createUser(UserRegistrationDto registrationDto) {
        UserInfo newUser = new UserInfo();
        newUser.setUsername(registrationDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        newUser.setEmail(registrationDto.getEmail());
        newUser.setUserType(registrationDto.getUserType());
        return userRepository.save(newUser);
    }

    public List<UserInfo> findAllUsers() {
        return userRepository.findAll();
    }

    public UserInfo updateUser(UserInfo userInfo) {
        return userRepository.save(userInfo);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteUserById(userId);
    }

    public UserInfo findById(Long id) throws UserIdNotFoundException {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

    public UserInfo findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}


