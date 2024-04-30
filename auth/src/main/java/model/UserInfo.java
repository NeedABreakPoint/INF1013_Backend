package model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

//import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "users")
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    public enum UserType {
        CUSTOMER, RESTAURANT_OWNER
    }
    private String username;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType userType;  // 'user' for normal users, 'owner' for restaurant owners

    @Override
    public String toString(){
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                '}';
    }
}
