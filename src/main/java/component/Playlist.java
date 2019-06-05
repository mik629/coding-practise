package component;

import java.util.ArrayList;

public class Playlist implements IComponent {

    private String playlistName;
    private ArrayList<IComponent> playlist = new ArrayList<>();
    private int counter = 0;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
    }

    // Your code goes here!
    public void add(IComponent component) {
        playlist.add(component);
    }

    public void remove(IComponent component) {
        playlist.remove(component);
    }

    @Override
    public void setPlaybackSpeed(float speed) {
        for (IComponent component : playlist) {
            component.setPlaybackSpeed(speed);
        }
    }

    @Override
    public void play() {
        playlist.get(counter > playlist.size() - 1 ? 0 : counter).play();
        counter++;
    }

    @Override
    public String getName() {
        return playlistName;
    }
}
