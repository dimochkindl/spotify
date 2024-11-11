package app.spotify.mappers;

import app.spotify.dto.MusicDto;
import app.spotify.entity.Music;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface MusicDtoMapper {
    MusicDto entityToDto(Music music);

    Music dtoToEntity(MusicDto musicDto);
}
