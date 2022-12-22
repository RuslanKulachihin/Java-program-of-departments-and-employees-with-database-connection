package sourse;

import java.util.List;

public interface Repository<T> {

    T find(int id);
    void save(T source);
    void remove(T target);
    List<T> list();
}
