package ru.abdurahman.BankService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.abdurahman.BankService.models.User;
import ru.abdurahman.BankService.models.Utils;

import java.util.Optional;

@Repository
public interface UtilsRepository extends JpaRepository<Utils, Long> {
    Optional<Utils> findByEmail(String email);
    Optional<Utils> findByPhone(String phone);

}
