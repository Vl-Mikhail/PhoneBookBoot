package ru.misha.service;

import java.util.List;

public interface Services<T> {

    List<T> findAll();

    void saveOrUpdate(T t);

    void delete(Long id);
}
