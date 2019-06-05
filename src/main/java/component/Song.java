package component;

public class Song implements IComponent {
    private String songName;
    private String artist;
    private float speed = 1; // Default playback speed

    Song(String songName, String artist) {
        this.songName = songName;
        this.artist = artist;
    }

    @Override
    public void setPlaybackSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public void play() {
        System.out.println(this.songName + " is playing...");
    }

    @Override
    public String getName() {
        return songName;
    }

    String getArtist() {
        return artist;
    }
}