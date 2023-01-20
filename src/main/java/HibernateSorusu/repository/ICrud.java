package HibernateSorusu.repository;

import HibernateSorusu.entity.Siparis;

import java.util.List;

public interface ICrud<T> {
    void save(T t);
    void update(T t);
    void deleteById(int id);

    List<Siparis> getAll();

}
