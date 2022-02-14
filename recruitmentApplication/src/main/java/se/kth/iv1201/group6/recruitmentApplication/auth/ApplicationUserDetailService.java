package se.kth.iv1201.group6.recruitmentApplication.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * This class is used by Spring-Security to fetch users during authentication and authorization.
 */
@Service
public class ApplicationUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        if(user.isEmpty()) throw new UsernameNotFoundException("Could not find user " + username);
        return new ApplicationUserDetails(user.get());
    }

    /**
     * Updates a users password
     * @param user user to be updated
     * @param newPassword the new password
     * @return The user in the database
     * @throws NoSuchElementException
     * @throws IllegalArgumentException
     */
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        if(!(user instanceof ApplicationUserDetails)) throw new IllegalArgumentException("Could not resolve type.");
        ApplicationUserDetails applicationUserDetails = (ApplicationUserDetails)user;

        var updateUser = userRepository.findById(applicationUserDetails.getId()).orElseThrow();

        updateUser.setPassword(newPassword);
        userRepository.save(updateUser);

        return new ApplicationUserDetails(updateUser);
    }

}
