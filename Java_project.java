import java.util.Scanner;
import java.util.Random;

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}

class Playlist {
    private Song[] songs;
    private int count;

    public Playlist(int size) {
        songs = new Song[size];
        count = 0;
    }

    public void addSong(Song s) {
        if (count < songs.length) {
            songs[count] = s;
            count++;
        } else {
            System.out.println("Playlist is full");
        }
    }

    public void display() {
        if (count == 0) {
            System.out.println("Playlist is empty");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + songs[i].getTitle() + " - " + songs[i].getArtist());
        }
    }

    public void shufflePlaylist() {
        Random r = new Random();
        for (int i = count - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Song temp = songs[i];
            songs[i] = songs[j];
            songs[j] = temp;
        }
    }
}

public class Java_project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter playlist size: ");
        int size = sc.nextInt();
        sc.nextLine();

        Playlist playlist = new Playlist(size);

        for (int i = 0; i < size; i++) {
            System.out.print("Enter song title: ");
            String title = sc.nextLine();
            System.out.print("Enter artist name: ");
            String artist = sc.nextLine();
            playlist.addSong(new Song(title, artist));
        }

        System.out.println("\nPlaylist:");
        playlist.display();

        System.out.println("\nShuffling Playlist...");
        playlist.shufflePlaylist();

        System.out.println("\nShuffled Playlist:");
        playlist.display();
    }
}