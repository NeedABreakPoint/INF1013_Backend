package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "credential_info")
public class CredentialInfo {
    @Id
    private String Uuid = "";
    private String username  = "";
    private String password  = "";
    private String role  = "";
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated;
    private boolean activated = false;
    private boolean deleted = false;
    private long expiry = 0L;
}
