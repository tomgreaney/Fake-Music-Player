//Author:Thomas Greaney
//Student ID:19258909

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

public class Playlist {

    private String name;
    private LinkedList<Track> songs = new LinkedList<Track>();
    private static Set<String> playlistNames = new HashSet<String>();

    Playlist(String name){
        setPlaylistName(name);
    }

    Playlist(){
        setPlaylistName("My Playlist");
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

    public void setPlaylistName(String newName){
        newName = newName.trim();//remove spaces from beginning and end of newName.
        if(!newName.equals(this.name)) {
            if(!playlistNames.add(newName)) {
                newName = (incrementNumber(newName).equals(newName))? newName + "#2":incrementNumber(newName);
                while (!playlistNames.add(newName)) {//if newName is "Playlist#2" and "Playlist#2" exists in playlistName newName becomes "Playlist#3"
                    newName = incrementNumber(newName);
                }
            }
            playlistNames.remove(this.name);
            this.name = newName;
        }
    }

    private String incrementNumber(String playlistName){
        //if "Mixtape #3" is inputted, "Mixtape #4" is outputted.
        int lastHashOccurrence = playlistName.lastIndexOf('#');
        if(lastHashOccurrence == -1){
            return playlistName;
        }else{
            try{
                return playlistName.substring(0,lastHashOccurrence+1) + (Integer.parseInt(playlistName.substring(lastHashOccurrence+1)) + 1);
            }catch(NumberFormatException ex){
                return playlistName;
            }
        }
    }

    public String getPlaylistName(){
        return this.name;
    }
}