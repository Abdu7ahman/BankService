package ru.abdurahman.BankService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.abdurahman.BankService.dto.EmailDto;
import ru.abdurahman.BankService.dto.PhoneDto;
import ru.abdurahman.BankService.service.UtilsService;

@RestController
@RequestMapping
public class EmailAndPhoneController {

    private final UtilsService utilsService;
    @Autowired
    public EmailAndPhoneController(UtilsService utilsService) {
        this.utilsService = utilsService;
    }

    @PostMapping("/settings/addEmail")
    public HttpStatus addEmail(@RequestBody EmailDto emailDto){
        if (utilsService.existEmail(emailDto.getEmail())){
            return HttpStatus.BAD_REQUEST;
        }
        else utilsService.addEmail(emailDto.getEmail(), emailDto.getUsername()); return HttpStatus.OK;
    }

    @PostMapping("/settings/addPhone")
    public HttpStatus addPhone(@RequestBody PhoneDto phoneDto){
        if (utilsService.existPhone(phoneDto.getPhone())){
            return HttpStatus.BAD_REQUEST;
        }
        else utilsService.addPhone(phoneDto.getPhone() , phoneDto.getUsername()); return HttpStatus.OK;
    }


}
