package ru.abdurahman.BankService.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.abdurahman.BankService.models.User;

import ru.abdurahman.BankService.repositories.UserRepository;


import java.time.LocalDate;

@Service
public class SearchService {

    private final UserRepository clientRepository;


    @Autowired
    public SearchService(UserRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Transactional
    public Page<User> searchClients(
            LocalDate birthDate,
            String phone,
            String lastName,
            String email,
            Pageable pageable
    ) {
        Specification<User> specification = Specification.where(null);

        if (birthDate != null) {
            specification = specification.and((root, query, cb) -> cb.greaterThan(root.get("birthDate"), birthDate));
        }
        if (phone != null) {
            specification = specification.and((root, query, cb) -> cb.equal(root.get("phone"), phone));
        }
        if (lastName != null) {
            specification = specification.and((root, query, cb) -> cb.like(root.get("lastName"), lastName + "%"));
        }
        if (email != null) {
            specification = specification.and((root, query, cb) -> cb.equal(root.get("email"), email));
        }

        return clientRepository.findAll(specification,  pageable);
    }
}
