//package Sklep_Internetowy_package;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//
//    private AppUserRepo appUserRepo;
//
//    public UserDetailsServiceImpl(AppUserRepo appUserRepo) {
//        this.appUserRepo = appUserRepo;
//    }
//
//    @Override
//        public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//            return appUserRepo.findByUsername(s);
//        }
//
//
//}
