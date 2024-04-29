package DTO;

import lombok.Data;
import model.CredentialInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import model.UserInfo;

import java.util.Collection;
import java.util.Collections;

@Data
public class UserDetailsDto implements UserDetails {
    private  CredentialInfo credentials;
    private  UserInfo userInfo;
    private  String jwtToken;
    public UserDetailsDto(UserInfo userInfo, CredentialInfo credentialInfo){
        this.userInfo = userInfo;
        this.credentials = credentialInfo;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList((GrantedAuthority) credentials::getRole);
    }

    @Override
    public String getPassword() {
        return credentials.getPassword();
    }

    @Override
    public String getUsername() {
        return credentials.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true ;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
