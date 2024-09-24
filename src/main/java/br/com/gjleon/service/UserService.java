package br.com.gjleon.service;

import br.com.gjleon.domain.model.User;

public interface UserService {
    User findById(Long id);
    User create(User userToCreat);
}
