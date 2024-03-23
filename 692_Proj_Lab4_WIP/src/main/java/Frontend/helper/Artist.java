/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend.helper;

/**
 *
 * @author student
 */
public class Artist {
    String name;

    public String getName() {
        return name;
    }

    public Artist(String name) {
        this.name = name;
    }
    public Artist() {
        this.name = null;
    }
    @Override
    public String toString(){
        return(name);
    }
    
    
}
