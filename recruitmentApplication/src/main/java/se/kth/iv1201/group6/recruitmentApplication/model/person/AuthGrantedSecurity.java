//package se.kth.iv1201.group6.recruitmentApplication.model.person;
//
//import org.springframework.security.core.GrantedAuthority;
//
//import javax.persistence.*;
//
//public class AuthGrantedSecurity implements GrantedAuthority {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//    private String authority;
//
//    @ManyToOne
//    @JoinColumn(name = "auth_user_detail_id")
//    private AuthUserDetails authUserDetails;
//
//    @Override
//    public String getAuthority() {
//        return null;
//    }
//}
