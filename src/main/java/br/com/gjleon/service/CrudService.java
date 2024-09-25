package br.com.gjleon.service;

import java.util.List;

public interface CrudService<ID, T> {
    List<T> findAll();
    T findById(ID id);
    T create(T entity);
    T updateById(ID id, T entity);
    void deleteById(ID id);
}
