/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(urlPatterns = {"/home"})
public class home extends HttpServlet {
    
   static final String database_url = "jdbc:mysql://localhost:3306/cetim?serverTimezone=UTC";
   static final String user = "root";
   static final String pass = "";

    protected void doPost (HttpServletRequest r, HttpServletResponse s)
          throws ServletException, IOException {
       
        try  {
             s.setContentType("text/html");
            //PrintWriter out = s.getWriter();
            String username1=getServletConfig().getInitParameter("username");
            String password1=getServletConfig().getInitParameter("password");
           String username=r.getParameter("username");
           String password=r.getParameter("password");
           
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection(database_url, user, pass);
          String sql="SELECT * FROM technicien WHERE Username=? AND Password=?";
             
              
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            
          ResultSet  rs = ps.executeQuery();
        
          if(rs.next()){
              RequestDispatcher rd=r.getRequestDispatcher("/hometech.jsp");
              rd.forward(r,s);
          } 
          else if(username.equals(username1)&& password.equals(password1)){
               RequestDispatcher rd=r.getRequestDispatcher("/homeadmin.jsp");
               rd.forward(r,s);
			
            }
	else{
            //out.print("<p style='color:red'>Sorry username or password error!</p>");
            RequestDispatcher rd=r.getRequestDispatcher("/index.jsp");
            r.setAttribute("x", "<p style='color:red'>Mot de passe ou nom d'utilisateur erroné!</p>");
            rd.forward(r,s);
		}
           
    }
        catch(Exception e){e.printStackTrace();}
    }

    }

 



