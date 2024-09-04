package ru.abdurahman.BankService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PhoneDto {
    private String username;
    private String phone;
}
