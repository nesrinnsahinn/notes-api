package com.example.notes_api;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service // bu sınıfı "güvenlik görevlisi" olarak Spring'e kaydet
public class AppUserDetailsService implements UserDetailsService {

  private final AppUserRepository repo;

  // Veritabanına erişmek için repository'i istiyoruz (Spring otomatik verecek)
  public AppUserDetailsService(AppUserRepository repo) {
    this.repo = repo;
  }

  // Biri "ben şu kullanıcıyım" dediğinde Spring bu metodu çağırır
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // 1) Veritabanında USERS tablosunda bu kullanıcı var mı?
    AppUser u = repo.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

    // 2) Varsa: Spring'e "kullanıcı adı, şifresi, rolü bu" diye haber ver
    return User.withUsername(u.getUsername())
        .password(u.getPassword()) 
        .authorities(List.of(new SimpleGrantedAuthority("ROLE_" + u.getRole()))) // 
        .build();
  }
}
