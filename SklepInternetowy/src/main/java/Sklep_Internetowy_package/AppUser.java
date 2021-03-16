//package Sklep_Internetowy_package;
//
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.w3c.dom.UserDataHandler;
//
//import javax.persistence.*;
//import java.util.Collection;
//import java.util.Collections;
//
//@Entity
//    public class AppUser implements UserDetails {
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long id;
//
//        private String username;
//        private String password;
//        private String role;
//
//
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority(role));
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    public boolean isEnabled() {
//        return true;
//    }
//}
