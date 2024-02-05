/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import songs.Song;
/**
 *
 * @author student
 */
public class userInfo {

    private ArrayList<Song> songList = new ArrayList<>();
    
    public void addSong(Song song){
        songList.add(song);
    }
    
    public ArrayList<Song> getAllSongs(){
        return songList;
    }
    
    
}
