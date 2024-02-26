/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songs;

/**
 *
 * @author student
 */
public class Song {
    
    private String name, artist;
    
    public Song(String name, String artist){
        this.name = name;
        this.artist = artist;
        
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getArtist(){
        return this.artist;
    }
    
    public void setArtist(String artist){
        this.artist = artist;
    }
}
