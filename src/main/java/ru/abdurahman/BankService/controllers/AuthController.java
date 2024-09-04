package ru.abdurahman.BankService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.abdurahman.BankService.dto.UserDto;
import ru.abdurahman.BankService.jwt.JwtRequest;
import ru.abdurahman.BankService.jwt.JwtResponse;
import ru.abdurahman.BankService.service.AccountService;
import ru.abdurahman.BankService.service.AuthService;
import ru.abdurahman.BankService.service.UserService;

@RestController
@RequestMapping
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    private final AccountService accountService;
    @Autowired
    public AuthController(AuthService authService, UserService userService, AccountService accountService) {
        this.authService = authService;
        this.userService = userService;
        this.accountService = accountService;
    }

    @PostMapping("/registr")
    public ResponseEntity addUser(@RequestBody UserDto userDto){
        userService.create(userDto);
        accountService.createAccount(userDto.getUsername());
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PostMapping("/auth")
    public JwtResponse createAuth(@RequestBody JwtRequest authRequest){
        String token = authService.createTokent(authRequest);
        return new JwtResponse(token);
    }





}
