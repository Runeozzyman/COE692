
package Frontend.helper;

/**
 *
 * @author student
 */
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

 @XmlRootElement(name = "books")
@XmlAccessorType (XmlAccessType.FIELD)
       public class SongsXML{
     @XmlElement(name="book")
           private ArrayList<Song> songs;
           
           
           public List<Song>getSongs(){
               return songs;
               
           }
           SongsXML(){
               
               
           }
           public void setSongs(ArrayList<Song> bs){
               songs=bs;
               
           }
           
       }
