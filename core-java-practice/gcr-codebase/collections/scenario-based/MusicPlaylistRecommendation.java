import java.util.LinkedList;

public class MusicPlaylistRecommendation {
    private LinkedList<String> playlist = new LinkedList<>();
    
    public void playSong(String song) {
        playlist.remove(song);
        playlist.addFirst(song);
        if (playlist.size() > 10) {
            playlist.removeLast();
        }
    }
    
    public boolean searchSong(String song) {
        return playlist.contains(song);
    }
    
    public void displayHistory() {
        System.out.println("Recently Played History:");
        for (String song : playlist) {
            System.out.println(song);
        }
    }
}
