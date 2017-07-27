package com.rainsgo.server.user.security;

import com.rainsgo.server.user.model.Role;
import com.rainsgo.server.user.model.User;
import com.rainsgo.server.user.service.RoleService;
import com.rainsgo.server.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByName(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
    /**
     * 获取用户的角色：role中的roleKey字段封装到Set<GrantedAuthority>中
     * @param user
     * @return
     */
    private Set<GrantedAuthority> getGrantedAuth(User user){
        Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
        try {
            List<Role> roleList = roleService.findByUserId(user.getId());
            for(Role r : roleList){
                authSet.add(new SimpleGrantedAuthority(r.getId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return authSet;
    }
}
