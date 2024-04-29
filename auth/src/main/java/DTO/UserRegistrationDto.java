package DTO;


import model.UserInfo;

public class UserRegistrationDto {

    private String username;
    private String password;

    private String email;

    private UserInfo.UserType userType;

    // Default constructor
    public UserRegistrationDto(String username, String password, String email, UserInfo.UserType userType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    // Getters and Setters
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

    public UserInfo.UserType getUserType() {
        return userType;
    }

    public void setUserType(UserInfo.UserType userType) {
        this.userType = userType;
    }
}


