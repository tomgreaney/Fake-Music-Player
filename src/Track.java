//Author:Thomas Greaney
//Student ID:19258909

public class Track implements Comparable<Track>{

    private String title, artist;
    private int year, duration;

    public Track(String title, String artist){
        this.title = title;
        this.artist = artist;
        this.year = 0;
        this.duration = 0;
    }

    public Track(String title, String artist, int year, int duration){
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.duration = duration;
    }

    public String toString(){
        return ("\n"+this.title + "\n"+this.artist+"\n"+this.year+"\n"+String.format("%02d:%02d", this.duration / 60, this.duration % 60)+"\n");
    }

    public int compareTo(Track other){
        return this.title.compareToIgnoreCase(other.title);
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public String getArtist(){
        return this.artist;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getYear(){
        return this.year;
    }

    public void setDuration(int seconds){
        this.duration = seconds;
    }

    public int getDuration(){
        return this.duration;
    }
}