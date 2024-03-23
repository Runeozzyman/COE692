/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import helper.userInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import songs.Song;
import persistence.user_CRUD;
/**
 *
 * @author student
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        
        
        helper.userInfo dbt = user_CRUD.read(username, password);
        
        userInfo uinfo = getUserInfo(username, password);
        request.setAttribute("uinfo", uinfo);
        
        if(username == null || password == null || username.isEmpty() || password.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("loginfailed.jsp");
            rd.forward(request, response);
        }
        else if (dbt==null){
            RequestDispatcher rd = request.getRequestDispatcher("loginfailed.jsp");
            rd.forward(request, response);
        }
        else{
            request.getSession().setAttribute("uname", username);
            request.setAttribute("userSongs" , uinfo.getAllSongs());
            
            RequestDispatcher rd = request.getRequestDispatcher("userSongs.jsp");
            rd.forward(request, response);       
        
        }
            
    }
    
    private userInfo getUserInfo(String uname, String password){
        
        userInfo uf = new userInfo();
        
        try{
            uf.addSong(new Song("Shiver", "John Summit"));
            uf.addSong(new Song("Rhythm Machine", "Westend"));
            uf.addSong(new Song("Biggest Regret", "Gorgon City"));
            uf.addSong(new Song("Children", "Tinlicker"));
            uf.addSong(new Song("Upside Down", "Meduza"));
            uf.addSong(new Song("Mwaki", "Zerb"));
        } catch (Exception ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println("Error");
        }
        return uf; 
    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
