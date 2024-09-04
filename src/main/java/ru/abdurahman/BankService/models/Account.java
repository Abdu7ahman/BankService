package ru.abdurahman.BankService.models;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "initial_deposit")
    private Double initialDeposit;

    public Account() {
    }

    public Account(Long id, User user, Double balance, Double initialDeposit) {
        this.id = id;
        this.user = user;
        this.balance = balance;
        this.initialDeposit = initialDeposit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(Double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }
}
