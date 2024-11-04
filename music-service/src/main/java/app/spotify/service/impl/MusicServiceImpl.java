package app.spotify.service.impl;

import app.spotify.dto.MusicDto;
import app.spotify.dto.SimpleDto;
import app.spotify.entity.Music;
import app.spotify.mappers.MusicDtoMapper;
import app.spotify.repository.MusicRepository;
import app.spotify.service.MusicService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
public class MusicServiceImpl implements MusicService {

    private MusicRepository repository;

    private final MusicDtoMapper mapper;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository, MusicDtoMapper mapper) {
        this.repository = musicRepository;
        this.mapper = mapper;
    }


    @Override
    public MusicDto findById(int id) {
        var optional = repository.findById(id);
        var entity = optional.orElse(null);
        return mapper.EntityToDto(entity);
    }

    @Override
    public List<MusicDto> findAll() {
        var list = repository.findAll();
        List<MusicDto> dto = new ArrayList<>();
        for(var value: list) {
            dto.add(mapper.EntityToDto(value));
        }
        return dto;
    }

    @Override
    public void save(Music music) {

    }

    @Override
    public void update(Music music) {

    }

    @Override
    public void delete(Music music) {

    }

    @Override
    public void deleteById(int id) {

    }
}