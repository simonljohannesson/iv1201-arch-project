//package se.kth.iv1201.group6.recruitmentApplication.auth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Repository;
//import se.kth.iv1201.group6.recruitmentApplication.security.ApplicationUserRole;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository("fake")
//public class FakeApplicationUserDaoService implements ApplicationUserDao {
//
//    @Autowired
//    private final PasswordEncoder passwordEncoder;
//
//    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public Optional<ApplicationUserDetails> selectApplicationUserByUsername(String username) {
//        return getApplicationUsers()
//                .stream()
//                .filter(u -> u.getUsername().equals(username))
//                .findFirst();
//    }
//
//    private List<ApplicationUserDetails> getApplicationUsers(){
//        ApplicationUserDetails[] users = {
//                new ApplicationUserDetails(
////                        1L,
//                        "applicant",
//                        passwordEncoder.encode("pass"),
////                        true,
////                        true,
////                        true,
//                        true,
//                        ApplicationUserRole.APPLICANT.getGrantedAuthorities()),
//
//                new ApplicationUserDetails(
////                        2L,
//                        "recruiter",
//                        passwordEncoder.encode("pass"),
////                        true,
////                        true,
////                        true,
//                        true,
//                        ApplicationUserRole.RECRUITER.getGrantedAuthorities()),
//        };
//        return new ArrayList<>(List.of(users));
//    }
//}
