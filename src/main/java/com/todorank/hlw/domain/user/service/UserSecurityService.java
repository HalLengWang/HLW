package com.todorank.hlw.domain.user.service;

import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.entity.UserContext;
import com.todorank.hlw.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;
    private String thumbnailImg;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SiteUser> _user= this.userRepository.findByusername(username);
        if (_user.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        SiteUser user = _user.get();
        List<GrantedAuthority> authorities =  new ArrayList<>();

        return new UserContext(user, authorities);
    }

    public String getThumbnailImg(){
        return thumbnailImg != null ? thumbnailImg : "/profile_basic.png";
    }
}
