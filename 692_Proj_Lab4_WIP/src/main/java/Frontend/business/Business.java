/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend.business;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.io.IOUtils;
import Frontend.helper.SongsXML;
import Frontend.helper.Song;


/**
 *
 * @author student
 */
public class Business {
    
    public static boolean isAuthenticated(String username, String passwrod) {
        return true;
    }

    public static SongsXML getServices(String query) throws IOException {
    // Create a new client to send requests to the search service
    Client searchclient = ClientBuilder.newClient();
    // Specify the target URL of the search service
    WebTarget searchwebTarget = searchclient.target("http://localhost:8080/SearchSongs/webresources/search");
    // Send a GET request to the specified path with the query and receive the response as an InputStream
    InputStream is = searchwebTarget.path(query).request(MediaType.APPLICATION_XML).get(InputStream.class);
    // Convert the InputStream to a String containing XML data
    String xml = IOUtils.toString(is, "utf-8");
    // Convert the XML String to SongsXML objects
    SongsXML songs = songxmltoObjects(xml);

    return songs; // Return the SongsXML objects
}

/**
 * Converts XML string to SongsXML objects.
 *
 * @param xml XML string to be converted.
 * @return SongsXML object populated with data from the XML string.
 */
private static SongsXML songxmltoObjects(String xml) {
    JAXBContext jaxbContext;
    try {
        // Initialize JAXB context for the SongsXML class
        jaxbContext = JAXBContext.newInstance(SongsXML.class);
        // Create an Unmarshaller from the JAXB context
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        // Unmarshal the XML string into a SongsXML object
        SongsXML songs = (SongsXML) jaxbUnmarshaller.unmarshal(new StringReader(xml));
        return songs;
    } catch (JAXBException e) {
        e.printStackTrace();
        return null;
    }
}

}
