package ru.abdurahman.BankService.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.abdurahman.BankService.models.Account;
import ru.abdurahman.BankService.models.User;
import ru.abdurahman.BankService.repositories.AccountRepository;
import ru.abdurahman.BankService.repositories.UserRepository;

@Service
public class AccountService  {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void createAccount(String ownerUsername){
        User owner = userRepository.findByUsername(ownerUsername).get();
        Account newAccount = new Account();
        newAccount.setBalance(100.0000);
        newAccount.setUser(owner);

        accountRepository.save(newAccount);
    }
    @Transactional
    public boolean existMoneyOfBalance(Long senderAccount, Double operations){
        if (accountRepository.findById(senderAccount).isPresent() &&
                accountRepository.findById(senderAccount).get().getBalance() >= operations){
            return true;
        }
        else return false;
    }
    @Transactional
    public boolean existRecieverAccount(Long recieverAccount){
        if (accountRepository.findById(recieverAccount).isPresent()){
            return true;
        }
        else return false;
    }
    @Transactional
    public void operationsSenderToReciever(Long senderAccount, Long receiverAccount, Double operations){
        Account accountSender = accountRepository.findById(senderAccount).get();
        Account accounReciever = accountRepository.findById(receiverAccount).get();
        accountSender.setBalance(accountSender.getBalance() - operations);
        accounReciever.setBalance(accounReciever.getBalance() + operations);
    }




}
