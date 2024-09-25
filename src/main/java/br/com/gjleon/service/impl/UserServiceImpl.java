package br.com.gjleon.service.impl;

import br.com.gjleon.domain.model.User;
import br.com.gjleon.domain.repository.UserRepository;
import br.com.gjleon.service.UserService;
import br.com.gjleon.service.exception.BusinessException;
import br.com.gjleon.service.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

   private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException:: new);
    }

    @Transactional
    public User create(User userToCreat) {
        if (userRepository.existsByAccountNumber(userToCreat.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists");
        }
        return userRepository.save(userToCreat);
    }

    @Override
    public User updateById(Long aLong, User userToUpdate) {
        User dbUser = userRepository.findById(aLong).orElseThrow(NoSuchElementException :: new);
        if (!userToUpdate.getId().equals(aLong)) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbUser.setName(userToUpdate.getName());
        dbUser.setAccount(userToUpdate.getAccount());
        dbUser.setCard(userToUpdate.getCard());
        dbUser.setFeatures(userToUpdate.getFeatures());
        dbUser.setNews(userToUpdate.getNews());

        return this.userRepository.save(dbUser);
    }

    @Transactional
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException();
        }
        userRepository.deleteById(id);
    }

}
