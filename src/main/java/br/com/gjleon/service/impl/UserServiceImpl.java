package br.com.gjleon.service.impl;

import br.com.gjleon.domain.model.User;
import br.com.gjleon.domain.repository.UserRepository;
import br.com.gjleon.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

   private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException :: new);
    }

    @Override
    public User create(User userToCreat) {
        if (userRepository.existsByAccountNumber(userToCreat.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists");
        }
        return userRepository.save(userToCreat);
    }
}
