package ru.abdurahman.BankService.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.abdurahman.BankService.models.Account;
import ru.abdurahman.BankService.repositories.AccountRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private AccountService userAccountService;

    @Test
    void testOperationsSenderToReceiver() {
        // Arrange
        Long senderAccountId = 1L;
        Long receiverAccountId = 2L;
        Double amount = 200.0;

        Account senderAccount = new Account();
        senderAccount.setBalance(1000.0);
        when(accountRepository.findById(senderAccountId)).thenReturn(java.util.Optional.of(senderAccount));

        Account receiverAccount = new Account();
        receiverAccount.setBalance(500.0);
        when(accountRepository.findById(receiverAccountId)).thenReturn(java.util.Optional.of(receiverAccount));

        // Act
        userAccountService.operationsSenderToReciever(senderAccountId, receiverAccountId, amount);

        // Assert
        verify(accountRepository, times(1)).findById(senderAccountId);
        verify(accountRepository, times(1)).findById(receiverAccountId);

        assertEquals(800.0, senderAccount.getBalance());
        assertEquals(700.0, receiverAccount.getBalance());
    }
}
