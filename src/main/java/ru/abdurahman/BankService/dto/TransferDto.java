package ru.abdurahman.BankService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TransferDto {
    private Long senderAccount;
    private Long receiverAccount;
    private Double transferMoney;

}
