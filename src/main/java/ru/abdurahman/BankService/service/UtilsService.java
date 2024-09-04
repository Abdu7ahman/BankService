package ru.abdurahman.BankService.service;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.abdurahman.BankService.models.User;
import ru.abdurahman.BankService.models.Utils;
import ru.abdurahman.BankService.repositories.UserRepository;
import ru.abdurahman.BankService.repositories.UtilsRepository;
@Service
public class UtilsService  {
    private final UtilsRepository utilsRepository;
    private final UserRepository userRepository;

    @Autowired
    public UtilsService(UtilsRepository utilsRepository, UserRepository userRepository) {
        this.utilsRepository = utilsRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void addEmail(String newEmail, String username){

            Utils  utils = new Utils();
            utils.setEmail(newEmail);
            utilsRepository.save(utils);
            utils.setUser(userRepository.findByUsername(username).get());

    }
    @Transactional
    public void addPhone(String phone, String username){
        Utils utils = new Utils();
        utilsRepository.save(utils);
        utils.setUser(userRepository.findByUsername(username).get());
    }
    @Transactional
    public boolean existEmail(String newEmail){
        if (utilsRepository.findByEmail(newEmail).isEmpty() && userRepository.findUserByEmail(newEmail).isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }

    @Transactional
    public boolean existPhone(String phone){
        if (utilsRepository.findByPhone(phone).isEmpty() && userRepository.findUserByPhone(phone).isEmpty()){
            return false;
        }
        else return true;
    }

    @Transactional
    public void deleteEmail(String username, String email) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));

        Utils utils = user.getUtils().stream()
                .filter(u -> email.equals(u.getEmail()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Email not found: " + email));

        utilsRepository.delete(utils);
    }

    @Transactional
    public void deletePhone(String username, String phone){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));

        Utils utils = user.getUtils().stream()
                .filter(u -> phone.equals( u.getPhone()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Phone not found: " + phone));
        utilsRepository.delete(utils);
    }


}
