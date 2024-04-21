package model;

import jakarta.persistence.*;

//import javax.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
