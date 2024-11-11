package app.spotify.service.impl;

import app.spotify.storage.service.MusicFileSystemStorageService;
import app.spotify.storage.service.TextsFileSystemStorageService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Getter
@Setter
public class MusicUploadToFileService {

    private final MusicFileSystemStorageService musicStorageService;
    private final TextsFileSystemStorageService textStorageService;

    @Autowired
    public MusicUploadToFileService(MusicFileSystemStorageService storageService, TextsFileSystemStorageService textStorageService) {
        this.musicStorageService = storageService;
        this.textStorageService = textStorageService;
    }

    public void uploadMusic(MultipartFile song, MultipartFile text) {
        if(song == null || text == null) {
            throw new IllegalArgumentException("Song and text must not be null");
        }
        musicStorageService.store(song);
        musicStorageService.store(text);
    }

    public void deleteMusic(String filename) {
        if(filename.trim().isEmpty()) {
            throw new IllegalArgumentException("Filename must not be empty");
        }
        musicStorageService.delete(filename);
        textStorageService.delete(filename);
    }
}
