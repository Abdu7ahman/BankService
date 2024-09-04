package ru.abdurahman.BankService.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "utils")
public class Utils {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")

    private User user;

    private String email;
    private String phone;
}
