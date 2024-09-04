package ru.abdurahman.BankService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmailDto {
    private String username;
    private String email;

}
