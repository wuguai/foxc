package com.foxc.user.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class CustomUserDetailService implements UserDetailsService {

    /**
     * 模拟两个账户
     * 1. 账号是user，密码是password1，角色是user-role
     * 2. 账号是admin,密码是password2，角色是admin-role
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if("user".equals(s)){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("user-role");
            return new User("user", passwordEncoder.encode("password1"),true,true,true,true, Arrays.asList(grantedAuthority));
        }else if ("admin".equals(s)){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("admin-role");
            return new User("admin", passwordEncoder.encode("password2"),true,true,true,true,Arrays.asList(grantedAuthority));
        }
        return null;
    }
}
