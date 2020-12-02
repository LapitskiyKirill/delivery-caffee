package com.gmail.kirilllapitsky.deliverycaffee.config;

import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.exception.NoSuchEntityException;
import com.gmail.kirilllapitsky.deliverycaffee.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

import static com.gmail.kirilllapitsky.deliverycaffee.security.SecurityConstants.SECRET;

@ControllerAdvice
public class AuthenticationControllerAdvice {

    private final UserRepository userRepository;

    public AuthenticationControllerAdvice(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ModelAttribute("user")
    public User authenticate(HttpServletRequest request) throws NoSuchEntityException {
        String login = Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .parseClaimsJws(request.getHeader("Authorization"))
                .getBody()
                .getSubject();

        return userRepository.findByLogin(login)
                .orElseThrow(() -> new NoSuchEntityException("no such user."));
    }

}