package app.spotify.mappers;

import app.spotify.dto.MusicDto;
import app.spotify.entity.Music;
import org.mapstruct.Mapper;

@Mapper
public interface MusicDtoMapper {
    MusicDto EntityToDto(Music music);

    Music DtoToEntity(MusicDto musicDto);
}
