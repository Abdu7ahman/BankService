package ru.abdurahman.BankService.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
}

