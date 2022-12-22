package service;

import java.util.List;


public interface Service<T> {

    T getById(int id);

    List<T> getAll();

    void save(T source);
}
