package app.spotify.service;

import app.spotify.dto.SimpleDto;

import java.util.List;

public interface CrudService<T> {
    SimpleDto findById(int id);

    List<? extends SimpleDto> findAll();

    void save(T t);

    void update(T t);

    void delete(T t);

    void deleteById(int id);
}
