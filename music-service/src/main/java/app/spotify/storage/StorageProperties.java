package app.spotify.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

    private String musicLocation = "/music";

    private String textLocation = "/texts";

    public String getMusicLocation() {
        return musicLocation;
    }

    public String getTextLocation() {
        return textLocation;
    }

    public void setMusicLocation(String musicLocation) {
        this.musicLocation = musicLocation;
    }

    public void setTextLocation(String textLocation) {
        this.textLocation = textLocation;
    }
}
