package model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "users")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public enum UserType {
        CUSTOMER, RESTAURANT_OWNER
    }
    private String username;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType userType;  // 'user' for normal users, 'owner' for restaurant owners

}
