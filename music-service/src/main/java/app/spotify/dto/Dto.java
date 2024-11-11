package app.spotify.dto;

import java.util.List;

public class Dto {

    private List<String> artists;

    public Dto(List<String> artists) {
        this.artists = artists;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }
}
