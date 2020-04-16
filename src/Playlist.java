//Author:Thomas Greaney
//Student ID:19258909

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Iterator;

public class Playlist {

    private String name;
    private LinkedList<Track> songs = new LinkedList<Track>();

    Playlist(String name){
        this.name = name;
    }

    Playlist(){
        this.name = "Playlist";
    }

    public String toString(){
        return "\n" + this.name + Arrays.toString(songs.toArray());
    }

    public void add(String title, String artist){
        Track song = new Track(title, artist);
        songs.add(song);
    }

    public void add(String title, String artist, int year, int duration){
        Track song = new Track(title, artist, year, duration);
        songs.add(song);
    }

    public void add(Track t){
        songs.add(t);
    }

    public void showList(){
        if(songs.size() == 0){
            System.out.println("\nThe list is empty.");
        }else{
            play(false);
        }
    }

    public void play(boolean random){
        if(random){
            Object[] shuffledSongs = songs.toArray();
            for(int i = songs.size()-1; i>0;i--){//Durstenfeld implementation of Fisher-Yates shuffle.
                int j = (int)(Math.random()*(i+1));
                Object temp = shuffledSongs[i];
                shuffledSongs[i] =  shuffledSongs[j];
                shuffledSongs[j] = temp;
            }
            for (Object song : shuffledSongs) {
                System.out.print(song);
            }
        }else{
            for (Track song : songs) {
                System.out.print(song);
            }
        }
    }

    public void playOnly(String artist){
        for (Track song : songs) {
            if (song.getArtist().toLowerCase().contains(artist.toLowerCase())) {
                System.out.print(song);
            }
        }
    }

    public void playOnly(int year){
        for (Track song : songs) {
            if(song.getYear() == year) {
                System.out.print(song);
            }
        }
    }

    public boolean remove(String title){
        Iterator itr = this.songs.iterator();
        while(itr.hasNext()) {
            Track song = (Track)itr.next();
            if (song.getTitle().equalsIgnoreCase(title)) {
                itr.remove();
                return true;
            }
        }
        return false;
    }

    public void setPlaylistName(String name){
        this.name = name;
    }

    public String getPlaylistName(){
        return this.name;
    }
}