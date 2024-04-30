package repositories;
import model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import exception.UserIdNotFoundException;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByUsername(String username);
    UserInfo findByEmail(String email);

    void deleteUserById(Long userId);

    Optional<UserInfo> findUserById(Long id) throws UserIdNotFoundException;
}
