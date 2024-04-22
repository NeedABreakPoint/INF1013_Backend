package repositories;

import model.CredentialInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends CrudRepository<CredentialInfo, String> {
    Optional<CredentialInfo> findByUsername(String username);
}
