package app.spotify.service;

import app.spotify.dto.SimpleDto;

import java.util.List;

public interface CrudService<T extends SimpleDto> {
    SimpleDto findById(int id);

    List<T> findAll();

    void save(T t);

    void update(T t);

    void delete(T t);

    void deleteById(int id);
}
