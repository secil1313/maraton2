package JDBCSorusu.service;

public interface ICrud <T>{
    void read();
    void save(T t);
    void update(T t);
    void delete(int id);
}
