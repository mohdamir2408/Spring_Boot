package com.java.Security_example;

import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class UserAuthentication implements AuthenticationProvider {

        Logger logger = (Logger) LoggerFactory.getLogger(UserAuthentication.class);

        private UserRepo userRepo;

        private PasswordEncoder encoder;

        public UserAuthentication(UserRepo userRepo, PasswordEncoder encoder) {
            this.encoder = encoder;
            this.userRepo = userRepo;
        }

        /**
         * Get the username and password from authentication object and validate with password encoders matching method
         * @param authentication
         * @return
         * @throws AuthenticationException
         */
        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {

            String username = authentication.getName();
            String password = authentication.getCredentials().toString();

            User user = userRepo.findByUsername(username);
            if (user == null) {
                throw new BadCredentialsException("Details not found");
            }

            if (encoder.matches(password, user.getPassword())) {
                logger.info("Successfully Authenticated the user");
                return new UsernamePasswordAuthenticationToken
                        (username, password, getUserRole((User) user.getUserRole()));
            } else {
                throw new BadCredentialsException("Password mismatch");
            }
        }

        private List<GrantedAuthority> getUserRole(User getUserRole) {
            List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
            String[] roles = getUserRole.split(",");
            for (String role : roles) {
                logger.info("Role: " + role);
                grantedAuthorityList.add(new SimpleGrantedAuthority(role.replaceAll
                        ("\\s+", "")));
            }
    }


    /**
         * An user can have more than one role separated by ",". We are splitting each role separately
         * @param UserRole
         * @return
         */
        private List<GrantedAuthority> getUserRoles(String studentRoles) {
            List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
            String[] roles = studentRoles.split(",");
            for (String role : roles) {
                logger.info("Role: " + role);
                grantedAuthorityList.add(new SimpleGrantedAuthority(role.replaceAll
                        ("\\s+", "")));
            }

            return grantedAuthorityList;
        }

       @Override
        public boolean supports(Class<?> authentication) {
            return authentication.equals(UsernamePasswordAuthenticationToken.class);
        }
    }


