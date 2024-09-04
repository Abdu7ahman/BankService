package ru.abdurahman.BankService.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@RequiredArgsConstructor

public class UserDto {
    @NotNull
    @Length(min = 2, max = 12)
    private String username;
    @NotNull
    @Length(min = 1, max = 12)
    private String firstName;
    @NotNull
    @Length(min = 1, max = 12)
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private String phone;

}
