package ru.abdurahman.BankService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.abdurahman.BankService.dto.TransferDto;
import ru.abdurahman.BankService.service.AccountService;

@RestController
@RequestMapping
public class OperationsController {
    private final AccountService accountService;
    @Autowired
    public OperationsController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/transfer")
    public HttpStatus transfer(@RequestBody TransferDto transferDto){
        if (accountService.existMoneyOfBalance(transferDto.getSenderAccount(), transferDto.getTransferMoney())){
            if (accountService.existRecieverAccount(transferDto.getReceiverAccount())){
                accountService.operationsSenderToReciever(transferDto.getSenderAccount(),
                        transferDto.getReceiverAccount(), transferDto.getTransferMoney());
                return HttpStatus.OK;
            }
            else return HttpStatus.BAD_REQUEST;
        }
        else {
            return HttpStatus.BAD_REQUEST;
        }

    }

}
