package ru.abdurahman.BankService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.abdurahman.BankService.models.User;
import ru.abdurahman.BankService.service.SearchService;

import java.time.LocalDate;

@RestController
@RequestMapping()
public class SearchControllerd {

    private final SearchService searchClients;
    @Autowired
    public SearchControllerd(SearchService searchClients) {
        this.searchClients = searchClients;
    }
    @GetMapping("/search")
    public ResponseEntity<Page<User>> searchUser(@RequestParam(required = false)LocalDate birthDate,
                                     @RequestParam(required = false) String phone,
                                     @RequestParam(required = false) String fullName,
                                     @RequestParam(required = false, name = "email") String email,
                                     @RequestParam(defaultValue = "0", required = false) int page,
                                     @RequestParam(defaultValue = "10", required = false) int size,
                                     @RequestParam(defaultValue = "id", required = false) String sortBy,
                                     @RequestParam(defaultValue = "ASC", required = false) Sort.Direction sortDirection){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));

        Page<User> clients = searchClients.searchClients(birthDate, phone, fullName, email, pageable);
        return ResponseEntity.ok(clients);


    }




}
