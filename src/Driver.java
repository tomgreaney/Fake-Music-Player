//Author:Thomas Greaney
//Student ID:19258909

public class Driver {
    public static void main(String args[]) {
        //Testing Track Class
        Track myFavouriteSong = new Track("Fake Plastic Trees", "Radiohead", 1995, 291);
        Track mySecondFavouriteSong = new Track("Gran Torino", "Jamie Cullum");

        System.out.println("My favourite song is: \n" + myFavouriteSong.toString());
        System.out.println("My second favourite song is: \n" + mySecondFavouriteSong);
        System.out.println("The title of my favourite song is " + myFavouriteSong.getTitle() + ".");
        System.out.println("The artist who wrote my favourite song is " + myFavouriteSong.getArtist() + ".");
        System.out.println("The year my favourite song was recorded is " + myFavouriteSong.getYear() + ".");
        System.out.println("The length of my favourite song is " + myFavouriteSong.getDuration() + " seconds.");

        myFavouriteSong.setTitle("American Pie");
        myFavouriteSong.setArtist("Don McLean");
        myFavouriteSong.setYear(1971);
        myFavouriteSong.setDuration(511);

        System.out.println("\nThe title of my new favourite song is " + myFavouriteSong.getTitle() + ".");
        System.out.println("The artist who wrote my new favourite song is " + myFavouriteSong.getArtist() + ".");
        System.out.println("The year my new favourite song was recorded is " + myFavouriteSong.getYear() + ".");
        System.out.println("The length of my new favourite song is " + myFavouriteSong.getDuration() + " seconds.");

        if (myFavouriteSong.compareTo(mySecondFavouriteSong) < 0) {
            System.out.println("\nMy favourite song's title comes before my second favourite songs title when ordered alphabetically.");
        }else if (myFavouriteSong.compareTo(mySecondFavouriteSong) > 0){
            System.out.println("\nMy favourite song's title comes after my second favourite songs title when ordered alphabetically.");
        }else{
            System.out.println("\nMy favourite song's title comes either before or after my second favourite songs title when ordered alphabetically.");
        }

        //Testing Playlist Class
        Playlist myMixTape = new Playlist("Mix-Tape");

        System.out.println("\nThe name of my default playlist is " + myMixTape.getPlaylistName() + ".");

        System.out.println("\nShow mixTape before adding any songs to it:");
        myMixTape.showList();

        myMixTape.add(myFavouriteSong);
        myMixTape.add("Stan", "Eminem");
        myMixTape.add("Creep", "Radiohead", 1992, 239);
        myMixTape.add("Song1", "Artist2", 2001, 120);
        myMixTape.add("Song2", "Artist1", 2001, 121);
        myMixTape.add("Song3", "Artist2", 2002, 122);
        myMixTape.add("Song4", "Artist1", 2002, 123);
        myMixTape.add("Song5", "Artist2", 2002, 124);

        System.out.println("\nShow mixTape after adding songs to it:");
        myMixTape.showList();

        Playlist FamilyFriendlyMusic = new Playlist();
        FamilyFriendlyMusic.add(mySecondFavouriteSong);
        FamilyFriendlyMusic.add("Pianoman", "Billy Joel");
        FamilyFriendlyMusic.add("Bohemian Rhapsody", "Queen", 1975, 354);

        System.out.println("\nThe instance values in myMixTape are:\n" + myMixTape.toString());
        System.out.println("\nThe instance values in FamilyFriendlyMusic are:\n" + FamilyFriendlyMusic.toString());

        System.out.println("\nPlay all songs in FamilyFriendlyMusic in sequential order:");
        FamilyFriendlyMusic.play(false);

        System.out.println("\nPlay all songs in myMixTape in random order:");
        myMixTape.play(true);

        System.out.println("\nRemove a track titled aMeriCaN pIe from myMixTape...");
        myMixTape.remove("aMeriCaN pIe");
        System.out.println("Add my second favourite song to myMixTape...");
        myMixTape.add(mySecondFavouriteSong);
        System.out.println("Rename myMixTape to 'Mix-Tape-Volume2'...");
        myMixTape.setPlaylistName("Mix-Tape-Volume2");

        System.out.println("\nThe instance values in myMixTape are:\n" + myMixTape.toString());

        System.out.println("\nPlay songs only by 'Artist2' from myMixTape");
        myMixTape.playOnly("Artist2");

        System.out.println("\nPlay songs only by 'aRT' from myMixTape");
        myMixTape.playOnly("aRT");

        System.out.println("\nPlay songs only from 2002 from myMixTape");
        myMixTape.playOnly(2002);
    }
}