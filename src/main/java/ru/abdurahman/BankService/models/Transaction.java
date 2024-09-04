package ru.abdurahman.BankService.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "senderAccountId")
    private User senderAccount;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "receiverAccountId")
    private User receiverAccount;
    @Column(name = "amount")
    private Double amount;
    @Column(name ="timestamp" )
    private LocalDateTime timestamps;

    public Transaction() {
    }

    public Transaction(Long id, User senderAccount, User receiverAccount, Double amount, LocalDateTime timestamps) {
        this.id = id;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
        this.timestamps = timestamps;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(User senderAccount) {
        this.senderAccount = senderAccount;
    }

    public User getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(User receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(LocalDateTime timestamps) {
        this.timestamps = timestamps;
    }
}

