package app.spotify.service.impl;

import app.spotify.storage.MusicFileSystemStorageService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Getter
@Setter
public class MusicUploadToFileService {

    private MusicFileSystemStorageService storageService;

    @Autowired
    public MusicUploadToFileService(MusicFileSystemStorageService storageService) {
        this.storageService = storageService;
    }

    public void uploadMusic(MultipartFile song, MultipartFile text) {
        storageService.store(song);
        storageService.store(text);

    }
}
