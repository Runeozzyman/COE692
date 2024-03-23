/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend.helper;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author student
 */
@XmlRootElement(name = "song")
@XmlAccessorType(XmlAccessType.FIELD)
public class Song {

    private String name; 
    private String artist;

    public Song(){
        
    }
   public Song(String name, String artist){
        this.name = name;
        this.artist = artist;
        
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

}

