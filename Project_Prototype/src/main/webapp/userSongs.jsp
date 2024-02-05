<%-- 
    Document   : userSongs
    Created on : Feb 5, 2024, 12:44:57 PM
    Author     : student
--%>

<%@page import="java.util.ArrayList" %>
<%@ page import="songs.Song" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="jspStyles.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>theQ</title>
    </head>

    <body style="background-color: black;" >
        
        <FONT style="color: white;"> 
        <center><h1 style="font-family: Montserrat;">welcome to the future of music<span style="color: rgb(100, 178, 241);"> <%=session.getAttribute("uname")%></span>.</h1></center>
        </FONT>
        
        <%
            ArrayList<Song> songs = (ArrayList)request.getAttribute("userSongs");
        %>
        
        <br></br>
        <br></br>
        <br></br>
        
        <FONT style="color: white;"> 
        <center><h3 style="font-family: Montserrat;"> you've got great taste, here's your songs</h3></center>
        </FONT>
        
        <form action ="Extend" method="post" style="background-color: black">
            
            <table align="center" cellpadding = "5" cellspacing = "5" style = "background-color: white; border-radius: 10px; border: 2px; text-align: center;">
                <tr>
                    <th style = "font-family: Montserrat;">Song Name</th>
                    <th style = "font-family: Montserrat;">Artist</th>
                       
                    <% 
                    for(Song song : songs){
                    %>
                    
                </tr>
                <td style="font-family: Montserrat"> <%=song.getName()%> </td> 
                <td style="font-family: Montserrat"> <%=song.getArtist()%></td>
                
                <% } %>
                
            </table>
           
        </form>
        
                <br></br>
               
                <form action="Explore" method="post">
                    
                    <center><input type ="submit" value="explore" style="font-family: Montserrat;"></center>
                    
                </form>
        
        
        
    </body>

</html> 
