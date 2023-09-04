package com.dykj.webApi.security.model;

import com.dykj.webApi.pojo.system.JcUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author:ctj
 * @date:2023/8/29
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUser implements UserDetails {

    private JcUser jcUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.jcUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.jcUser.getUsername();
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
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
