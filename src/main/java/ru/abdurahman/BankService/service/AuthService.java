package ru.abdurahman.BankService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.abdurahman.BankService.jwt.JwtRequest;
import ru.abdurahman.BankService.jwt.JwtTokenUtils;


@Service
public class AuthService {
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;
    @Autowired
    public AuthService(UserService userService, JwtTokenUtils jwtTokenUtils) {
        this.userService = userService;
        this.jwtTokenUtils = jwtTokenUtils;
    }

    public String createTokent(JwtRequest authrequest){
       String token = jwtTokenUtils.generateToken( userService.loadUserByUsername(authrequest.getUsername()));
       return token;
    }




}
